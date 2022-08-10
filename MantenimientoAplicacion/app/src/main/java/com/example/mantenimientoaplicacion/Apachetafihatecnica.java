package com.example.mantenimientoaplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class Apachetafihatecnica extends AppCompatActivity {

    ImageView img_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apachetafihatecnica);
        img_view=findViewById(R.id.imageView2);

        Picasso.with(this).load(R.drawable.apacheta).into(img_view);

    }
}