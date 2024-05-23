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
    es por eso que hace falta mejroar esta parte para que lo haga con todas en particular con sf para devuelva las stats
----------------------------------------------------------------------------------------------------------------------------------  


JSONParser.java 

38 - jsonObject.getJSONArray("topic"): Aquí se accede al objeto jsonObject y se obtiene un arreglo JSON con la clave "topic". Suponiendo que jsonObject es un objeto JSON válido, esta línea de código devuelve un arreglo JSON.

.toString(): Después de obtener el arreglo JSON, se llama al método toString() para convertirlo en una cadena de texto. Esto es necesario porque el método split() que se utilizará más adelante requiere una cadena de texto como entrada.

la idea de esto es meter un array Json convertido a String para crear el Dictionaryfeeds 
parseando eso puedo usar todo lo que esta en el dictionary 

