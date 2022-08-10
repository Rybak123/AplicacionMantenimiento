package com.example.mantenimientoaplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminPrincipalAreas extends AppCompatActivity {

    Button btn_juegos_tierras_altas,btn_juegos_tierras_medias,btn_juegos_tierras_bajas,btn_juegos_taypi,btn_juegos_macroregiones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_principal_areas);
        btn_juegos_tierras_altas=findViewById(R.id.btn_juegos_tierras_altas);
        btn_juegos_tierras_medias=findViewById(R.id.btn_juegos_tierras_medias);
        btn_juegos_tierras_bajas=findViewById(R.id.btn_juegos_tierras_bajas);
        btn_juegos_taypi=findViewById(R.id.btn_juegos_taypi);
        btn_juegos_macroregiones=findViewById(R.id.btn_juegos_macroregiones);

        btn_juegos_tierras_altas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToTierrasAltas();
            }
        });


    }
    void goToTierrasAltas(){
        Intent intent=new Intent(this,Juegos_TierrasAltas.class);
        startActivity(intent);
    }
}