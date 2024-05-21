package feed;
import java.util.Date;  

public class Article {
    private String title ; 
    private String descrpition ; 
    private String pubDate ; 
    private String link ; 
    //constructor
    public Article(String title, String descrpition, String pubDate, String link){
        this.title = title;
        this.descrpition = descrpition;
        this.pubDate = pubDate;
        this.link = link;
    }
    //getters 
    public String getTitle(){
        return title;
    }   
    public String getDescrpition(){
        return descrpition;
    }   
    public String getPubDate(){
        return pubDate;
    }   
    public String getLink(){
        return link;
    }
    //setter 
    public void setLink(String link){
        this.link = link;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setDescrpition(String descrpition){
        this.descrpition = descrpition;
    }  
    public void setPubDate(String pubDate){
        this.pubDate = pubDate;
    }
    public void toString (String title, String descrpition, String pubDate, String link){
        System.out.println ("Title: " + title + "\n" + 
        "Description: " + descrpition + "\n"+ 
        "Publication Date: " + pubDate + "\n" + 
        "Link: " + link+ "\n "+ "******************"
        );
    }//provided by copilot but have to change to pretty print 
    
    //metodos (de ser necesarios) 
}