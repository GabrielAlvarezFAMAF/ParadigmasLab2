
package utils;
import java.util.HashMap;
import java.util.List;

import namedEntities.NamedEntiy;

import java.util.ArrayList;
public class Stats {
    private String format;
    private Boolean printStats=false;
    private HashMap<String, Integer> Count;
    public Stats() {
        Count= new HashMap<>();
        printStats = true;
    }
    public Stats(String format) {
        this.format = format;
        Count= new HashMap<>();
        printStats = true;
    }
     public HashMap<String,Integer> count( List<NamedEntiy> entitys ){
        if (format.equals("cat")) {
            for (NamedEntiy entity : entitys) {
                if (!Count.containsKey(entity.getCategory())) {
                    Count.put(entity.getCategory(),1);
                }else {
                    Count.put(entity.getCategory(),Count.get(entity.getCategory()) + 1);
                }
            }
        }
        else if (format.equals("topic")) {
            for (NamedEntiy entity : entitys) {
                List<String> topics = entity.getTopics();
                for (String topic : topics){
                    topic = topic.replaceAll("[\\[\\]\"]", "");
                    if (!Count.containsKey(topic)) {
                        Count.put(topic,1);
                    }else {
                        Count.put(topic, Count.get(topic) + 1);
                    }   
                }
            }
        }
        return Count;
     }
        public void printStats(HashMap<String,Integer> Count){
            for (String key : Count.keySet()) {
                System.out.println(key + " : " + Count.get(key));
            }
            System.out.println("-".repeat(80));
        }
     
        public HashMap<String,Integer> getCount(){
            return Count;
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
