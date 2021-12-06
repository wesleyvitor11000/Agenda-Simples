package com.example.agendasimples;

public class Compromisso {

    private String data;
    private String titulo;
    private int colorId;

    public Compromisso(String data, String titulo, int colorId){
        this.data = data;
        this.titulo = titulo;
        this.colorId = colorId;
    }

    public String getData() { return data; }
    public void setData(String data) { this.data = data; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public int getColorId() { return colorId; }
    public void setColorId(int colorId) { this.colorId = colorId; }

}
