package utils;

public class DictionaryData {
    private String label; 
    private String category; 
    private String [] topic;
    private String [] keyword;
    //constructors
    public DictionaryData(String label, String category, String [] topic, String [] keyword) {
        this.label = label;
        this.category = category;
        this.topic = topic;
        this.keyword = keyword;
    }
    //getters
    public String getLabel(){
        return label;
    }
    public String getCategory(){
        return category;
    }
    public String [] getTopic(){
        return topic;
    }
    public String [] getKeyword(){
        return keyword;
    }
}
