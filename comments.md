src/feed/FeedParser.java 

15 en adelante parate de parser por Gabo @palizaDeBesos : 

    Se define usando Java.util.arrayList una lista de Archivos cada uno de ellos debe ser parseado 
    para eso creamos variables que iniciamos "vacias" luego creamos un array para recorrerlo el cual 
    vamos a llenar con el comando split que lo llenara teniendo en cuenta un partro y en este caso 
    el patron sera el salto de linea.
    Entonces ahora si tengo alguna de las etiquetas vamos a usar de ejemplo <title> 
    lo que procede es agregarlo a Articule->titule para eso lo vamos a agregar a la variable vacia
    ya declarada 
    hay una aclaracion que me costo mucho desifrar donde me ayudo copilot que es +7 
    este +7 es porque <titule> tiene 7 caracteres y no deseo incluir ninguno de esos caracteres en 
    Articules->titules por lo tanto me los estoy salteando, esto se repite en todas las lineas 
    

importante saber que en UserInterface el metodo handleInput maneja lo que vamos a hacer con los arguemntoS
pasados por usuario, entonces es valida la opcion make run ARGS= "-h -pf" primero imprime help luego hace print feed

linea 32 a 35 Userinterface.java 
En el código proporcionado, se está procesando una lista de argumentos llamada args. La condición i + 1 < args.length && !args[i + 1].startsWith("-") se utiliza para verificar si hay un argumento adicional después del argumento actual (args[i]) y si ese argumento adicional no comienza con el carácter "-".

Si se cumple esta condición, significa que hay un valor asociado al argumento actual. Luego, se agrega una entrada al diccionario optionDict utilizando el nombre del argumento como clave y el valor del argumento adicional como valor. Después de agregar la entrada al diccionario, se incrementa el valor de i en 1 para omitir el argumento adicional en la siguiente iteración del bucle.

En resumen, este fragmento de código se encarga de procesar los argumentos de línea de comandos y almacenar los valores asociados a los argumentos en un diccionario.

-------------------------------------------MUY IMPORTANTE-----------------------------------------------------------------------
    ante el fallo en los manejos de args="lo que sea" decidi cambiar el codigo para entenderlo es por eso que ahora
    en la linea 49 hacemos 
        String heuristic = optionDict.get("-ne");
    en vez de 
        String heuristic = optionDict.get("-he");
    esto hace que en el hashMap que busca clave valor en vez de buscar la clave -he busque la -ne 
    por ejemplo si hacemos String heuristic = optionDict.get("-he capitalizeWords"); 
    lo que vamos a tener es el string de "-he " que nos va a decir que heuristica estamos manejando pero no la va a usar
    de otro modo String heuristic = optionDict.get("-ne capitalizeWors"); va a usar la heuristica y nos va a devolver
    la lista con las namedEntitys en este caso con todos los que estan con mayuscula 
    es por eso que hace falta mejroar esta parte para que lo haga con todas en particular con sf para devuelva las stats-----
----------------------------------------------------------------------------------------------------------------------------------  


JSONParser.java 

38 - jsonObject.getJSONArray("topic"): Aquí se accede al objeto jsonObject y se obtiene un arreglo JSON con la clave "topic". Suponiendo que jsonObject es un objeto JSON válido, esta línea de código devuelve un arreglo JSON.

.toString(): Después de obtener el arreglo JSON, se llama al método toString() para convertirlo en una cadena de texto. Esto es necesario porque el método split() que se utilizará más adelante requiere una cadena de texto como entrada.

la idea de esto es meter un array Json convertido a String para crear el Dictionaryfeeds 
parseando eso puedo usar todo lo que esta en el dictionary 

----------------------------------------------------------------------------------------------------------------------------------

Cambios en clase NamedEntities, los parametros de contructores instanciaban CUALQUIER categoria cuando se debia restringir a una unica(done).

Posible cambio: tratar de cambiar el campo "heuristic" en clase config. en vez de un String puede ser un objeto (CapitalizedWordHeuristic?)

User Interface: no hace falta que sea "dinamico" el usuario elije una heuristica que lee de help.

Entidades nombradas: cuando se corra CapitalizedWordHeuristic y se recolectan "candidatos" a entidades nombradas, todos los falsos positivos se desechan
es decir, si NO esta en el diccionario NO se agrega. Para las otras heuristicas no (podemos hacer que ande mejor).

Modularizar e Identar, borrar comentarios

Ver los stats, puede haber problema en cualquier parte por ej: DictionaryData

---------------------------------------------------------------------------------------------------
La nueva class FeedSelect.java implementa la eleccion de los get[i] donde i es el index de los feed.js, los ifs en App.java diferencian de si el usuario puso -f <-algo-> -pf o -pf.
Luego esta logica se debe aplicar a las otras flags, o sea, si las implementan sobre esta, capaz se rompa algo, pero idk. Manejen con cuidado. 

Luego, si se puede modularizar mas, pueden hacerlo. 
POR CIERTO: hay pequenas modificaciones en UserInterface.java (se cambio el nombre de configHeuristic a solo Heuristic)


-------------------------------------------------------------------------------------------------------------------------------
modifique feed select para agarrar url y poder usarlo dentro de named entitiies 
modifique stats con nuevos parametros y le di un nuevo parametro a config para agarrar esas stats 
haciendo una serie de comandos especificos funciona bien por ejemplo 
make run ARGS="-ne CapitalizedWordHeuristic -f p12eco -sf topic"
make run ARGS="-ne CapitalizedWordHeuristic -f p12eco -sf cat" 
make run ARGS="-ne CapitalizedWordHeuristic -f p12pais -sf topic" 
es decir andan todas las versiones -f y de -sf resta hacer andar el comando 
make run ARGS="-ne SemanticNeighborhoodHeuristic cualquiera de los otros ejemplos aca" 
podria resumir en
usage make run ARGS= " -ne <selected-heuristic> -f <selected-feed> -sf <selected-stat-format> 
