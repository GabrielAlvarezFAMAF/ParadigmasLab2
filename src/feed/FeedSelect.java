package feed;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import utils.FeedsData;

public class FeedSelect {
    private boolean varselec = true; 
    private String feedkeyString; 
    private String fetchedUrl;

    public String pString(String feeedkey){
        return this.feedkeyString = feeedkey; 
    }

    public boolean gVarselec(){
        return varselec; 
    }
    public String gString(){
        return this.feedkeyString; 
    }
    public String getfetchedUrl(){
        return this.fetchedUrl; 
    }

    public List<Article> selectOne(String feedkey, List<FeedsData> feedsDataArray){
        List<Article> allArticles = new ArrayList<>();
        try{
            if ("p12pais".equals(feedkey)) {
                allArticles = FeedParser.parseXML(FeedParser.fetchFeed(feedsDataArray.get(0).getUrl()));
                fetchedUrl = FeedParser.fetchFeed(feedsDataArray.get(0).getUrl());
            }
            else if ("p12eco".equals(feedkey)) {
                allArticles = FeedParser.parseXML(FeedParser.fetchFeed(feedsDataArray.get(1).getUrl()));
                fetchedUrl = FeedParser.fetchFeed(feedsDataArray.get(1).getUrl());
            }
            else if ("lmgral".equals(feedkey)) {
                allArticles = FeedParser.parseXML(FeedParser.fetchFeed(feedsDataArray.get(2).getUrl()));
                fetchedUrl = FeedParser.fetchFeed(feedsDataArray.get(2).getUrl());
            }
            else if ("lmnoti".equals(feedkey)) {
                allArticles = FeedParser.parseXML(FeedParser.fetchFeed(feedsDataArray.get(3).getUrl()));
                fetchedUrl = FeedParser.fetchFeed(feedsDataArray.get(3).getUrl());
            }
            varselec = false; 
            
        }
        catch (MalformedURLException e) {
        e.printStackTrace();
        System.out.println("Malformed URL");
        } catch (IOException e) {
        e.printStackTrace();
        System.out.println("IO Exception");
        } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Exception");
        }
        return allArticles;  
    }

    private List<Article> selectAll(List<FeedsData> feedsDataArray){
        List<Article> allArticles = new ArrayList<>();
        try{
            for (int i = 0; i < 4; i++) {
                List<Article> aux = FeedParser.parseXML(FeedParser.fetchFeed(feedsDataArray.get(i).getUrl()));
                allArticles.addAll(aux);
            }
        }
        catch (MalformedURLException e) {
        e.printStackTrace();
        System.out.println("Malformed URL");
        } catch (IOException e) {
        e.printStackTrace();
        System.out.println("IO Exception");
        } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Exception");
        }
        return allArticles;  
    }

    public void printFeed(List<Article> allArticles, List<FeedsData> feedsDataArray){
        System.out.println(varselec);
        if (varselec == true) {
            allArticles = selectAll(feedsDataArray); 
        }
        System.out.println("Printing feed(s) ");
        for (Article article : allArticles) {
            article.toString(article.getTitle(), article.getDescrpition(), article.getPubDate(), article.getLink());

        }
    }
}
