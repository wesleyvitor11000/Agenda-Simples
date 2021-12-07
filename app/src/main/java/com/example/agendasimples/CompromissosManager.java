package com.example.agendasimples;

import java.util.ArrayList;

public class CompromissosManager {

    public static ArrayList<Compromisso> getCompromissosFromString(String fileText){

        ArrayList<Compromisso> compromissos = new ArrayList<>();

        if(fileText == null || fileText.isEmpty()){
            return compromissos;
        }

        String compromissoAtual = "";
        int end = 1;
        int start;

        while(true){
            start = fileText.indexOf("#", end-1) + 1;

            if(start != -1) {
                end = fileText.indexOf("#", start);

                if(end == -1){
                    compromissoAtual = fileText.substring(start);
                }else{
                    compromissoAtual = fileText.substring(start, end);
                }

                int dataStart = compromissoAtual.indexOf("data:");
                dataStart = compromissoAtual.indexOf(":", dataStart) + 2;
                int dataEnd   = compromissoAtual.indexOf("\n", dataStart);
                String data = compromissoAtual.substring(dataStart, dataEnd);


                int tituloStart = compromissoAtual.indexOf("titulo:");
                tituloStart = compromissoAtual.indexOf(":", tituloStart) + 2;
                int tituloEnd   = compromissoAtual.indexOf("\n", tituloStart);
                String titulo = compromissoAtual.substring(tituloStart, tituloEnd);

                int descricaoStart = compromissoAtual.indexOf("descricao:");
                descricaoStart = compromissoAtual.indexOf(":", descricaoStart) + 2;
                int descricaoEnd   = compromissoAtual.indexOf("\n", descricaoStart);
                String descricao = compromissoAtual.substring(descricaoStart, descricaoEnd);

                int colorIdStart = compromissoAtual.indexOf("idColor:");
                colorIdStart = compromissoAtual.indexOf(":", colorIdStart) + 2;
                int colorIdEnd   = compromissoAtual.indexOf("\n", colorIdStart);
                int colorId = Integer.parseInt(compromissoAtual.substring(colorIdStart, colorIdEnd));

                Compromisso compromisso = new Compromisso(data, titulo, descricao, colorId);
                compromissos.add(compromisso);

                if(end == -1) break;

            }else{
                break;
            }
        }

        return compromissos;

    }

    public static String getStringFromCompromisso(Compromisso compromisso){

        String compromissoString = "";

        if(compromisso == null){
            return compromissoString;
        }

        compromissoString = "\n#\n";
        compromissoString += "data: " + compromisso.getData() + "\n";
        compromissoString += "titulo: " + compromisso.getTitulo() + "\n";
        compromissoString += "descricao: " + compromisso.getDescricao() + "\n";
        compromissoString += "idColor: " + compromisso.getColorId() + "\n";

        System.out.println("SALVO ---->   \n" );
        System.out.println(compromissoString);


        return compromissoString;

    }

}
