package com.xiagoz.parcial1;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class CompraActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    //REFERENCIA
    ListView listViewAgenda;

    //ARRAY DONDE VAMOS A GUARDAR LA AGENDA EXTRAIDA EN LA BASE DE DATOS.
    ArrayList<String> listaAgenda;

    //LLAMADA A LA DB
    AdminSQLiteOpenHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra);

        //CONEXIÓN
        db = new AdminSQLiteOpenHelper(getApplicationContext(), "db", null, 1);

        ImageView imageView = (ImageView) findViewById(R.id.imgBtnNewList);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });

        //ListView del xml con el .java
        listViewAgenda = (ListView) findViewById(R.id.listViewAgenda);


    }

    public void _MainActivity(View v){
        Intent _i = new Intent(this, MainActivity.class);
        startActivity(_i);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());

        //TextView textView = (TextView) findViewById(R.id.txtDate);
        //textView.setText(currentDateString);

        //AGREGAR DATOS AL BOTON
        Button btnAgenda = (Button) findViewById(R.id.btn_NameList);
        btnAgenda.setText(currentDateString);
    }


}
