package com.xiagoz.parcial1;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AppSQLiteOpenHepler extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ejemplo.db";
    public static final String TABLA_NOMBRES = "articulos";
    public static final String COLUMNA_ID = "_id";
    public static final String COLUMNA_NOMBRE = "descripcion";

    public static final String TABLA_AGENDA = "agenda";

    String _SQL = "CREATE TABLE "+ TABLA_NOMBRES+"(_id integer primary key autoincrement, descripcion text not null, estado text not null)";
    String _QUERY = "CREATE TABLE "+ TABLA_AGENDA+"(_id integer primary key autoincrement, agenda text)";

    public AppSQLiteOpenHepler(Context applicationContext, String db, Context context, int i) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(_SQL);
        db.execSQL(_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        try {
            //db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME + "");
        } catch (SQLException e) {
            //exepciones
        }
    }
}

































//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import androidx.annotation.Nullable;
//
//public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
//    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, name, factory, version);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("create table productos(id int primary key autoincrement, descripcion text, estado text)");
//        db.execSQL("create table listas(id int primary key autoincrement, fecha date, id_productos int NOT NULL CONSTRAINT fk_productos REFERENCES productos(id) ON DELETE CASCADE ON UPDATE CASCADE, a_comprar boolean)");
//        db.execSQL("create table fechas(id int primary key autoincrement, id_listas int NOT NULL CONSTRAINT fk_listas REFERENCES listas(id) ON DELETE CASCADE ON UPDATE CASCADE)");
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//
//    }
//}
