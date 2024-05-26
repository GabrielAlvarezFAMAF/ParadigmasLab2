import java.io.IOException;
import java.util.ArrayList;
//import java.util.Dictionary;
import java.util.List;
import feed.FeedParser;
import feed.FeedSelect;
// named entities package
import ne.heuristics.CapitalizedWordHeuristic;
import ne.NamedEntities;
//import ne.heuristics.SemanticNeighborg;
// ----------------------------------------
import feed.Article;
import utils.Config;
import utils.DictionaryData;
import utils.FeedsData;
import utils.JSONParser;
import utils.UserInterface;
import java.net.MalformedURLException;
import utils.Stats;
//import java.util.List;
import java.lang.String;
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
        if (config.getPrinthelp()) {
            printHelp(feedsDataArray);
            return; 
        }

        //parseo del diccionario para usarse posteriormente
        //-------------------------------------------------------------------------
        List<DictionaryData> dataDict = new ArrayList<>();
        List<NamedEntities> namedEnt = new ArrayList<>(); //creamos arreglo de named entities
        try {
            dataDict = JSONParser.parseJsonDictionaryData("src/data/dictionary.json");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error parsing dictionary data");
        }

        //--------------------------------------------------------------------------
        try {
            // feed ----------------------------------------------------------------
            FeedSelect feedSelect = new FeedSelect(); 
            List<Article> allArticles = new ArrayList<>(); 
            String fetchedUrl = "";
            feedSelect.pString(config.getFeedKey());
            if (!(null == (feedSelect.gString()))) { 
                allArticles = feedSelect.selectOne(config.getFeedKey(), feedsDataArray);       
                fetchedUrl = feedSelect.getfetchedUrl();
            }
            else {
                allArticles = FeedParser.parseXML(FeedParser.fetchFeed(feedsDataArray.get(0).getUrl()));
                fetchedUrl =FeedParser.fetchFeed(feedsDataArray.get(0).getUrl());
            }
                // TODO: Populate allArticles with articles from corresponding feed
            if (config.getPrintFeed()) {
                feedSelect.printFeed(allArticles, feedsDataArray);
            }
            // feed -----------------------------------------------------------------
            
            if (config.getComputeNamedEntities()) {
                // TODO: complete the message with the selected heuristic name
                String heuristicName = config.getHeuristic();
                System.out.println("Computing named entities using " + heuristicName + " heuristic");

                // TODO: compute named entities using the selected heuristic
                if (heuristicName.equals("CapitalizedWordHeuristic")) {
                    List<String> words = new ArrayList<>(); //creamos arreglo de palabras para trabajar con la heruistica capital letters
                    CapitalizedWordHeuristic heuristic = new CapitalizedWordHeuristic(); //creamos un objeto de la clase heuristic
                    words = heuristic.extractCandidates(fetchedUrl); //extraemos las palabras candidatas
                    for (String word : words) {
                        for (DictionaryData data : dataDict) {
                            for (String i : data.getKeyword()){
                                if (word.equals(i.replaceAll("[\\[\\]\"]", ""))) {
                                    List <String> topics = new ArrayList<>();
                                    for(String topic : data.getTopic()){
                                        topics.add(topic);
                                    }
                                    namedEnt.add(new NamedEntities(data.getCategory(),  topics , data.getLabel()));
                                }
                            }
                        }
                    }
                    //print de named entities
                    System.out.println("Named Entities: ");
                    for(NamedEntities entity : namedEnt){
                        System.out.println(entity.getCategory() + entity.getTopics()+ entity.getName());
                    }
                // if (heuristicName.equals("SemanticNeighborg")){
                //     List<String> words = new ArrayList<>();
                //     SemanticNeighborg heuristic = new SemanticNeighborg(); 
                //     words = heuristic.extractCandidates(FeedParser.fetchFeed(feedsDataArray.get(0).getUrl())); 
                //     words.forEach(System.out::println); 
                //     for (String word : words) {
                //         for (DictionaryData data : dataDict) {
                //             if (word.equals(data.getKeyword())) {//es igual a la primera palabra o a todas?
                //                 List <String> topics = new ArrayList<>();
                //                 for(String topic : data.getTopic()){
                //                     topics.add(topic);
                //                 }
                //                 namedEnt.add(new NamedEntities(data.getCategory(),  topics , data.getLabel()));
                //             }else {
                //                 List <String> topics = new ArrayList<>();
                //                 topics.add("Other");
                //                 namedEnt.add(new NamedEntities("Other",  topics , data.getLabel()));
                //             }

                //         }
                //     }
                // }


            }
        }
        if(config.stats().getPrintStats()){
         // TODO: Print stats
            System.out.println("\nStats: ");
            //Default stats for category  
            System.out.println(" in the app  format " + config.stats().getFormat()); 
            if (config.stats().getFormat().equals("cat")) {
                System.out.println("Category-wise stats: ");
                Stats stats = config.stats();
                stats.countCategory(namedEnt);
                    for (String key : stats.categoryCount.keySet()) {
                        System.out.println(key + ": " + stats.categoryCount.get(key));
                    }
                System.out.println("-".repeat(80));
            }
            //Default stats for topic
            if (config.stats().getFormat().equals("topic")) {
                System.out.println("Topic-wise stats: ");
                Stats stats = config.stats();
                stats.countTopic(namedEnt);
                    for (List<String> key : stats.topicCount.keySet()) {
                        System.out.println(key + ": " + stats.topicCount.get(key));
                    }
                System.out.println("-".repeat(80));
            }
        }
    } catch (MalformedURLException e) {
        e.printStackTrace();
        System.out.println("Malformed URL");
    } catch (IOException e) {
        e.printStackTrace();
        System.out.println("IO Exception");
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Exception");
        } 
    }
    
        //dudoso catch Exception e 

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
        System.out.println("                                       CapitalizedWordHeuristic: captures capitalized words ");

        System.out.println("  -pf, --print-feed:                   Print the fetched feed");
        System.out.println("  -sf, --stats-format <format>:        Print the stats in the specified format");
        System.out.println("                                       Available formats are: ");
        System.out.println("                                       cat: Category-wise stats");
        System.out.println("                                       topic: Topic-wise stats");
    }

}
