package com.example.agendasimples;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddCompromissoActicity extends AppCompatActivity {

    TextView dateText;
    EditText tituloInput;
    EditText descricaoInput;
    RadioGroup colorSelector;
    Calendar dateCalendar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_compromisso_acticity);

        dateText = findViewById(R.id.data_text);
        tituloInput = findViewById(R.id.add_titulo_input);
        descricaoInput = findViewById(R.id.add_descricao_input);
        colorSelector = findViewById(R.id.colors_radio_group);
        Button changeDateButton = findViewById(R.id.change_date_button);
        FloatingActionButton saveButton = findViewById(R.id.add_save_button);

        boolean editing = recuperarExtras();

        if(!editing) { dateCalendar = Calendar.getInstance(); }

        dateText.setText(getStringFromCalendar(dateCalendar));

        changeDateButton.setOnClickListener(view -> calendarDialog());

        if(editing){
            saveButton.setOnClickListener(view -> atualizarCompromisso());
        }else{
            saveButton.setOnClickListener(view -> adicionarCompromisso());
        }

    }

    private boolean recuperarExtras(){
        if(getIntent().hasExtra("COMPROMISSO")){
            Bundle bundle = getIntent().getExtras();
            Compromisso compromisso = (Compromisso) bundle.get("COMPROMISSO");

            dateCalendar = compromisso.getData();
            tituloInput.setText(compromisso.getTitulo());
            descricaoInput.setText(compromisso.getDescricao());

            colorSelector.check(colorSelector.getChildAt(compromisso.getColorId()).getId());

            return true;
        }
        return false;
    }

    private void adicionarCompromisso() {

        int colorId = colorSelector.indexOfChild(findViewById(colorSelector.getCheckedRadioButtonId()));

        String titulo = tituloInput.getText().toString();
        String descricao = descricaoInput.getText().toString();

        Compromisso compromisso = new Compromisso(dateCalendar, titulo, descricao, colorId);

        MainActivity.addComrpomisso(compromisso);
        FileUtil.salvarCompromisso(compromisso, AddCompromissoActicity.this);

        mainActivityScreen();

    }

    private void atualizarCompromisso(){

        int colorId = colorSelector.indexOfChild(findViewById(colorSelector.getCheckedRadioButtonId()));

        String titulo = tituloInput.getText().toString();
        String descricao = descricaoInput.getText().toString();

        Compromisso compromisso = new Compromisso(dateCalendar, titulo, descricao, colorId);

        Bundle bundle = getIntent().getExtras();
        int posicao = (int)bundle.get("POSITION");

        MainActivity.atualizarCompromisso(compromisso, posicao);
        FileUtil.editarCompromissos(compromisso, posicao, AddCompromissoActicity.this);

        mainActivityScreen();

    }


    public void calendarDialog(){

        AlertDialog.Builder builder = new AlertDialog.Builder(AddCompromissoActicity.this);

        LayoutInflater layoutInflater = LayoutInflater.from(AddCompromissoActicity.this);
        View testeView = layoutInflater.inflate(R.layout.date_picker_layout, null);

        DatePicker datePicker = (DatePicker) testeView.findViewById(R.id.date);

        //atualiza a data do datePicker para a contida no dateCalendar
        datePicker.updateDate(dateCalendar.get(Calendar.YEAR),
                dateCalendar.get(Calendar.MONTH),
                dateCalendar.get(Calendar.DAY_OF_MONTH));
        
        builder.setPositiveButton("Ok", (dialogInterface, i) -> {
            dateCalendar = getCalendarFromDatePicker(datePicker);
            dateText.setText(getStringFromCalendar(dateCalendar));
        });

        builder.setView(testeView);
        builder.show();

    }

    public static String getStringFromCalendar(Calendar calendar){

        Locale locale = new Locale("pt", "BR");
        DateFormat dateFormat = new SimpleDateFormat("dd 'de' MMM ',' yyyy", locale);

        return dateFormat.format(calendar.getTime());

    }

    public static Calendar getCalendarFromDatePicker(DatePicker datePicker){
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        return calendar;
    }

    private void mainActivityScreen(){
        Intent intent = new Intent(AddCompromissoActicity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}