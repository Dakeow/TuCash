package com.example.tucash;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText etNombre, etApellido, etCedula, etFechaNacimiento, etCelular, etContraseña, etConfirmarContraseña;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Inicializar
        etNombre = findViewById(R.id.etNombre_Registro);
        etApellido = findViewById(R.id.etApellido_Registro );
        etCedula = findViewById(R.id.etCedula_Registro);
        etFechaNacimiento = findViewById(R.id.etFechaNacimiento_Registro);
        etCelular = findViewById(R.id.etCelular_Registro);
        etContraseña = findViewById(R.id.etContraseña_Registro);
        etConfirmarContraseña = findViewById(R.id.etConfirmarContraseña_Registro);

        Button registerButton = findViewById(R.id.register_button);

        dbHelper = new DBHelper(this);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Obtener valores ingresados
                String nombre = etNombre.getText().toString().trim();
                String apellido = etApellido.getText().toString().trim();
                String cedula = etCedula.getText().toString().trim();
                String fechaNacimiento = etFechaNacimiento.getText().toString().trim();
                String celular = etCelular.getText().toString().trim();
                String contrasena = etContraseña.getText().toString().trim();
                String confirmarContrasena = etConfirmarContraseña.getText().toString().trim();

                // Validación básica
                if (nombre.isEmpty() || apellido.isEmpty() || cedula.isEmpty() || fechaNacimiento.isEmpty() ||
                        celular.isEmpty() || contrasena.isEmpty() || confirmarContrasena.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!contrasena.equals(confirmarContrasena)) {
                    Toast.makeText(RegisterActivity.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Insertar datos en SQLite
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(DBHelper.COLUMN_NOMBRE, nombre);
                values.put(DBHelper.COLUMN_APELLIDO, apellido);
                values.put(DBHelper.COLUMN_CEDULA, cedula);
                values.put(DBHelper.COLUMN_FECHA_NACIMIENTO, fechaNacimiento);
                values.put(DBHelper.COLUMN_CELULAR, celular);
                values.put(DBHelper.COLUMN_CONTRASENA, contrasena);

                long newRowId = db.insert(DBHelper.TABLE_USERS, null, values);
                if(newRowId != -1) {
                    Toast.makeText(RegisterActivity.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegisterActivity.this, "Error al registrar", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
