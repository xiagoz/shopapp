package com.xiagoz.parcial1;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class CompraActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    //REFERENCIA
    ListView listViewAgenda;

    //ARRAY DONDE VAMOS A GUARDAR LA AGENDA EXTRAIDA EN LA BASE DE DATOS.
    //ArrayList<Agenda> listaAgenda;
    ArrayList<String> listaInformacion;

    //LLAMADA A LA DB
    AppSQLiteOpenHepler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra);

        ImageView imageView = (ImageView) findViewById(R.id.imgBtnGuardarAgenda);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });

        //CONEXIÓN
        db = new AppSQLiteOpenHepler(getApplicationContext(), "db", null, 1);

        //ListView del xml con el .java
        listViewAgenda = (ListView) findViewById(R.id.listViewAgenda);

        //CONSULTAR A LA LISTA DE AGENDA
        //consultarListaAgenda();

        //ENVIA LA INFORMACIÓN QUE SE QUIERE MOSTRAR EN EL ACTIVITY
        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaInformacion);
        //listViewAgenda.setAdapter(adaptador);
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

    //MÉTODO PARA HACER LA CONSULTA A LA DB POR LA LISTA DE AGENDA
    /*private void consultarListaAgenda(){
        SQLiteDatabase daba = db.getReadableDatabase();

        Agenda agenda = null;
        listaAgenda = new ArrayList<Agenda>();

        //QUERY A LA TABLA AGENDA
        Cursor cursor = daba.rawQuery("SELECT * FROM "+TABLA_NOMBRES, null);

        while (cursor.moveToNext()){
            agenda = new Agenda();
            agenda.setId(cursor.getInt(0));
            agenda.setNombre(cursor.getString(1));

            listaAgenda.add(agenda);
        }
        obtenerLista();
    }*/

    /*private void obtenerLista() {

        listaInformacion = new ArrayList<String>();

        for(int i = 0; i < listaAgenda.size(); i++)
        {
            listaInformacion.add(listaAgenda.get(i).getId()+" - "+listaAgenda.get(i).getNombre());
        }
    }*/

    public void _ListaActivity(View view){
        Intent _i = new Intent(this, ListaActivity.class);
        startActivity(_i);
    }
}
