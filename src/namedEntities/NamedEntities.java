
import java.util.Date;
import java.util.List;
import java.util.Locale.Category;
enum String {PERSON, LOCATION, ORGANIZATION, OTHER};
enum Topics {POLITICS, SPORTS, ECONOMY, HEALTH, TECHNOLOGY, CULTURE, OTHER};


public class NamedEntities {
   private String category;
   private List <String> topics;   
   private String name ;
   public NamedEntities (String category, List<String> topics, String name) {
       this.category = category ;
       this.topics = topics ;
       this.name = name;
   }
// getters
   public String getCategory(){
       return category;
   }
   public Topics[] getTopics(){ 
        Topics top[] = new Topics[topics.size()];
        return topics.toArray(top);
   }//dudoso cuestionable parcialmente mal complicado inneceario
   public String getName(){
       return name;
   }
//setters 
   public void setCategory(String category){
       this.category = category;
   }
   public void setTopics(String topics){
         this.topics.add(topics);
   }
   public void setName(String name){
       this.name = name;
   }
// metodos
}
//modelado de categorias posiblemente se necesite añadirlas a otro archivo 
class Person extends NamedEntities {
    //atributos unicos para cada categoria
    private Date birth;
    private int age;
    private int height; 
    //constructors
    public Person(String category, List<String> topics, String name) {
        super(category, topics, name);
    }
    public Person(String category, List<String> topics, String name, Date birth, int age, int height) {
        super(category, topics, name);
        this.birth = birth;
        this.age = age;
        this.height = height;
    }
    //getters 
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
class Location extends NamedEntities {
    private String longitud; 
    private String latitud;
    //constructors
    public Location(String category, List<String> topics, String name) {
        super(category, topics, name);
    }
    public Location(String category, List<String> topics, String name, String longitud, String latitud) {
        super(category, topics, name);
        this.longitud = longitud;
        this.latitud = latitud;
    }
    //getters
    public String getLongitud(){
        return longitud;
    }
    public String getLatitud(){
        return latitud;
    }
}
class Organization extends NamedEntities {
    private Date fundationDate;
    private String website;
    //constructors
    public Organization(String category, List<String> topics, String name) {
        super(category, topics, name);
    }
    public Organization(String category, List<String> topics, String name, Date fundationDate, String website) {
        super(category, topics, name);
        this.fundationDate = fundationDate;
        this.website = website;
    }
    //getters
    public Date getFundationDate(){
        return fundationDate;
    }
    public String getWebsite(){
        return website;
    }
}
class Other extends NamedEntities {
    private String description;
    //constructors
    public Other(String category, List<String> topics, String name) {
        super(category, topics, name);
    }
    public Other(String category, List<String> topics, String name, String description) {
        super(category, topics, name);
        this.description = description;
    }
    //getters
    public String getDescription(){
        return description;
    }
    
}
//modelado de topics posiblemente se necesite añadirlas a otro archivo



