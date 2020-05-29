package com.xiagoz.parcial1;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CSeccond extends AppCompatActivity {

    private TextView txtConsultar;
    private EditText txtProductos;
    private Button btnMostrar;

    Cursor dbCursor = null;

    public static String[] Productos ={
            "Leche",
            "Pollo",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cseccond);

        txtConsultar = findViewById(R.id.txt_consultar);

        txtProductos =  (EditText) findViewById(R.id.txt_ingresoProducto);
        btnMostrar = (Button) findViewById(R.id.agregarProducto);

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String productos = null;
                productos = txtProductos.getText().toString();
            }
            });


        consultar();

        LinearLayout seccionProductos = (LinearLayout) findViewById(R.id.seccion_productos);

        for (String productos : Productos) {
            CheckBox opcion = new CheckBox(this);
            opcion.setText(productos);
            opcion.setLayoutParams(
                    new LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
            seccionProductos.addView(opcion);
        }
    }


    public void CPrimary(View v){
        Intent _i = new Intent(this, CPrimary.class);
        startActivity(_i);
    }


    private void consultar() {
        try {
            AppSQLiteOpenHepler _SQLite = new AppSQLiteOpenHepler(getApplicationContext(), "db", this, 1);
            SQLiteDatabase db = _SQLite.getWritableDatabase();

            dbCursor = null;

            dbCursor = db.rawQuery("SELECT descripcion FROM articulos WHERE estado = 'Activo' ORDER BY _id", null);

            txtConsultar.setText("");
            if (dbCursor != null) {
                if(dbCursor.moveToFirst()) {
                    do {
                        String descripcion = dbCursor.getString(0);

                        txtConsultar.append(descripcion +"\n\n");
                        txtConsultar.setMovementMethod(new ScrollingMovementMethod());
                    } while (dbCursor.moveToNext());
                }
            }
        } catch (Exception _ex) {
            Toast.makeText(getApplicationContext(),  "Error al Consultar", Toast.LENGTH_SHORT).show();
        }
    }

}
