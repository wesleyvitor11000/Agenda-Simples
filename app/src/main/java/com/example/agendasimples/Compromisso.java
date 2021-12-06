package com.example.agendasimples;

import java.util.ArrayList;

public class Compromisso {

    private String data;
    private String titulo;
    private int colorId;

    public Compromisso(String data, String titulo, int colorId){
        this.data = data;
        this.titulo = titulo;
        this.colorId = colorId;
    }

    public static ArrayList<Compromisso> getCompromissosFromText(String fileText){

        ArrayList<Compromisso> compromissos = new ArrayList<>();

        String compromissoAtual = "";
        int end = 1;
        int start;

        while(true){
            start = fileText.indexOf("#", end-1) + 1;
            System.out.println("START ---> " + start);

            if(start != -1) {
                end = fileText.indexOf("#", start);
                System.out.println("END --->" + end);

                if(end == -1){
                    compromissoAtual = fileText.substring(start);
                    System.out.println("TESTE DE QUEBRA\n\n\n\n" + compromissoAtual);
                }else{
                    compromissoAtual = fileText.substring(start, end);
                    System.out.println("TESTE DE QUEBRA\n\n\n\n" + compromissoAtual);
                }

                int dataStart = compromissoAtual.indexOf("data:");
                dataStart = compromissoAtual.indexOf(":", dataStart) + 2;
                int dataEnd   = compromissoAtual.indexOf("\n", dataStart);
                String data = compromissoAtual.substring(dataStart, dataEnd);

                System.out.println("---------DATA--------");

                int tituloStart = compromissoAtual.indexOf("titulo:");
                tituloStart = compromissoAtual.indexOf(":", tituloStart) + 2;
                int tituloEnd   = compromissoAtual.indexOf("\n", tituloStart);
                String titulo = compromissoAtual.substring(tituloStart, tituloEnd);

                System.out.println("---------TITULO--------");

                int colorIdStart = compromissoAtual.indexOf("idColor:");
                colorIdStart = compromissoAtual.indexOf(":", colorIdStart) + 2;
                int colorIdEnd   = compromissoAtual.indexOf("\n", colorIdStart);
                int colorId = Integer.parseInt(compromissoAtual.substring(colorIdStart, colorIdEnd));

                System.out.println("---------COLOR--------");


                Compromisso compromisso = new Compromisso(data, titulo, colorId);
                compromissos.add(compromisso);


                if(end == -1) break;

            }else{
                break;
            }
        }

        return compromissos;

    }

    public String getData() { return data; }
    public void setData(String data) { this.data = data; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public int getColorId() { return colorId; }
    public void setColorId(int colorId) { this.colorId = colorId; }

}
