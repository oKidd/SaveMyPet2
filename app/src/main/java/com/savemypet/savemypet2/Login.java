package com.savemypet.savemypet2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private EditText etCorreo, etPass;
    FirebaseAuth fbAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        fbAuth = FirebaseAuth.getInstance();

        etCorreo = findViewById(R.id.login_email);
        etPass = findViewById(R.id.login_pass);
    }

    public void setup(View v) {
        String correo = etCorreo.getText().toString().trim();
        String pass = etPass.getText().toString().trim();
        if (!correo.isEmpty() && !pass.isEmpty()){
            loginUser(correo, pass);
        } else {
            Toast.makeText(this, "Debe ingresar ambas datos", Toast.LENGTH_SHORT).show();
        }
    }

    private void loginUser(String correo, String pass) {
        fbAuth.signInWithEmailAndPassword(correo, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    finish();
                    Intent iHome = new Intent(Login.this,Home.class);
                    startActivity(iHome);
                    Toast.makeText(Login.this, "Bienvenid@", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Login.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Login.this, "Error al iniciar sesion", Toast.LENGTH_SHORT).show();
            }
        });
    }
}