import java.io.IOException;
import java.util.ArrayList;
//import java.util.Dictionary;
import java.util.List;
import feed.FeedParser;
// named entities package
import ne.heuristics.CapitalizedWordHeuristic;
import ne.NamedEntities;
import ne.heuristics.SemanticNeighborg;
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
            List<Article> allArticles = FeedParser.parseXML(FeedParser.fetchFeed(feedsDataArray.get(0).getUrl()));
            
            // TODO: Populate allArticles with articles from corresponding feed
            if (config.getPrintFeed()) {
                System.out.println("Printing feed(s) ");
                // TODO: Print the fetched feed
                for (Article article : allArticles) {
                    article.toString(article.getTitle(), article.getDescrpition(), article.getPubDate(), article.getLink());

                }
            }

            if (config.getComputeNamedEntities()) {
                // TODO: complete the message with the selected heuristic name
                String heuristicName = config.getHeuristic();
                System.out.println("Computing named entities using " + heuristicName + " heuristic");

                // TODO: compute named entities using the selected heuristic
                
                if (heuristicName.equals("CapitalizedWordHeuristic")) {
                    List<String> words = new ArrayList<>(); //creamos arreglo de palabras para trabajar con la heruistica capital letters
                    CapitalizedWordHeuristic heuristic = new CapitalizedWordHeuristic(); //creamos un objeto de la clase heuristic
                    words = heuristic.extractCandidates(FeedParser.fetchFeed(feedsDataArray.get(0).getUrl())); //extraemos las palabras candidatas
                    words.forEach(System.out::println); //imprimimos las palabras candidatas
                    //ahora deberiamos pasarlas por el diccionario para ver los topicos y categorias 
                    //y luego agregarlas al arreglo de named entities
                    for (String word : words) {
                        for (DictionaryData data : dataDict) {
                            if (word.equals(data.getKeyword())) {//es igual a la primera palabra o a todas?
                                List <String> topics = new ArrayList<>();
                                for(String topic : data.getTopic()){
                                    topics.add(topic);
                                }
                                namedEnt.add(new NamedEntities(data.getCategory(),  topics , data.getLabel()));
                            }else {
                                List <String> topics = new ArrayList<>();
                                topics.add("Other");
                                namedEnt.add(new NamedEntities("Other",  topics , data.getLabel()));
                            }

                        }
                    }
                }
                if (heuristicName.equals("SemanticNeighborg")){
                    List<String> words = new ArrayList<>(); //creamos arreglo de palabras para trabajar con la heruistica capital letters
                    SemanticNeighborg heuristic = new SemanticNeighborg(); //creamos un objeto de la clase heuristic
                    words = heuristic.extractCandidates(FeedParser.fetchFeed(feedsDataArray.get(0).getUrl())); //extraemos las palabras candidatas
                    words.forEach(System.out::println); //imprimimos las palabras candidatas
                    //ahora deberiamos pasarlas por el diccionario para ver los topicos y categorias 
                    //y luego agregarlas al arreglo de named entities
                    for (String word : words) {
                        for (DictionaryData data : dataDict) {
                            if (word.equals(data.getKeyword())) {//es igual a la primera palabra o a todas?
                                List <String> topics = new ArrayList<>();
                                for(String topic : data.getTopic()){
                                    topics.add(topic);
                                }
                                namedEnt.add(new NamedEntities(data.getCategory(),  topics , data.getLabel()));
                            }else {
                                List <String> topics = new ArrayList<>();
                                topics.add("Other");
                                namedEnt.add(new NamedEntities("Other",  topics , data.getLabel()));
                            }

                        }
                    }
                }

                // TODO: Print stats
                System.out.println("\nStats: ");
                //Default stats for category  
                System.out.println("Category-wise stats: ");
                Stats stats = new Stats();
                stats.countCategory(namedEnt);
                for (String key : stats.categoryCount.keySet()) {
                    System.out.println(key + ": " + stats.categoryCount.get(key));
                }

                System.out.println("-".repeat(80));
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
        System.out.println("                                       <name>: <description>");
        System.out.println("  -pf, --print-feed:                   Print the fetched feed");
        System.out.println("  -sf, --stats-format <format>:        Print the stats in the specified format");
        System.out.println("                                       Available formats are: ");
        System.out.println("                                       cat: Category-wise stats");
        System.out.println("                                       topic: Topic-wise stats");
    }

}
