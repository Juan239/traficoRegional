package com.example.traficoregional;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.traficoregional.Controlador.Autenticacion;
import com.example.traficoregional.Controlador.ConexionUsuario;
import com.example.traficoregional.Modelo.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.shashank.sony.fancytoastlib.FancyToast;

public class RegistrarActivity extends AppCompatActivity {

    Autenticacion autenticacion;
    ConexionUsuario conexionUsuario;
    Button btnRegistrarUsuario;
    TextInputEditText inputEmail;
    TextInputEditText inputNombre;
    TextInputEditText inputContrasenia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        autenticacion = new Autenticacion();
        conexionUsuario = new ConexionUsuario();

        btnRegistrarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarUsuario();
            }
        });
    }

    void registrarUsuario() {
        final String correo = inputEmail.getText().toString();
        final String nombre = inputNombre.getText().toString();
        final String contrasenia = inputContrasenia.getText().toString();

        if (!correo.isEmpty() && !nombre.isEmpty() && !contrasenia.isEmpty()){
            if (contrasenia.length() >= 6){
                registrarse(nombre, correo, contrasenia);
            }
            else {
                FancyToast.makeText(RegistrarActivity.this, "Mínimo 6 caracteres", FancyToast.LENGTH_LONG, FancyToast.ERROR, false).show();
            }
        }
        else {
            FancyToast.makeText(RegistrarActivity.this, "Faltan campos por rellenar", FancyToast.LENGTH_LONG, FancyToast.ERROR, false).show();
        }
    }

    void registrarse(final String nombre, String correo, String contrasenia) {
        autenticacion.registrarse(correo, contrasenia).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    String id = FirebaseAuth.getInstance().getCurrentUser().getUid();
                    Usuario usuario = new Usuario(id, nombre, correo);
                    Crear(usuario);
                    FancyToast.makeText(RegistrarActivity.this, "Su registro fue exitoso", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, false).show();
                }
                else {
                    FancyToast.makeText(RegistrarActivity.this, "No se pudo registrar correctamente", FancyToast.LENGTH_LONG, FancyToast.ERROR, false).show();
                }
            }
        });
    }

    void Crear(Usuario usuario){
        conexionUsuario.create(usuario).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    //FancyToast.makeText(RegistrarActividad.this, "El registro fue exitoso", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, false).show();
                    //Intent intent = new Intent(RegistrarActivity.this, MapaClienteActividad.class);
                    //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    //startActivity(intent);
                }
                else {
                    FancyToast.makeText(RegistrarActivity.this, "No se pudo crear el usuario", FancyToast.LENGTH_LONG, FancyToast.ERROR, false).show();
                }
            }
        });
    }
}