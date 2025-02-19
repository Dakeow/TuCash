package com.example.tucash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Duración del Splash Screen en milisegundos (3000 ms = 3 segundos)
        int SPLASH_DISPLAY_LENGTH = 3000;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Crear un Intent para iniciar el siguiente Activity (LoginActivity)
                Intent mainIntent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(mainIntent);
                finish(); // Cerrar este Activity para que no se pueda volver atrás
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}