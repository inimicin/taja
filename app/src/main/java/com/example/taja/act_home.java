package com.example.taja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

public class act_home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.home_page);

        ImageButton buttonProfile = findViewById(R.id.buttonProfile);

        buttonProfile.setOnClickListener(e -> {
            Intent i = new Intent(this, act_profile.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(i);
        });
    }
}