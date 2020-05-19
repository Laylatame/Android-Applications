package com.example.fragmentshomework;

import java.util.ArrayList;

public class Preguntas {

    public ArrayList<String> preguntas = new ArrayList<String>();
    public ArrayList<String> preguntasBool = new ArrayList<String>();

    public void createPreguntasA(){
        preguntas.add("Pregunta 1 TECH");
        preguntas.add("Pregunta 2 TECH");
        preguntas.add("Pregunta 3 TECH");
        preguntas.add("Pregunta 4 TECH");
        preguntas.add("Pregunta 5 TECH");

        preguntasBool.add("true");
        preguntasBool.add("false");
        preguntasBool.add("false");
        preguntasBool.add("true");
        preguntasBool.add("false");
    }

    public void createPreguntasB(){
        preguntas.add("Pregunta 1 DEPORTES");
        preguntas.add("Pregunta 2 DEPORTES");
        preguntas.add("Pregunta 3 DEPORTES");
        preguntas.add("Pregunta 4 DEPORTES");
        preguntas.add("Pregunta 5 DEPORTES");

        preguntasBool.add("false");
        preguntasBool.add("false");
        preguntasBool.add("false");
        preguntasBool.add("true");
        preguntasBool.add("false");
    }

    public String getPregunta(int index){
        return preguntas.get(index);
    }

    public String getBool(int index){
        return preguntasBool.get(index);
    }

    public int getLength(){
        return preguntas.size();
    }


}