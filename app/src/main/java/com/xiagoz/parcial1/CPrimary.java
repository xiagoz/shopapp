package com.xiagoz.parcial1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class CPrimary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cprimary);
    }

    public void MainActivity(View v){
        Intent _i = new Intent(this, MainActivity.class);
        startActivity(_i);
    }

    public void _CSeccond(View v){
        Intent _i = new Intent(this, CSeccond.class);
        startActivity(_i);
    }
}

