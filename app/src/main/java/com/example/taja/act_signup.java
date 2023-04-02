package com.example.taja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class act_signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.signup_page);
        Button buttonSignUp = findViewById(R.id.buttonSignUp);

        buttonSignUp.setOnClickListener(e -> {
            Intent i = new Intent(this, act_home.class);
            startActivity(i);
        });

    }
}