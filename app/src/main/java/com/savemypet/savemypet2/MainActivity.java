package com.savemypet.savemypet2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth fbAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fbAuth = FirebaseAuth.getInstance();
    }

    public void irALogin(View v){
        Intent iLogin = new Intent(MainActivity.this, Login.class);
        startActivity(iLogin);
    }

    public void irARegistro(View v){
        Intent iRegistro = new Intent(MainActivity.this, Register.class);
        startActivity(iRegistro);
    }

    @Override
    protected void onStart(){
        super.onStart();
        FirebaseUser user = fbAuth.getCurrentUser();

        if (user != null){
            finish();
            Intent iHome = new Intent(MainActivity.this, Home.class);
            startActivity(iHome);

        }
    }
}