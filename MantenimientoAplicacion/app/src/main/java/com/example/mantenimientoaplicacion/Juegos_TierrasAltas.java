package com.example.mantenimientoaplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Juegos_TierrasAltas extends AppCompatActivity {

    Button btn_apacheta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juegos_tierras_altas);
        btn_apacheta=findViewById(R.id.btn_juegos_tierras_altas);
        btn_apacheta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               goToApachet();
            }
        });
    }

    private void goToApachet() {
        Intent intent=new Intent(this,Apachetafihatecnica.class);
        startActivity(intent);
    }
}