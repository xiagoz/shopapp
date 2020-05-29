package com.xiagoz.parcial1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

public class ListaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        ImageView imageView = (ImageView) findViewById(R.id.imgBtnGuardarAgenda);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });
    }

    public void _CompraActivity(View v){
        Intent _i = new Intent(this, MainActivity.class);
        startActivity(_i);
    }

    /*public void _ListaActivity(View v){
        Intent _i = new Intent(this, CompraActivity.class);
        startActivity(_i);
    }*/

}
