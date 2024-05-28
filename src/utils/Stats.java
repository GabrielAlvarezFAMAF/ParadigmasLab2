
package utils;
import java.util.HashMap;
import java.util.List;

import namedEntities.NamedEntiy;

import java.util.ArrayList;
public class Stats {
    private String format;
    private Boolean printStats=false;
    private HashMap<String, Integer> categoryCount;
    private HashMap<String, Integer> topicCount;

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
     public HashMap<String,Integer> countCategory( List<NamedEntiy> entitys){
        for (NamedEntiy entity : entitys) {
            if (!categoryCount.containsKey(entity.getCategory())) {
                categoryCount.put(entity.getCategory(),1);
            }else {
                categoryCount.put(entity.getCategory(), categoryCount.get(entity.getCategory()) + 1);
            }
        }
        //print hashmap
        return categoryCount;
     }
     public HashMap<String,Integer> countTopic( List<NamedEntiy> entitys){
        List<String> topics = new ArrayList<>();
        for (NamedEntiy entity : entitys) {
            topics = entity.getTopics();
            for (String topic : topics){
                topic = topic.replaceAll("[\\[\\]\"]", "");
                if (!topicCount.containsKey(topic)) {
                    topicCount.put(topic,1);
                }else {
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
        public void setPrintStats(Boolean printStats){
            this.printStats = printStats;
        }
        public void setFormat(String format){
            this.format = format;
        } 
}
