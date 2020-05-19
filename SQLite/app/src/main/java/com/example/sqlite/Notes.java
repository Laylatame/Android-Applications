package com.example.sqlite;

import android.database.CrossProcessCursor;

public class Notes {


    private int _id;
    private String _nota;
    private int _fecha;


    public Notes(){

    }

    public Notes(int id, String nota, int fecha){
        this._id = id;
        this._nota = nota;
        this._fecha = fecha;
    }

    public Notes(String nota, int fecha){
        this._nota = nota;
        this._fecha = fecha;
    }

    public void setID(int id){
        this._id = id;
    }

    public int getID(){
        return this._id;
    }

    public void setNota(String nota){
        this._nota = nota;
    }

    public String getNota(){
        return this._nota;
    }

    public void setFecha(int fecha){
        this._fecha = fecha;
    }

    public int getFecha(){
        return this._fecha;
    }
}
