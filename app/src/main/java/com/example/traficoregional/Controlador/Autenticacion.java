package com.example.traficoregional.Controlador;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Autenticacion {
    FirebaseAuth autenticacion;

    public Autenticacion() {
        autenticacion = FirebaseAuth.getInstance();
    }

    public Task<AuthResult> registrarse(String email, String contrasenia){
        return autenticacion.createUserWithEmailAndPassword(email, contrasenia);
    }
    public Task<AuthResult> logearse(String email, String contrasenia){
        return autenticacion.signInWithEmailAndPassword(email, contrasenia);
    }

    public String getId(){
        return autenticacion.getCurrentUser().getUid();
    }

}
