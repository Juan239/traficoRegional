package com.example.traficoregional;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btnRegistrar;
    ImageView imgFacebook, imgGoogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar botones e imágenes
        btnRegistrar = findViewById(R.id.btnRegistrar);
        imgFacebook = findViewById(R.id.imgFacebook);
        imgGoogle = findViewById(R.id.imgGoogle);

        // BOTON REGISTRO
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, registroActivity.class);
                startActivity(intent);
            }
        });

        // BOTÓN FACEBOOK
        imgFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.facebook.com";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        // BOTÓN GOOGLE
        imgGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.google.com";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
    }
}
