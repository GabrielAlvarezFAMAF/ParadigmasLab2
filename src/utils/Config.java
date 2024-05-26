package utils;
public class Config {
    private boolean printhelp = false; 
    private boolean printFeed = false;
    private boolean computeNamedEntities = false;
    private String feedKey;
    Stats stats;
    // TODO: A reference to the used heuristic will be needed here
    private String heuristic; 

    public Config(boolean printhelp, boolean printFeed, boolean computeNamedEntities, String feedKey, String heuristic, Stats stats) {
        this.printhelp = printhelp; 
        this.printFeed = printFeed;
        this.computeNamedEntities = computeNamedEntities;
        this.feedKey = feedKey;
        this.heuristic = heuristic;
        this.stats = stats;
    }

    public boolean getPrinthelp() {
        return printhelp; 
    }
    public boolean getPrintFeed() {
        return printFeed;
    }

    public boolean getComputeNamedEntities() {
        return computeNamedEntities;
    }

    public String getFeedKey() {
        return feedKey;
    }

    public String getHeuristic() {
        return heuristic;
    }
    public Stats stats() {
        return stats;
    }
    public void setHeuristic(String heuristic) {
        this.heuristic = heuristic;
    }
}
