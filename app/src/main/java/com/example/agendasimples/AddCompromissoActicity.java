package com.example.agendasimples;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class AddCompromissoActicity extends AppCompatActivity {

    TextView dateText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_compromisso_acticity);

        dateText = findViewById(R.id.data_text);
        Button changeDateButton = findViewById(R.id.change_date_button);

        changeDateButton.setOnClickListener(view -> calendarDialog());

    }

    public void calendarDialog(){

        AlertDialog.Builder builder = new AlertDialog.Builder(AddCompromissoActicity.this);

        LayoutInflater layoutInflater = LayoutInflater.from(AddCompromissoActicity.this);
        View testeView = layoutInflater.inflate(R.layout.date_picker_layout, null);

        DatePicker datePicker = (DatePicker) testeView.findViewById(R.id.date);
        
        builder.setPositiveButton("Ok", (dialogInterface, i) -> {
            String dateString = datePicker.getDayOfMonth() +
                    " / " + datePicker.getMonth();
            dateText.setText(dateString);
        });

        builder.setView(testeView);
        builder.show();

    }

}