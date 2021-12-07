package com.example.agendasimples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddCompromissoActicity extends AppCompatActivity {

    private EditText dataInput;
    private EditText tituloInput;
    private EditText descricaoInput;
    private EditText colorIdInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_compromisso_acticity);

        FloatingActionButton save_button = findViewById(R.id.save_button);
        dataInput = findViewById(R.id.data_input);
        tituloInput  = findViewById(R.id.titulo_input);
        descricaoInput = findViewById(R.id.descricao_input);
        colorIdInput = findViewById(R.id.colorId_input);

        save_button.setOnClickListener(view -> adicionarCompromisso());
    }

    private void adicionarCompromisso() {

        int colorId = Integer.parseInt(colorIdInput.getText().toString());
        String data = dataInput.getText().toString();
        String titulo = tituloInput.getText().toString();
        String descricao = descricaoInput.getText().toString();

        Compromisso compromisso = new Compromisso(data, titulo, descricao, colorId);

        MainActivity.addComrpomisso(compromisso);
        FileUtil.salvarCompromisso(compromisso, AddCompromissoActicity.this);

        mainActivityScreen();

    }

    private void mainActivityScreen(){
        Intent intent = new Intent(AddCompromissoActicity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}