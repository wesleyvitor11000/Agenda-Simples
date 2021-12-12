package com.example.agendasimples;

import java.io.Serializable;

public class Compromisso implements Serializable {

    private String data;
    private String titulo;
    private String descricao;
    private int colorId;

    public Compromisso(String data, String titulo, String descricao, int colorId){
        this.data = data;
        this.titulo = titulo;
        this.colorId = colorId;
        this.descricao = descricao;
    }

    public String getData() { return data; }
    public void setData(String data) { this.data = data; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao(){ return descricao; }
    public void setDescricao(String descricao){this.descricao = descricao;}

    public int getColorId() { return colorId; }
    public void setColorId(int colorId) { this.colorId = colorId; }

}
