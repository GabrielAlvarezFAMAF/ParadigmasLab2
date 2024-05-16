package feed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class FeedParser {

    public static List<Article> parseXML(String xmlData) {
        List <Article> articles = new ArrayList<>();
        String title = "";
        String description = "";
        String link = "";
        Date pubDate = null;
        String[] lines = xmlData.split("\n");
        for (String line : lines) {
            if (line.contains("<title>")) {
                title = line.substring(line.indexOf("<title>") + 7, line.indexOf("</title>"));
            } else if (line.contains("<description>")) {
                description = line.substring(line.indexOf("<description>") + 13, line.indexOf("</description>"));
            } else if (line.contains("<link>")) {
                link = line.substring(line.indexOf("<link>") + 6, line.indexOf("</link>"));
            } else if (line.contains("<pubDate>")) {
                String date = line.substring(line.indexOf("<pubDate>") + 9, line.indexOf("</pubDate>"));
                pubDate = Date.valueOf(date);
            } else if (line.contains("</item>")) {
                articles.add(new Article(title, description, pubDate, link));
            }
        }
        return articles;
    }

    public static String fetchFeed(String feedURL) throws MalformedURLException, IOException, Exception {

        URL url = new URL(feedURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");
        
        // TODO: Cambiar el user-agent al nombre de su grupo.  Done 
        // Si todos los grupos usan el mismo user-agent, el servidor puede bloquear las solicitudes.
        connection.setRequestProperty("Broken", "lab_paradigmas");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        int status = connection.getResponseCode();
        if (status != 200) {
            throw new Exception("HTTP error code: " + status);
        } else {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            connection.disconnect();
            return content.toString();
        }
    }
}
