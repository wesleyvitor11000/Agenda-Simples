package com.example.agendasimples;

import java.util.ArrayList;
import java.util.Calendar;

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

                int diaStart = compromissoAtual.indexOf("dia:");
                diaStart = compromissoAtual.indexOf(":", diaStart) + 2;
                int diaEnd   = compromissoAtual.indexOf("\n", diaStart);
                int dia = Integer.parseInt(compromissoAtual.substring(diaStart, diaEnd));

                int mesStart = compromissoAtual.indexOf("mes:");
                mesStart = compromissoAtual.indexOf(":", mesStart) + 2;
                int mesEnd   = compromissoAtual.indexOf("\n", mesStart);
                int mes = Integer.parseInt(compromissoAtual.substring(mesStart, mesEnd));

                int anoStart = compromissoAtual.indexOf("ano:");
                anoStart = compromissoAtual.indexOf(":", anoStart) + 2;
                int anoEnd   = compromissoAtual.indexOf("\n", anoStart);
                int ano = Integer.parseInt(compromissoAtual.substring(anoStart, anoEnd));

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

                Calendar data = Calendar.getInstance();
                data.set(ano,mes,dia);

                Compromisso compromisso = new Compromisso(data, titulo, descricao, colorId);
                compromissos.add(compromisso);

                if(end == -1) break;

            }else{
                break;
            }
        }

        return compromissos;

    }

    public static String editCompromissoOnString(Compromisso novoValor, String compromissos, int posicao){

        System.out.println(posicao);
        System.out.println(compromissos);

        String novoComrpomisso = getStringFromCompromisso(novoValor);
        String oldCompromisso = "";

        int end = 1;
        int start = 0;

        String compromissosEditado = "";

        for(int i = 0; i <= posicao; i++){

            if(end==-1){return compromissos;}

            start = compromissos.indexOf("#", end - 1);

            if(start == -1){return compromissos;}


            end = compromissos.indexOf("#", start + 1);

        }

        if(end == -1){
            oldCompromisso = compromissos.substring(start);
        }else{
            oldCompromisso = compromissos.substring(start, end);
        }

        novoComrpomisso = compromissos.replace(oldCompromisso, novoComrpomisso);

        return novoComrpomisso;

    }

    public static String editCompromissoOnString1(Compromisso novoValor, String compromissos, int posicao){

        String novoCompromisso = getStringFromCompromisso(novoValor);
        String compromissoAtual = "";
        int end = 1;
        int start;
        int atualIndex = 0;
        String editado;

        while(atualIndex <= posicao){

            start = compromissos.indexOf("#", end-1);

            if(start != -1) {
                end = compromissos.indexOf("#", start);

                if(atualIndex == posicao){
                    if(end == -1){
                        compromissoAtual = compromissos.substring(start);
                    }else{
                        compromissoAtual = compromissos.substring(start, end);
                    }

                    break;
                }

                if(end == -1) break;

            }else{
                break;
            }

            atualIndex++;

        }

        editado = compromissos.replace(compromissoAtual, novoCompromisso);
        return editado;
    }

    public static String getStringFromCompromisso(Compromisso compromisso){

        String compromissoString = "";

        if(compromisso == null){
            return compromissoString;
        }


        compromissoString = "#\n" +
                             "dia: " + compromisso.getDia() + "\n" +
                             "mes: " + compromisso.getMes() + "\n" +
                             "ano: " + compromisso.getAno() + "\n" +
                             "titulo: " + compromisso.getTitulo() + "\n" +
                             "descricao: " + compromisso.getDescricao() + "\n" +
                             "idColor: " + compromisso.getColorId() + "\n\n";

        return compromissoString;

    }

}
