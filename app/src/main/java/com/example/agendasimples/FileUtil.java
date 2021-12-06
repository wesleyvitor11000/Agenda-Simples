package com.example.agendasimples;

import android.content.res.AssetManager;

import androidx.annotation.NonNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

}
