package heuristics;

import java.text.Normalizer;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import CapitalizedWordHeuristic;
public class nameHeuristic extends CapitalizedWordHeuristic{
    public List<String> extractCandidates(String text) {
        List<String> candidates = new ArrayList<>();
        text = text.replaceAll("[-+.^:,\"]", "");
        text = Normalizer.normalize(text, Normalizer.Form.NFD);
        text = text.replaceAll("\\p{M}", "");
        Pattern pattern = Pattern.compile("[A-Z][a-z]+(?:\\s[A-Z][a-z]+)*");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            candidates.add(matcher.group());
        }
        return candidates;
    }
   
}

class named extends nameHeuristic{
    List<String> candidates = super.extractCandidates(String text);
    public void readJson(){
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("src/data/dictionary.json"));

            JSONArray jsonArray = (JSONArray) obj;

            for (Object o : jsonArray) {
                JSONObject jsonObject = (JSONObject) o;
                String keyword = (String) jsonObject.get("keyword");
                String name = (String) jsonObject.get("label");
                String category = (String) jsonObject.get("category");
                String topic = (String) jsonObject.get("topic");
                //candidates.add(name);
                // Access the properties of each JSON object and assign them to variables
                // or add them to a list of variables
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
