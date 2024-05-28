---
title: Laboratorio de Programación Orientada a Objetos
author: acá van sus nombres
---

El enunciado del laboratorio se encuentra en [este link](https://docs.google.com/document/d/1wLhuEOjhdLwgZ4rlW0AftgKD4QIPPx37Dzs--P1gIU4/edit#heading=h.xe9t6iq9fo58).

# 1. Tareas
Pueden usar esta checklist para indicar el avance.

## Verificación de que pueden hacer las cosas.
- [x] Java 17 instalado. Deben poder compilar con `make` y correr con `make run` para obtener el mensaje de ayuda del programa.

## 1.1. Interfaz de usuario
- [x] Estructurar opciones
- [x] Construir el objeto de clase `Config`

## 1.2. FeedParser
- [x] `class Article`
    - [x] Atributos
    - [x] Constructor
    - [x] Método `print`
    - [x] _Accessors_
- [x] `parseXML`

## 1.3. Entidades nombradas
- [x] Pensar estructura y validarla con el docente
- [x] Implementarla
- [x] Extracción
    - [x] Implementación de heurísticas
- [x] Clasificación
    - [x] Por tópicos
    - [x] Por categorías
- Estadísticas
    - [x] Por tópicos
    - [x] Por categorías
    - [x] Impresión de estadísticas

## 1.4 Limpieza de código
- [ ] Pasar un formateador de código
- [x] Revisar TODOs

# 2. Experiencia
En general tenemos en cuenta que nuestro codigo tiene algunos errores que puede generar codigo spaghetti 
tenemos mucho que mejorar y aprender pero la idea del proyecto creemos que esta correcta.
Tuvimnos problemas para entender y pensar el concepto de hueristica, logramos sacarlo adelante.
# 3. Preguntas
1. Explicar brevemente la estructura de datos elegida para las entidades nombradas.
Hicimos 3 campos category, topics , name donde : 
category es un String ya que cada entidad nombrada solo puede tener una categoria 
topics es una List<String> ya que cada entidad nombrada no se restringe a solo un topico 
name es un String que contendra el nombre de cada entidad nombrada 
2. Explicar brevemente cómo se implementaron las heurísticas de extracción.
FiltredCwh: 
    La idea de la heuristica es reducir la cantidad de falsos positivos una vez aplicado capitalizedWordHeuristic 
    esto lo hace checkeando que las palabras capitalizadas no seas verbos,articulos,preposiciones o conectores.
SemanticNeighborg: 
    La idea de esta heuristica es identificar una entidad nombrada porque ocurre despues de una palabra clave
    con la cual esta relacionada semanticamente. Esto puede ocurrir de dos maneras 
        1- Este inmediatamente despues de la palabra clave con la estructura <palabra-clave> <named-entity> 
        ejemplo : Gobernador Martín Miguel Llaryora donde Gobernador es la palbra clave 
        2- Este en una posicion adicional <palabra-clave> <articulo><named-entity> 
        ejemplo: Ciudad de Cordoba Ciudad es la palabra clave y articulo es de 
    Lamentablemente esta idea se nos ocurrio tarde y no tuvimos tiempo de refinarla por lo que no esta incluida en el proyecto
    sin embargo la dejamos para mostrar que al menos lo intentamos. 
# 4. Extras
Completar si hacen algo.