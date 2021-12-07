package com.example.agendasimples;

import android.content.Context;
import android.content.res.AssetManager;

import androidx.annotation.NonNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;

public class FileUtil {

    //***********CRIAR A TAG AQ******************//
    private static String compromissosFileName = "compromissosFile.txt";

    @NonNull
    public static String recuperarCompromissos(@NonNull AssetManager assetManager){

        String conteudo = "";
        BufferedReader bufferedReader;

        try {
            InputStream is = assetManager.open(compromissosFileName);
            InputStreamReader isr = new InputStreamReader(is);
            bufferedReader = new BufferedReader(isr);

            for(String linha = ""; linha != null; linha = bufferedReader.readLine()){
                conteudo += linha + "\n";
            }

            bufferedReader.close();

        }catch (IOException e){
            //LOG DE ERRO AQ
        }

        if(conteudo.length() >0){
            return conteudo.substring(0, conteudo.length() - 1);
        }

        return conteudo;

    }

    public static void salvarCompromisso(Compromisso compromisso, Context c){

        String compromissoString = recuperarCompromissos(c);
        compromissoString += CompromissosManager.getStringFromCompromisso(compromisso);

        try {
            FileOutputStream file = c.openFileOutput(compromissosFileName, Context.MODE_PRIVATE);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(file);
            outputStreamWriter.write(compromissoString);

            outputStreamWriter.close();
        } catch (IOException e) {
            //****LOG HERE***********
        }


    }

    @NonNull
    public static String recuperarCompromissos(Context c){

        String conteudo = "";

        try {
            InputStream inputStream = c.openFileInput(compromissosFileName);

            if(inputStream != null){

                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader leitor = new BufferedReader(inputStreamReader);

                for(String linha = ""; linha != null; linha = leitor.readLine()){
                    conteudo += linha + "\n";
                }

                leitor.close();
            }


        } catch (IOException e) {
            //LOG HERE**********************************
        }

        return conteudo;

    }

}
