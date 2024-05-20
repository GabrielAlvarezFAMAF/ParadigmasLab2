import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import feed.FeedParser;
import feed.Article;
import utils.Config;
import utils.FeedsData;
import utils.JSONParser;
import utils.UserInterface;
import java.net.MalformedURLException;
public class App {

    public static void main(String[] args) {

        List<FeedsData> feedsDataArray = new ArrayList<>();
        try {
            feedsDataArray = JSONParser.parseJsonFeedsData("src/data/feeds.json");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        UserInterface ui = new UserInterface();
        Config config = ui.handleInput(args);

        run(config, feedsDataArray);
    }

    // TODO: Change the signature of this function if needed
    private static void run(Config config, List<FeedsData> feedsDataArray) {

        if (feedsDataArray == null || feedsDataArray.size() == 0) {
            System.out.println("No feeds data found");
            return;
        }

        try {
            List<Article> allArticles = FeedParser.parseXML(FeedParser.fetchFeed(feedsDataArray.get(0).getUrl()));
            // TODO: Populate allArticles with articles from corresponding feeds

            //depuring print 
            for (Article article : allArticles) {
                System.out.println(article.getTitle());
                System.out.println(article.getLink());
                System.out.println(article.getPubDate());
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }//dudoso catch Exception e 
        
        
        if (config.getPrintFeed()) {
            System.out.println("Printing feed(s) ");
            // TODO: Print the fetched feed
        }

        if (config.getComputeNamedEntities()) {
            // TODO: complete the message with the selected heuristic name
            System.out.println("Computing named entities using ");

            // TODO: compute named entities using the selected heuristic

            // TODO: Print stats
            System.out.println("\nStats: ");
            System.out.println("-".repeat(80));
        }
    }

    // TODO: Maybe relocate this function where it makes more sense
    private static void printHelp(List<FeedsData> feedsDataArray) {
        System.out.println("Usage: make run ARGS=\"[OPTION]\"");
        System.out.println("Options:");
        System.out.println("  -h, --help: Show this help message and exit");
        System.out.println("  -f, --feed <feedKey>:                Fetch and process the feed with");
        System.out.println("                                       the specified key");
        System.out.println("                                       Available feed keys are: ");
        for (FeedsData feedData : feedsDataArray) {
            System.out.println("                                       " + feedData.getLabel());
        }
        System.out.println("  -ne, --named-entity <heuristicName>: Use the specified heuristic to extract");
        System.out.println("                                       named entities");
        System.out.println("                                       Available heuristic names are: ");
        // TODO: Print the available heuristics with the following format
        System.out.println("                                       <name>: <description>");
        System.out.println("  -pf, --print-feed:                   Print the fetched feed");
        System.out.println("  -sf, --stats-format <format>:        Print the stats in the specified format");
        System.out.println("                                       Available formats are: ");
        System.out.println("                                       cat: Category-wise stats");
        System.out.println("                                       topic: Topic-wise stats");
    }

}
