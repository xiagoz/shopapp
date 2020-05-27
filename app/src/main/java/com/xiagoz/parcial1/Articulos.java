package com.xiagoz.parcial1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Articulos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.articulos);
    }

    public void MainActivity(View v){
        Intent _i = new Intent(this, MainActivity.class);
        startActivity(_i);
    }
}
