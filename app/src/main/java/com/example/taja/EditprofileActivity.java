package com.example.taja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.taja.databinding.ActivityEditprofileBinding;
import com.example.taja.ui.login.LoginActivity;

public class EditprofileActivity extends AppCompatActivity {

    ActivityEditprofileBinding activityEditprofileBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityEditprofileBinding = ActivityEditprofileBinding.inflate(getLayoutInflater());

        setContentView(activityEditprofileBinding.getRoot());

        Button btnLogout = activityEditprofileBinding.buttonLogout;

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                finish();
            }
        });
    }
}