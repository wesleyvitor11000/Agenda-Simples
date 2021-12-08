package com.example.agendasimples;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private static ArrayList<Compromisso> compromissos;
    private static String compromissosS = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView emptyComrpomissosText = findViewById(R.id.empty_compromissos_text);
        RecyclerView rv = findViewById(R.id.compromissos_recycle);
        CompromissoAdapter compromissoAdapter;
        FloatingActionButton addButton = findViewById(R.id.add_button);

        if(compromissosS == null){
            compromissosS = FileUtil.recuperarCompromissos(this);
            compromissos = CompromissosManager.getCompromissosFromString(compromissosS);
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);

        compromissoAdapter = new CompromissoAdapter(compromissos);
        rv.setAdapter(compromissoAdapter);

        if(compromissos.isEmpty()){
            emptyComrpomissosText.setVisibility(View.VISIBLE);
        }else{
            emptyComrpomissosText.setVisibility(View.INVISIBLE);
        }

        addButton.setOnClickListener(view -> addCompromissoActivity());


    }

    private void addCompromissoActivity(){
        Intent intent = new Intent(MainActivity.this, AddCompromissoActicity.class);
        startActivity(intent);
        finish();
    }

    public static void addComrpomisso(Compromisso compromisso){
        compromissos.add(compromisso);
    }
}