package com.xiagoz.parcial1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table articulos(id int primary key autoincrement, descripcion text, estado text)");
        db.execSQL("create table listas(id int primary key autoincrement, fecha date, id_articulos int NOT NULL CONSTRAINT fk_articulos REFERENCES articulos(id) ON DELETE CASCADE ON UPDATE CASCADE, a_comprar boolean)");
        db.execSQL("create table fechas(id int primary key autoincrement, id_listas int NOT NULL CONSTRAINT fk_listas REFERENCES listas(id) ON DELETE CASCADE ON UPDATE CASCADE)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
