package com.example.agendasimples;

import java.io.Serializable;
import java.util.Calendar;

public class Compromisso implements Serializable {

    private Calendar data;
    private String titulo;
    private String descricao;
    private int colorId;

    public Compromisso(Calendar data, String titulo, String descricao, int colorId){
        this.data = data;
        this.titulo = titulo;
        this.colorId = colorId;
        this.descricao = descricao;
    }

    public int getDia(){ return data.get(Calendar.DAY_OF_MONTH); }
    public int getMes(){ return data.get(Calendar.MONTH); }
    public int getAno(){ return data.get(Calendar.YEAR); }

    public Calendar getData() { return data; }
    public void setData(Calendar data) { this.data = data; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao(){ return descricao; }
    public void setDescricao(String descricao){this.descricao = descricao;}

    public int getColorId() { return colorId; }
    public void setColorId(int colorId) { this.colorId = colorId; }

}
