package com.xiagoz.parcial1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class CSeccond extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cseccond);
    }
    public void CPrimary(View v){
        Intent _i = new Intent(this, CPrimary.class);
        startActivity(_i);
    }
}
