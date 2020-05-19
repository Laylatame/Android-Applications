package com.example.newshomework;

public class Noticia {

    private String _mNoticiaTitulo;
    private String _mNoticiaFecha;
    private String _mNoticiaDescripcion;
    private String _mNoticiaURL;
    private String _mImageURL;

    public Noticia(String mNoticiaTitulo, String mNoticiaFecha, String mNoticiaDescripcion, String mNoticiaURL, String mImageURL){
        this._mNoticiaTitulo = mNoticiaTitulo;
        this._mNoticiaFecha = mNoticiaFecha;
        this._mNoticiaDescripcion = mNoticiaDescripcion;
        this._mNoticiaURL = mNoticiaURL;
        this._mImageURL = mImageURL;
    }

    public Noticia(){

    }

    public String getNoticiaTitulo(){
        return _mNoticiaTitulo;
    }

    public void setNoticiaTitulo(String mNoticiaTitulo){
        this._mNoticiaTitulo = mNoticiaTitulo;
    }

    public String getNoticiaFecha(){
        return _mNoticiaFecha;
    }

    public void setNoticiaFecha(String mNoticiaFecha){
        this._mNoticiaFecha = mNoticiaFecha;
    }

    public String getNoticiaDescripcion(){
        return _mNoticiaDescripcion;
    }

    public void setNoticiaDescripcion(String mNoticiaDescripcion){
        this._mNoticiaDescripcion = mNoticiaDescripcion;
    }

    public String getNoticiaURL(){
        return _mNoticiaURL;
    }

    public void setNoticiaURL(String mNoticiaURL){
        this._mNoticiaURL = mNoticiaURL;
    }

    public String getImageURL(){
        return this._mImageURL;
    }

    public void setImageURL(String mImageURL){
        this._mImageURL = mImageURL;
    }
}
