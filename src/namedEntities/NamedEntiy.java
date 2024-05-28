package namedEntities;
import java.util.Date;
import java.util.List;
import java.lang.String;


public class NamedEntiy {
   private String category;
   private List <String> topics;   
   private String name ;
   public NamedEntiy (String category, List<String> topics, String name) {
       this.category = category ;
       this.topics = topics ;
       this.name = name;
   }

   public String getCategory(){
       return category;
   }
   public List <String>  getTopics(){ 
        return topics;
   }
   public String getName(){
       return name;
   }

   public void setCategory(String category){
       this.category = category;
   }
   public void setTopics(String topics){
         this.topics.add(topics);
   }
   public void setName(String name){
       this.name = name;
   }

}

class Person extends NamedEntiy {
    private Date birth;
    private int age;
    private int height; 
    public Person( List<String> topics, String name) {
        super("Person", topics, name);
    }
    public Person(List<String> topics, String name, Date birth, int age, int height) {
        super("Person", topics, name);
        this.birth = birth;
        this.age = age;
        this.height = height;
    }
    public Date getBirth(){
        return birth;
    }
    public int getAge(){
        return age;
    }
    public int getHeight(){
        return height;
    }
}
class Location extends NamedEntiy {
    private String longitud; 
    private String latitud;
    public Location(List<String> topics, String name) {
        super("Location", topics, name);
    }
    public Location(List<String> topics, String name, String longitud, String latitud) {
        super("Location", topics, name);
        this.longitud = longitud;
        this.latitud = latitud;
    }
    public String getLongitud(){
        return longitud;
    }
    public String getLatitud(){
        return latitud;
    }
}
class Organization extends NamedEntiy {
    private Date fundationDate;
    private String website;
    public Organization(List<String> topics, String name) {
        super("Organization", topics, name);
    }
    public Organization(List<String> topics, String name, Date fundationDate, String website) {
        super("Organization", topics, name);
        this.fundationDate = fundationDate;
        this.website = website;
    }
    public Date getFundationDate(){
        return fundationDate;
    }
    public String getWebsite(){
        return website;
    }
}
class Other extends NamedEntiy {
    private String description;
    public Other(List<String> topics, String name) {
        super("Other", topics, name);
    }
    public Other(List<String> topics, String name, String description) {
        super("Other", topics, name);
        this.description = description;
    }
    public String getDescription(){
        return description;
    }
    
}




