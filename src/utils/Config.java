package utils;

enum heuristica {
    CapitalizedWordHeuristic,
    ProfesionHeuristic,
    LugarHeuristic,
    PersonaHeuristic
}
public class Config {
    private boolean printhelp = false; 
    private boolean printFeed = false;
    private boolean computeNamedEntities = false;
    private String feedKey;
    // TODO: A reference to the used heuristic will be needed here
    private String heuristic; 

    public Config(boolean printhelp, boolean printFeed, boolean computeNamedEntities, String feedKey, String heuristic) {
        this.printhelp = printhelp; 
        this.printFeed = printFeed;
        this.computeNamedEntities = computeNamedEntities;
        this.feedKey = feedKey;
        this.heuristic = heuristic;
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
    public void setHeuristic(String heuristic) {
        this.heuristic = heuristic;
    }
}
