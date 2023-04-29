package com.example.taja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.taja.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.act_home);

        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();

//        Button buttonLogin = findViewById(R.id.buttonLogin);
//        Button buttonSignUp = findViewById(R.id.buttonSignUp);
//
//        buttonLogin.setOnClickListener(e -> {
//            Intent i = new Intent(this, act_home.class);
//            startActivity(i);
//        });
//
//        buttonSignUp.setOnClickListener(e -> {
//            Intent i = new Intent(this, act_signup.class);
//            startActivity(i);
//        });


    }
}