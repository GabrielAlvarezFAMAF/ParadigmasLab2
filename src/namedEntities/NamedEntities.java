//package namedEntities; error aca no se por que 


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
    public Person (String name){
        super(Category.PERSON, Topics.OTHER, name);
    }
    //atributos unicos para cada categoria
}
class Location extends NamedEntities {
    public Location (String name){
        super(Category.LOCATION, Topics.OTHER, name);
    }
    //atributos unicos para cada categoria
}
class Organization extends NamedEntities {
    public Organization (String name){
        super(Category.ORGANIZATION, Topics.OTHER, name);
    }
    //atributos unicos para cada categoria
}
class Other extends NamedEntities {
    public Other (String name){
        super(Category.OTHER, Topics.OTHER, name);
    }
    //atributos unicos para cada categoria
}
//modelado de topics posiblemente se necesite añadirlas a otro archivo



