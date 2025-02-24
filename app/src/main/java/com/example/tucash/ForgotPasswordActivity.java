package com.example.tucash;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ForgotPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        EditText emailInput = findViewById(R.id.et_CorreoRecuperación); // Campo de correo
        EditText captchaInput = findViewById(R.id.etRespuesta); // Campo de captcha
        Button sendButton = findViewById(R.id.button); // Botón de enviar

        // Configurar la acción del botón
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailInput.getText().toString().trim();
                String captchaResponse = captchaInput.getText().toString().trim();

                // Validar el CAPTCHA (10 x 20 = 200)
                if (!captchaResponse.equals("200")) {
                    Toast.makeText(ForgotPasswordActivity.this, "Respuesta incorrecta. Intente de nuevo.", Toast.LENGTH_SHORT).show();
                    return; // Detener ejecución si el captcha es incorrecto
                }

                // Si pasa la validación, mostrar mensaje de confirmación
                Toast.makeText(ForgotPasswordActivity.this, "Se ha enviado un correo de recuperación a: " + email, Toast.LENGTH_LONG).show();
            }
        });
    }
}
