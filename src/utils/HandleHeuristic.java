package utils;
import ne.NamedEntities;
import java.util.List;
import java.util.ArrayList;
import ne.heuristics.CapitalizedWordHeuristic;
import utils.DictionaryData;
import ne.heuristics.FiltredCwh;
public class HandleHeuristic {
    public List<NamedEntities> handleString(String confHeuristic, String fetchedUrl, List<DictionaryData> dataDict, String articlesToString) {
        List<NamedEntities> namedEnt = new ArrayList<>();
        if(confHeuristic.equals("CapitalizedWordHeuristic")){
            List<String> words = new ArrayList<>(); 
            CapitalizedWordHeuristic heuristic = new CapitalizedWordHeuristic(); 
            words = heuristic.extractCandidates(fetchedUrl); 
            for (String word : words) {
                for (DictionaryData data : dataDict) {
                    for (String datakey : data.getKeyword()){
                        if (word.equals(datakey.replaceAll("[\\[\\]\"]", ""))) {
                            List <String> topics = new ArrayList<>();
                            for(String topic : data.getTopic()){
                                topics.add(topic);
                            }
                            namedEnt.add(new NamedEntities(data.getCategory(),  data.getTopic() , data.getLabel()));
                        }
                    }
                }
            }
        }
        if(confHeuristic.equals("FiltredCwh")){
            List<String> words = new ArrayList<>();
            FiltredCwh heuristic = new FiltredCwh(); 
            words= heuristic.filterCandidates(articlesToString);
            for (String word : words) {
                for (DictionaryData data : dataDict) {
                    for (String datakey : data.getKeyword()){
                        if (word.equals(datakey.replaceAll("[\\[\\]\"]", ""))) {
                            List <String> topics = new ArrayList<>();
                            for(String topic : data.getTopic()){
                                topics.add(topic);
                            }
                            namedEnt.add(new NamedEntities(data.getCategory(),  data.getTopic() , data.getLabel()));
                        }
                    }
                }
            }
        }
        return namedEnt;
    }
    
}
