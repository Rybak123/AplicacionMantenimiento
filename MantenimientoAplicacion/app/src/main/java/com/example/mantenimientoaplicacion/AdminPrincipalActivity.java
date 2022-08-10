package com.example.mantenimientoaplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AdminPrincipalActivity extends AppCompatActivity {

    TextView tv_bienvenida;
    String username,id,email,roles,accesstoken;
    Button btn1,btn2,btn3,btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_principal);
        Bundle parametros = this.getIntent().getExtras();
        tv_bienvenida=findViewById(R.id.tv_Bienvenida);
        btn1=findViewById(R.id.btn_man1);
        btn2=findViewById(R.id.btn_man2);
        btn3=findViewById(R.id.btn_man3);
        btn4=findViewById(R.id.btn_man4);
        username=parametros.getString("USERNAME");
        roles=parametros.getString("ROLES");
        id=parametros.getString("ID");
        email=parametros.getString("EMAIL");
        accesstoken=parametros.getString("ACCESSTOKEN");
        tv_bienvenida.setText("Bienvenid@ "+ username);

        Intent intent =new Intent(this, AdminPrincipalAreas.class);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }
}