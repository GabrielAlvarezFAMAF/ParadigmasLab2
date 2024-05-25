package ne.heuristics;

import java.text.Normalizer;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import ne.heuristics.CapitalizedWordHeuristic;


public class SemanticNeighborg {
    
    static Set<String> keyWords = new HashSet<>(List.of(
        //Locaciones
        "Ciudad", "País", "Región", "Continente", "Estado", "Provincia", "Municipio", "Pueblo", "Villa", "Distrito", "Universidad",
        "Barrio", "Zona", "Territorio", "Isla", "Archipiélago", "República", "Federación", "Comunidad Autónoma", "Departamento", "Nación"
        /*Profesiones"Presidente*/, "Gobernador", "Técnico", "Licenciado", "Músico", "Vocero", "Ministro", "Doctor", 
        "Ingeniero", "Profesor", "Abogado", "Juez", "Empresario", "Director", "Gerente", "Asesor", "Consultor", "Investigador", "Científico", 
        "Artista", "Escritor", "Periodista", "Actor", "Deportista", "Chef", "Arquitecto", "Contador", "Enfermero", "Paramédico", "Piloto", "Capitán"
    ));
    static Set<String> Org = new HashSet<> (List.of(
        "Naciones Unidas", "Unión Europea", "OTAN", "OMS", "OIT", "FMI", "Banco Mundial", "OEA", "Unesco", 
        "Interpol", "Cruz Roja", "OMS", "Unicef", "ACNUR", "OPEP", "G7", "G20", "BRICS",
        "Google", "Apple", "Amazon", "Microsoft", "Facebook", "Tesla", "Samsung", "Sony", "IBM", "Intel", "NVIDIA", "Coca-Cola", "Pepsi", 
        "McDonald's", "Nike", "Adidas", "Toyota", "Ford", "General Motors", "Volkswagen", "BMW", "Mercedes-Benz", "Shell", "ExxonMobil", "Chevron", 
        "BP", "Walmart", "Costco", "Target", "Alibaba", "Tencent", "Baidu", "Huawei", "Netflix", "Spotify", "Uber", "Airbnb", "SpaceX", "Boeing", 
        "Lockheed Martin", "Goldman Sachs", "JPMorgan Chase", "Bank of America", "Citibank", "Wells Fargo", "HSBC", "Santander", "BBVA", "ING", "Deutsche Bank", 
        "Siemens", "Philips", "Panasonic", "LG", "Lenovo", "Acer", "Asus"
    ));
    
    
    public static List<String> extractCandidates(String text) {
        CapitalizedWordHeuristic cWH = new CapitalizedWordHeuristic();
        List<String> candidates = new ArrayList<>();
        String[] words = text.split("\\s+");
        String filteredText ; 
        for (int i = 0; i < words.length; i++) {
            if (!Org.contains(words[i])) {
                if (keyWords.contains(words[i])) {
                    if (i + 1 < words.length && (words[i+1] != "de" || words[i+1] != "del")) {
                        candidates.add(words[i + 1]);
                    }else if (i + 2 < words.length) {
                        candidates.add(words[i + 2]);
                    }
                }
        }else {
            candidates.add(words[i]);
            }
        }
        filteredText = candidates.toString().replaceAll("[\\[\\]]", "");
        //print to depuring filteredText
        System.out.println(filteredText);
        candidates = cWH.extractCandidates(filteredText);
        return candidates;
    }
}
