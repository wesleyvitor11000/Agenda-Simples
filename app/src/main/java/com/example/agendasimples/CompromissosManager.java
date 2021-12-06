package com.example.agendasimples;

import java.util.ArrayList;

public class CompromissosManager {

    public static ArrayList<Compromisso> getCompromissosFromText(String fileText){

        ArrayList<Compromisso> compromissos = new ArrayList<>();

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

                int colorIdStart = compromissoAtual.indexOf("idColor:");
                colorIdStart = compromissoAtual.indexOf(":", colorIdStart) + 2;
                int colorIdEnd   = compromissoAtual.indexOf("\n", colorIdStart);
                int colorId = Integer.parseInt(compromissoAtual.substring(colorIdStart, colorIdEnd));

                Compromisso compromisso = new Compromisso(data, titulo, colorId);
                compromissos.add(compromisso);

                if(end == -1) break;

            }else{
                break;
            }
        }

        return compromissos;

    }

}
