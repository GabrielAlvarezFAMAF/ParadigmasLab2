package ne;
import java.util.Date;
import java.util.List;
import java.lang.String;


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
   public List <String>  getTopics(){ 
        return topics;
   }//dudoso cuestionable parcialmente mal complicado inneceario
   // aca hay que mejorar claramente 
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
    public Person( List<String> topics, String name) {
        super("Person", topics, name);
    }
    public Person(List<String> topics, String name, Date birth, int age, int height) {
        super("Person", topics, name);
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
    public Location(List<String> topics, String name) {
        super("Location", topics, name);
    }
    public Location(List<String> topics, String name, String longitud, String latitud) {
        super("Location", topics, name);
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
    public Organization(List<String> topics, String name) {
        super("Organization", topics, name);
    }
    public Organization(List<String> topics, String name, Date fundationDate, String website) {
        super("Organization", topics, name);
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
    public Other(List<String> topics, String name) {
        super("Other", topics, name);
    }
    public Other(List<String> topics, String name, String description) {
        super("Other", topics, name);
        this.description = description;
    }
    //getters
    public String getDescription(){
        return description;
    }
    
}
//modelado de topics posiblemente se necesite añadirlas a otro archivo



