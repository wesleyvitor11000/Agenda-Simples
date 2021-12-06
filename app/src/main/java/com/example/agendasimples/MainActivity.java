package com.example.agendasimples;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = findViewById(R.id.compromissos_recycle);
        ArrayList<Compromisso> compromissos = new ArrayList<Compromisso>();
        CompromissoAdapter compromissoAdapter;

//        Compromisso c1 = new Compromisso("10 de Dezembro", "Farmácia", 0);
//        Compromisso c2 = new Compromisso("02 de Janeiro", "Dentista", 1);
//        Compromisso c3 = new Compromisso("23 de Outubro", "Supermercado", 0);
//        Compromisso c4 = new Compromisso("10 de Dezembro", "Farmácia", 2);
//        Compromisso c5 = new Compromisso("02 de Janeiro", "Dentista", 3);
//        Compromisso c6 = new Compromisso("23 de Outubro", "Supermercado", 1);
//
//        compromissos.add(c1);
//        compromissos.add(c2);
//        compromissos.add(c3);
//        compromissos.add(c4);
//        compromissos.add(c5);
//        compromissos.add(c6);

        String compromissosS = "#\n" +
                "data: 16 de Dezembro\n" +
                "titulo: Farmácia\n" +
                "idColor: 0\n" +
                "\n" +
                "#\n" +
                "data: 12 de Dezembro\n" +
                "titulo: Supermercado\n" +
                "idColor: 1\n";

        compromissos = Compromisso.getCompromissosFromText(compromissosS);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);

        compromissoAdapter = new CompromissoAdapter(compromissos);
        rv.setAdapter(compromissoAdapter);






    }
}