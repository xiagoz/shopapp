package com.xiagoz.parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//    private EditText et_descripcion, et_estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void MainAcivity(View v){
        Intent _i = new Intent(this, MainActivity.class);
        startActivity(_i);
    }

    public void _CPrimary(View v){
        Intent _i = new Intent(this, CPrimary.class);
        startActivity(_i);
    }

    public void _Articulos(View v){
        Intent _i = new Intent(this, Articulos.class);
        startActivity(_i);
    }

    public void _CompraActivity(View v){
        Intent _i = new Intent(this, CompraActivity.class);
        startActivity(_i);
    }

    public void _ListaActivity(View v){
        Intent _i = new Intent(this, CompraActivity.class);
        startActivity(_i);
    }

//    //Método para insertar un producto
//    public void Registrar(View view){
//        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "db", null, 1);
//        SQLiteDatabase db = admin.getWritableDatabase();
//
//        String descripcion = et_descripcion.getText().toString();
//        String estado = et_estado.getText().toString();
//
//        if(!descripcion.isEmpty() && !estado.isEmpty()){
//            ContentValues registro = new ContentValues();
//
//            registro.put("descripcion", descripcion);
//            registro.put("estado", estado);
//
//            db.insert("articulos", null, registro);
//
//            db.close();
//            et_descripcion.setText("");
//            et_estado.setText("");
//
//            Toast.makeText(this,"Registro exitoso", Toast.LENGTH_SHORT).show();
//        } else{
//            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    //Método para consultar un artículo
//    public void Buscar(View view){
//        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "db", null, 1);
//        SQLiteDatabase db = admin.getWritableDatabase();
//
//        String descripcion = et_descripcion.getText().toString();
//
//        if(!descripcion.isEmpty()){
//            Cursor texto = db.rawQuery
//                    ("select descripcion, estado from articulos where descripcion =" + descripcion, null);
//
//            if(texto.moveToFirst()){
//                et_descripcion.setText(texto.getString(0));
//                et_estado.setText(texto.getString(1));
//                db.close();
//            } else {
//                Toast.makeText(this,"No existe el artículo", Toast.LENGTH_SHORT).show();
//                db.close();
//            }
//
//        } else {
//            Toast.makeText(this, "Debes introducir el código del artículo", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    //Método para eliminar un artículo
//    public void Eliminar(View view){
//        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper
//                (this, "db", null, 1);
//        SQLiteDatabase db = admin.getWritableDatabase();
//
//        String descripcion = et_descripcion.getText().toString();
//
//        if(!descripcion.isEmpty()){
//
//            int cantidad = db.delete("articulos", "descripcion=" + descripcion, null);
//            db.close();
//
//            et_descripcion.setText("");
//            et_estado.setText("");
//
//            if(cantidad == 1){
//                Toast.makeText(this, "Artículo eliminado exitosamente", Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(this, "El artículo no existe", Toast.LENGTH_SHORT).show();
//            }
//
//        } else {
//            Toast.makeText(this, "Debes de introducir el código del artículo", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    //Método para modificar un artículo o producto
//    public void Modificar(View view){
//        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "db", null, 1);
//        SQLiteDatabase db = admin.getWritableDatabase();
//
//        String descripcion = et_descripcion.getText().toString();
//        String estado = et_estado.getText().toString();
//
//        if(!descripcion.isEmpty() && !estado.isEmpty()){
//
//            ContentValues regact = new ContentValues();
//            regact.put("descripcion", descripcion);
//            regact.put("estado", estado);
//
//            int cantidad = db.update("articulos", regact, "descripcion=" + descripcion, null);
//            db.close();
//
//            if(cantidad == 1){
//                Toast.makeText(this, "Artículo modificado correctamente", Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(this, "El artículo no existe", Toast.LENGTH_SHORT).show();
//            }
//
//        } else {
//            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
//        }
//    }
}
