package com.example.taja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class act_profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);

        ImageButton buttonHome = findViewById(R.id.buttonHome);
        ImageButton buttonEditProfile = findViewById(R.id.buttonEditProfile);

        buttonHome.setOnClickListener(e -> {
            Intent i = new Intent(this, act_home.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(i);
        });

        buttonEditProfile.setOnClickListener(e -> {
            Intent i = new Intent(this, edit_profile.class);
            startActivity(i);
        });




    }
}