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

            System.out.println("Start -> " + start + " End -> " + end);

            start = compromissos.indexOf("#", end - 1);

            System.out.println("Start -> " + start + " End -> " + end);

            if(start == -1){return compromissos;}

            System.out.println("Start -> " + start + " End -> " + end);

            end = compromissos.indexOf("#", start + 1);

            System.out.println("Start -> " + start + " End -> " + end);
        }

        if(end == -1){
            oldCompromisso = compromissos.substring(start);
        }else{
            oldCompromisso = compromissos.substring(start, end);
        }

        System.out.println(oldCompromisso);

        novoComrpomisso = compromissos.replace(oldCompromisso, novoComrpomisso);

        System.out.println("NOVO COMPROMISSO ---> ");
        System.out.println(novoComrpomisso);

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

        compromissoString = "\n#\n" +
                             "data: " + compromisso.getData() + "\n" +
                             "titulo: " + compromisso.getTitulo() + "\n" +
                             "descricao: " + compromisso.getDescricao() + "\n" +
                             "idColor: " + compromisso.getColorId() + "\n";

        return compromissoString;

    }

}
