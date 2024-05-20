
import java.util.Date;

enum Category {PERSON, LOCATION, ORGANIZATION, OTHER};
enum Topics {POLITICS, SPORTS, ECONOMY, HEALTH, TECHNOLOGY, CULTURE, OTHER};


public class NamedEntities {
   private Category category;
   private Topics topics;
   private String name ;
   public NamedEntities (Category category, Topics topic, String name) {
       this.category = category ;
       this.topics = topic ;
       this.name = name;
   }
// getters
   public Category getCategory(){
       return category;
   }
   public Topics getTopics(){
       return topics;
   }
   public String getName(){
       return name;
   }
//setters 
   public void setCategory(Category category){
       this.category = category;
   }
   public void setTopics(Topics topics){
       this.topics = topics;
   }
   public void setName(String name){
       this.name = name;
   }
// metodos
}
//modelado de categorias posiblemente se necesite añadirlas a otro archivo 
class Person extends NamedEntities {
    private Date birth;
    private int age;
    private int height; 
    public Person (String name){
        super(Category.PERSON, Topics.OTHER, name);
    }
    public Person (String name, Date birth, int age, int height){
        super(Category.PERSON, Topics.OTHER, name);
        this.birth = birth;
        this.age = age;
        this.height = height;
    }
    public Person (String name, Date birth, int age){
        super(Category.PERSON, Topics.OTHER, name);
        this.birth = birth;
        this.age = age;
    }
    public Person (String name, Date birth){
        super(Category.PERSON, Topics.OTHER, name);
        this.birth = birth;
    }
    //atributos unicos para cada categoria
}
class Location extends NamedEntities {
    private String longitud; 
    private String latitud;
    public Location (String name){
        super(Category.LOCATION, Topics.OTHER, name);
    }
    public Location (String name, String longitud, String latitud){
        super(Category.LOCATION, Topics.OTHER, name);
        this.longitud = longitud;
        this.latitud = latitud;
    }
    
}
class Organization extends NamedEntities {
    private Date fundationDate;
    private String website;
    public Organization (String name){
        super(Category.ORGANIZATION, Topics.OTHER, name);
    }
    public Organization (String name, Date fundationDate, String website){
        super(Category.ORGANIZATION, Topics.OTHER, name);
        this.fundationDate = fundationDate;
        this.website = website;
    }
}
class Other extends NamedEntities {
    private String description;
    public Other (String name){
        super(Category.OTHER, Topics.OTHER, name);
    }
    public Other (String name, String description){
        super(Category.OTHER, Topics.OTHER, name);
        this.description = description;
    }
    //atributos unicos para cada categoria
}
//modelado de topics posiblemente se necesite añadirlas a otro archivo



