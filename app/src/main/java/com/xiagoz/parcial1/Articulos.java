package com.xiagoz.parcial1;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Articulos extends AppCompatActivity implements View.OnClickListener {

    private Button btnNew, btnDelete, btnUpdate, btnSave, btnConsultar, btnNext, btnPrevius;
    private EditText txtNombre, txtApellido;
    private TextView txtConsultar;
    Cursor dbCursor = null;
    int _id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.articulos);

        btnNew = findViewById(R.id.btnNuevo);
        btnDelete = findViewById(R.id.btnEliminar);
        btnUpdate = findViewById(R.id.btnActualizar);
        btnNext = findViewById(R.id.btnSiguiente);
        btnPrevius = findViewById(R.id.btnAnterior);
        btnSave = findViewById(R.id.btnGuardar);
        btnConsultar = findViewById(R.id.btnConsultas);

        txtNombre = findViewById(R.id.txtArticulo);
        txtApellido = findViewById(R.id.txtEstado);
        txtConsultar = findViewById(R.id.txt_consultar);

        btnConsultar.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnNew.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnSave.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnPrevius.setOnClickListener(this);
    }

    public void MainActivity(View v) {
        Intent _i = new Intent(this, MainActivity.class);
        startActivity(_i);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.btnNuevo:
                txtApellido.setText("");
                txtNombre.setText("");
                break;
            case R.id.btnEliminar:
                if (_id > 0) {
                    DeleteRecord();
                    GetAllData();
                }
                break;
            case R.id.btnAnterior:
                if (dbCursor.moveToPrevious()) {
                    txtApellido.setText(dbCursor.getString(2));
                    txtNombre.setText(dbCursor.getString(1));
                    _id = dbCursor.getInt(0);
                }
                break;
            case R.id.btnSiguiente:
                if (dbCursor.moveToNext()) {
                    txtApellido.setText(dbCursor.getString(2));
                    txtNombre.setText(dbCursor.getString(1));
                    _id = dbCursor.getInt(0);
                }
                break;
            case R.id.btnGuardar:
                Boolean sw = false;
                sw = setData();
                break;
            case R.id.btnActualizar:
                modificar();
                break;
            case R.id.btnConsultas:
                consultar();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + id);
        }

    }

    private void consultar() {
        try {
            AppSQLiteOpenHepler _SQLite = new AppSQLiteOpenHepler(this);
            SQLiteDatabase db = _SQLite.getWritableDatabase();

            dbCursor = null;

            dbCursor = db.rawQuery("SELECT * FROM articulos ORDER BY _id", null);

            txtConsultar.setText("");
            if (dbCursor != null) {
                if(dbCursor.moveToFirst()) {
                    do {
                        String cod = dbCursor.getString(0);
                        String descripcion = dbCursor.getString(1);
                        String estado = dbCursor.getString(2);

                        txtConsultar.append(cod + ": " + descripcion +"\nEstado: "+ estado +"\n");
                        txtConsultar.setMovementMethod(new ScrollingMovementMethod());
                    } while (dbCursor.moveToNext());
                }
            }
        } catch (Exception _ex) {
            Toast.makeText(getApplicationContext(),  "Error al Consultar", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean DeleteRecord() {
        boolean sw = false;
        AppSQLiteOpenHepler _SQLite = new AppSQLiteOpenHepler(this);
        if (_id != 0) {
            try {
                SQLiteDatabase db = _SQLite.getWritableDatabase();
                int result = db.delete("articulos", "_id = " + String.valueOf(_id), null);
                Toast.makeText(this, "Usuario Eliminado", Toast.LENGTH_SHORT).show();
                db.close();
                if (result > 0) {
                    sw = true;
                    this.txtApellido.setText("");
                    this.txtNombre.setText("");
                }
            } catch (Exception _ex) {

            }
        }
        return sw;
    }

    public void GetAllData () {
        AppSQLiteOpenHepler _SQLite = new AppSQLiteOpenHepler(this);
        SQLiteDatabase db = _SQLite.getWritableDatabase();
        dbCursor = null;

        try {
            dbCursor = db.rawQuery("SELECT * FROM articulos ORDER BY descripcion", null);
            if (dbCursor != null) {
                dbCursor.moveToFirst();
            }
        } catch (Exception _ex) {

        }
    }

    public Boolean setData() {
        Boolean sw = false;
        AppSQLiteOpenHepler _SQLite = new AppSQLiteOpenHepler(this);
        if (this.txtNombre.getText().toString() != "" &&
                this.txtApellido.getText().toString() != "") {
            try {
                SQLiteDatabase db = _SQLite.getWritableDatabase();
                ContentValues rows = new ContentValues();
                rows.put("descripcion", this.txtNombre.getText().toString());
                rows.put("estado", this.txtApellido.getText().toString());
                db.insert("articulos", null, rows);
                Toast.makeText(this, "Usuario Agregado", Toast.LENGTH_SHORT).show();
                db.close();

                sw = true;

                this.txtNombre.setText("");
                this.txtApellido.setText("");
                this.GetAllData();
            }
            catch (Exception _ex) {

            }
        } else {

        }
        return sw;
    }

    //Método para modificar un artículo o producto
    public void modificar() {
        AppSQLiteOpenHepler _SQLite = new AppSQLiteOpenHepler(this);
        SQLiteDatabase db = _SQLite.getWritableDatabase();

        if (this.txtNombre.getText().toString() != "" &&
                this.txtApellido.getText().toString() != "") {
            ContentValues rows = new ContentValues();
            rows.put("descripcion", this.txtNombre.getText().toString());
            rows.put("estado", this.txtApellido.getText().toString());

            int cantidad = db.update("articulos", rows,"_id = " + String.valueOf(_id), null);
            db.close();

            if(cantidad == 1){
                Toast.makeText(this, "Artículo modificado correctamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "El artículo no existe", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

}