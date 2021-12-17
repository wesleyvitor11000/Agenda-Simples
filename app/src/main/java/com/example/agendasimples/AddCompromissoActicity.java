package com.example.agendasimples;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddCompromissoActicity extends AppCompatActivity {

    TextView dateText;
    Calendar dateCalendar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_compromisso_acticity);

        dateText = findViewById(R.id.data_text);
        dateCalendar = Calendar.getInstance();
        Button changeDateButton = findViewById(R.id.change_date_button);

        dateText.setText(getStringFromCalendar(dateCalendar));

        changeDateButton.setOnClickListener(view -> calendarDialog());

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

}