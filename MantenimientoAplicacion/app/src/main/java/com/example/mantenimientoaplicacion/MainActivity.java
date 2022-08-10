package com.example.mantenimientoaplicacion;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class MainActivity extends AppCompatActivity {
    TextView etUserName,etPassword;
    Button btn_autenticacion;
    RequestQueue requestQueue;

    JSONObject jsonBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUserName=findViewById(R.id.et_username);
        etPassword=findViewById(R.id.et_password);
        btn_autenticacion=findViewById(R.id.btn_autenticar);
        btn_autenticacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                coneccion();
            }
        });
    }
    private void coneccion(){
        String username=etUserName.getText().toString().trim();
        String password=etPassword.getText().toString().trim();
        jsonBody = new JSONObject();
        try {
            jsonBody.put("username", username);
            jsonBody.put("password", password);
            String url = "https://radiant-brushlands-87790.herokuapp.com/api/auth/signin/";
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                    (Request.Method.POST, url, jsonBody, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            pasarDeActividad(response);
                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(MainActivity.this, "Nombre de usuario o contraseña incorrectos.", Toast.LENGTH_SHORT).show();
                        }
                    });
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(jsonObjectRequest);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void pasarDeActividad(JSONObject respuesta) {
        Bundle extras = new Bundle();

        try {
            extras.putString("ID",respuesta.getString("id"));
            extras.putString("USERNAME", respuesta.getString("username"));
            extras.putString("EMAIL", respuesta.getString("email"));
            extras.putString("ROLES", respuesta.getJSONArray("roles").getString(0));
            extras.putString("ACCESSTOKEN", respuesta.getString("accessToken"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Intent intent=new Intent(this,AdminPrincipalActivity.class);
        intent.putExtras(extras);
        startActivity(intent);
    }
}