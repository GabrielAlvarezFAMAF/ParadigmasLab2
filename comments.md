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
    
