package namedEntities.heuristics;
import java.util.List;
import java.util.Set;
import java.util.HashSet;



public class FiltredCwh {

    static Set<String> articulos = new HashSet <>(List.of(
        "el", "la", "los", "las", "un", "una", "unos", "unas", "El", "La", "Los", "Las", "Un", "Una", "Unos", "Unas"));
    
    static Set<String> verbos = new HashSet <>(List.of(
        "ar", "er", "ir", "ando", "iendo", "ado", "ido", "o", "as", "es", "a", "e", "amos", "emos", "imos", "ais", "eis", 
        "is", "an", "en", "aba", "ia", "abas", "ias", "abamos", "iamos", "abais", "iais", "aban", "ian", "e", "i", "aste", "iste", "o", 
        "io", "amos", "imos", "asteis", "isteis", "aron", "ieron", "are", "ere", "ire", "aras", "eras", "iras", "ara", "era", "ira", 
        "aremos", "eremos", "iremos", "areis", "ereis", "ireis", "aran", "eran", "iran", "aria", "eria", "iria", "arias", "erias", "irias", 
        "ariamos", "eriamos", "iriamos", "ariais", "eriais", "iriais", "arian", "erian", "irian", "ando", "iendo", "ado", "ido", "to", "so", "cho"
        
    ));
    

    static Set<String> preposiciones = new HashSet <>(List.of("a", "ante", "bajo", "cabe", "con", "contra", "de", "desde", 
    "durante", "en", "entre", "hacia", "hasta", "mediante", "para", "por", "según", "sin", "so", "sobre", "tras", "A", "Ante", "Bajo", "Cabe", 
    "Con", "Contra", "De", "Desde", "Durante", "En", "Entre", "Hacia", "Hasta", "Mediante", "Para", "Por", "Según", "Sin", "So", "Sobre", "Tras",
    "A", "Ante", "Bajo", "Cabe", "Con", "Contra", "De", "Desde", "Durante", "En", "Entre", "Hacia", "Hasta", "Mediante", "Para", "Por", "Según", "Sin", "So", "Sobre", "Tras"

    ));

    static Set<String> conectores = new HashSet <>(List.of("Y", "O", "Pero", "Sino", "Aunque", "Porque", "Pues", "Mientras", "Cuando", "Si", "Que", "Como", 
    "Donde", "Ya", "A", "Así", "A", "A", "Antes", "Con", "Después", "En", "Hasta", "Para", "Siempre", "Tan", "Además", "Sin", "Por", "Es", "Por", "O", "Por", 
    "Entonces", "Por"
    ));

    

    
    public static List<String> filterCandidates(String text) {
        CapitalizedWordHeuristic Cwh = new CapitalizedWordHeuristic();
        List<String> candidates = Cwh.extractCandidates(text);
        int i = 0;
        while(i < candidates.size() - 1){
            String candidate = candidates.get(i);
            for(String sufijo : verbos){
                if((candidates.get(i)).endsWith(sufijo)){
                    candidates.remove(i);
                }
            }
            if(articulos.contains(candidate) || preposiciones.contains(candidate) || conectores.contains(candidate)){
                candidates.remove(i);
            }
            i++;
            if(!(i< candidates.size()-1) || candidates.size() == 0 || i<candidates.size()-2){
                break;
                //initial idea was to use a while loop but it was not working as expected
                // so I decided to use a for loop instead
                // I also added a condition to break the loop if the list is empty
                //
            }
        }
        return candidates;
    }
}