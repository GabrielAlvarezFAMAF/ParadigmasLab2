package ne.heuristics;
   /*
   para profesiones 
   son palabras terminadas en or , ora , ista , ente , etc (PENSAR EN ESTO QUEDAN MAS),ero
   OJO CON LOS FALSOS POSITIVOS




*/





/*
   para lugares salvo los especificos podemos ver palabras que empiencen con
   san , villa . santa , quinta, estado, republica,federancion, reino , union, facultad
   templo, ciudad, univerdad , distrito , departamento
   pensar y pensar y pensar


*/
/*  para personas esta la heuristica de la catedra que da nombre y apelldio hay que mejorarla pero esta bien


*/
import java.text.Normalizer;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CapitalizedWordHeuristic {

    public List<String> extractCandidates(String text) {
        List<String> candidates = new ArrayList<>();

        text = text.replaceAll("[-+.^:,\"]", "");
        text = Normalizer.normalize(text, Normalizer.Form.NFD);
        text = text.replaceAll("\\p{M}", "");

        Pattern pattern = Pattern.compile("[A-Z][a-z]+(?:\\s[A-Z][a-z]+)*");

        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            candidates.add(matcher.group());
        }
        return candidates;
    }
}
