package com.example.traficoregional;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class inicioSesionActivity extends AppCompatActivity {

    TextInputEditText email;
    TextInputEditText contrasenia;
    Button ingresar, registrarse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        email = findViewById(R.id.txtEmail);
        contrasenia = findViewById(R.id.txtContrasenia);
        ingresar = findViewById(R.id.btnIniciarSesion);
        registrarse = findViewById(R.id.btnRegistrarse);

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailText = email.getText().toString();
                String contraseniaText = contrasenia.getText().toString();

                if (emailText.isEmpty() || contraseniaText.isEmpty()) {
                    // Mostrar un mensaje de error o realizar alguna acción cuando los campos estén vacíos
                    // Por ejemplo
                    Toast.makeText(inicioSesionActivity.this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
                } else {

                }
            }
        });

        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), registroActivity.class);
                startActivity(intent);
            }
        });
    }
}