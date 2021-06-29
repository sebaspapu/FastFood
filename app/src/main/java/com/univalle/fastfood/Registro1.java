package com.univalle.fastfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Registro1 extends AppCompatActivity {


    Button botonRegistrarse, botonRegistrarse2;
    Button botonRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro1);

        botonRegistrarse = (Button) findViewById(R.id.button3);
        botonRegistrarse2 = (Button) findViewById(R.id.button4);
        botonRegresar = (Button) findViewById(R.id.button6);

        botonRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToRegistrar = new Intent(Registro1.this, RegistroP.class);
                startActivity(intToRegistrar);
            }
        });

        botonRegistrarse2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToRegistrar = new Intent(Registro1.this, RegistroE.class);
                startActivity(intToRegistrar);
            }
        });

        botonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent devuelvase = new Intent(Registro1.this, Login.class);
                startActivity(devuelvase);
            }
        });

    }



}