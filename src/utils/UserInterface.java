package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import utils.Stats;
public class UserInterface {

    private HashMap<String, String> optionDict;

    private List<Option> options;

    public UserInterface() {
        options = new ArrayList<Option>();
        options.add(new Option("-h", "--help", 0));
        options.add(new Option("-f", "--feed", 1));
        options.add(new Option("-ne", "--named-entity", 1));
        options.add(new Option("-pf", "--print-feed", 0));
        options.add(new Option("-sf", "--stats-format", 1));

        optionDict = new HashMap<String, String>();
    }

    public Config handleInput(String[] args) {

        for (Integer i = 0; i < args.length; i++) {
            for (Option option : options) {
                if (option.getName().equals(args[i]) || option.getLongName().equals(args[i])) {
                    if (option.getnumValues() == 0) {
                        optionDict.put(option.getName(), null);
                    } else {
                        if (i + 1 < args.length && !args[i + 1].startsWith("-")) { 
                            optionDict.put(option.getName(), args[i + 1]);
                            i++;
                        } else {
                            System.out.println("Invalid inputs");
                            System.exit(1);
                        }
                    }
                }
            }
        }

        Boolean printhelp = optionDict.containsKey("-h");
        Boolean printFeed = optionDict.containsKey("-pf");
        Boolean computeNamedEntities = optionDict.containsKey("-ne");
        String feedKey = optionDict.get("-f");
        String heuristic = optionDict.get("-ne");
        // TO DO falta stat format
        Stats stats = new Stats();
        if(optionDict.containsKey("-sf")){
            stats = new Stats(optionDict.get("-sf"));
        }
        System.out.println(stats.getFormat());
        return new Config(printhelp, printFeed, computeNamedEntities, feedKey, heuristic, stats);
    }
}

//si ejecuto sin argumentos debe imprimir el feed