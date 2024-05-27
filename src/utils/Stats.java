
package utils;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import ne.NamedEntities;
public class Stats {
    private String format;
    private Boolean printStats=false;
    public HashMap<String,Integer> categoryCount;
    public HashMap<String, Integer> topicCount;

    public Stats() {
        format = "";
        categoryCount= new HashMap<>();
        topicCount = new HashMap<>();
    }
    public Stats(String format) {
        if (format.equals("cat") || format.equals("") || format.equals(" ")) {
            categoryCount= new HashMap<>();
        }else if (format.equals("topic")) {
            topicCount = new HashMap<>();
        }else {
            System.out.println("Invalid format");
            System.exit(0);
        }
        this.format = format;
        printStats = true;
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
     public HashMap<String,Integer> countTopic( List<NamedEntities> entitys){
        List<String> topics = new ArrayList<>();
        for (NamedEntities entity : entitys) {
            topics = entity.getTopics();
            for (String topic : topics){
                topic = topic.replaceAll("[\\[\\]\"]", "");
                if (!topicCount.containsKey(topic)) {
                    topicCount.put(topic,1);
                }else {
                    // Update the count for the category
                    topicCount.put(topic, topicCount.get(topic) + 1);
                }   
            }
        }
        return topicCount;
    }

     //getter 
        public HashMap<String,Integer> getCategoryCount(){
            return categoryCount;
        }
        public HashMap<String,Integer> getTopicCount(){
            return topicCount;
        }
        public Boolean getPrintStats(){
            return printStats;
        }
        public String getFormat(){
            return format;
        }
        //setter
        public void setPrintStats(Boolean printStats){
            this.printStats = printStats;
        }
        public void setFormat(String format){
            this.format = format;
        } 
        // hacen falta ? 

        // done by copilot 
}
