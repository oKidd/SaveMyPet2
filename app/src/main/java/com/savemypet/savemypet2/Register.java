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
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    private EditText etRegUsuario, etRegFono, etRegCorreo, etRegPass;
    FirebaseAuth fbAuth;
    FirebaseFirestore fbFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fbFirestore = FirebaseFirestore.getInstance();
        fbAuth = FirebaseAuth.getInstance();

        etRegCorreo = findViewById(R.id.register_email);
        etRegUsuario = findViewById(R.id.register_username);
        etRegPass = findViewById(R.id.register_pass);
        etRegFono = findViewById(R.id.register_phone);
    }
    public void registrarUsuario(View v){
        String userName = etRegUsuario.getText().toString().trim();
        String correo = etRegCorreo.getText().toString().trim();
        String pass = etRegPass.getText().toString().trim();
        String fono = etRegFono.getText().toString().trim();

        if (userName.isEmpty() && correo.isEmpty() && pass.isEmpty()){
            Toast.makeText(this, "Complete todos los datos", Toast.LENGTH_SHORT).show();
        } else if (userName.isEmpty() && correo.isEmpty()){
            Toast.makeText(this, "Complete todos los datos", Toast.LENGTH_SHORT).show();
        } else if (correo.isEmpty() && pass.isEmpty()){
            Toast.makeText(this, "Complete todos los datos", Toast.LENGTH_SHORT).show();
        } else if (userName.isEmpty() && pass.isEmpty()){
            Toast.makeText(this, "Complete todos los datos", Toast.LENGTH_SHORT).show();
        } else if (pass.length()<8){
            Toast.makeText(this, "La contraseña debe tener como minimo 8 caracteres", Toast.LENGTH_SHORT).show();
        }else {
            registrarUser(userName,correo,pass,fono);
        }
    }

    public void registrarUser(String user,String correo,String pass, String fono) {
        fbAuth.createUserWithEmailAndPassword(correo,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                String id = fbAuth.getCurrentUser().getUid();
                Map<String, Object> map = new HashMap<>();
                map.put("id",id);
                map.put("name",user);
                map.put("email",correo);
                map.put("password",pass);
                map.put("fono",fono);

                fbFirestore.collection("user").document(id).set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        finish();
                        Intent iLogin = new Intent(Register.this,Login.class);
                        startActivity(iLogin);

                        Toast.makeText(Register.this, "Usuario Registrado", Toast.LENGTH_SHORT).show();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Register.this, "error 2", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Register.this, "error 1", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void irALogin(View v){
        finish();
        Intent iLogin = new Intent(Register.this, Login.class);
}



}