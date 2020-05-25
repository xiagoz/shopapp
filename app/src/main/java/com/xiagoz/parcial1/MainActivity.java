package com.xiagoz.parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void _CPrimary(View v){
        Intent _i = new Intent(this, CPrimary.class);
        startActivity(_i);
    }

//    public void _CSeccond(View v){
//        Intent _i = new Intent(this, CPrimary.class);
//        startActivity(_i);
//    }
}
