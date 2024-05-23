
package utils;
import java.util.HashMap;
import java.util.List;
import ne.NamedEntities;
public class Stats {
    private HashMap<String,Integer> categoryCount;
    private HashMap<List<String>, Integer> topicCount;

    public Stats() {
        categoryCount= new HashMap<>();
    }
    public Stats(Integer x ){ // mejorable flag para diferenciar entre category y topic (Integer) 
        topicCount = new HashMap<>();
    }

     public HashMap<String,Integer> countCategory( List<NamedEntities> entitys){
        for (NamedEntities entity : entitys) {
            // Check if the category exists in the outer map
            if (!categoryCount.containsKey(entity.getCategory())) {
                categoryCount.put( entity.getCategory(),1);
            }else {
                // Update the count for the category
                categoryCount.put(entity.getCategory(), categoryCount.get(entity.getCategory()) + 1);
            }
        }
        //done by me
        return categoryCount;
     }
        public HashMap<List<String>,Integer> countTopic( List<NamedEntities> entitys){
            for (NamedEntities entity : entitys) {
                // Check if the category exists in the outer map
                if (!topicCount.containsKey(entity.getTopics())) {
                    topicCount.put( entity.getTopics(),1);
                }else {
                    // Update the count for the category
                    topicCount.put(entity.getTopics(), topicCount.get(entity.getTopics()) + 1);
                }
            }
        // done by copilot 
            return topicCount;
        }
}
