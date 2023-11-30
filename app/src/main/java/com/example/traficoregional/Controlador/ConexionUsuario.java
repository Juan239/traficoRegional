package com.example.traficoregional.Controlador;

import com.example.traficoregional.Modelo.Usuario;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class ConexionUsuario {
    DatabaseReference basedatos;

    public ConexionUsuario() {
        basedatos = FirebaseDatabase.getInstance().getReference().child("Usuario");
    }

    public Task<Void> create(Usuario usuario){
        Map<String, Object> map = new HashMap<>();
        map.put("nombre", usuario.getNombre());
        map.put("email", usuario.getCorreo());
        return basedatos.child(usuario.getId()).setValue(map);
    }

    public DatabaseReference getUsuario(String idUsuario) {
        return basedatos.child(idUsuario);
    }
}
