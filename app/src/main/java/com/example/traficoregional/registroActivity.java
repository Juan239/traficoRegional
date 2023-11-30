package com.example.traficoregional;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class registroActivity extends AppCompatActivity {


    EditText nombreCompleto, apellidoCompleto, correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nombreCompleto = findViewById(R.id.editTextnombreCompleto);
        apellidoCompleto = findViewById(R.id.editTextapellidoCompleto);
        correo = findViewById(R.id.editTextCorreo);

        //BASE DE DATOS
    }
}