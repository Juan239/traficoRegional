package com.example.traficoregional;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.traficoregional.Controlador.Autenticacion;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.shashank.sony.fancytoastlib.FancyToast;

public class LogearseActivity extends AppCompatActivity {

    TextInputEditText correo;
    TextInputEditText contrasenia;
    Button btnLoguearse;
    Button btnRegistrarse;
    FirebaseAuth autenticacion;
    DatabaseReference baseDatos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        autenticacion = FirebaseAuth.getInstance();
        baseDatos = FirebaseDatabase.getInstance().getReference();

        correo = findViewById(R.id.);
        contrasenia = findViewById(R.id.);
        btnRegistrarse = findViewById(R.id.);
        btnLoguearse = findViewById(R.id.);

        btnLoguearse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarSesion();
            }
        });

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogearseActivity.this, RegistrarActivity.class);
                startActivity(intent);
            }
        });
    }

    private void iniciarSesion() {
        String correoObtenido = correo.getText().toString();
        String contraseniaObtenido = contrasenia.getText().toString();

        if (!correoObtenido.isEmpty() && !contraseniaObtenido.isEmpty()) {
            if (contraseniaObtenido.length() >= 6) {
                autenticacion.signInWithEmailAndPassword(correoObtenido, contraseniaObtenido).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(LogearseActivity.this, .class);
                            startActivity(intent);
                            finish();
                        }
                        else {
                            FancyToast.makeText(LogearseActivity.this, "La contraseña debe tener al menos 6 caracteres", FancyToast.LENGTH_LONG, FancyToast.ERROR, false).show();
                        }
                    }
                });
            }
        }
    }
}