package com.example.taja.ui.login;

import android.app.Activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.taja.ContainerActivity;
import com.example.taja.R;
import com.example.taja.SignupActivity;
import com.example.taja.ui.login.LoginViewModel;
import com.example.taja.ui.login.LoginViewModelFactory;
import com.example.taja.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private LoginViewModel loginViewModel;
    private ActivityLoginBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final EditText inputUsername = binding.inputUname;
        final EditText inputPw = binding.inputPassword;
        final Button buttonLogin = binding.buttonLogin;
        final Button buttonSignUp = binding.buttonSignUp;


      buttonLogin.setOnClickListener(this);
      buttonSignUp.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonLogin) {
            Intent i = new Intent(this, ContainerActivity.class);
            startActivity(i);
            finish();
        } else if (view.getId() == R.id.buttonSignUp) {
            Intent i = new Intent(this, SignupActivity.class);
            startActivity(i);
        }
    }
    private void updateUiWithUser(LoggedInUserView model) {
        String welcome = getString(R.string.welcome) + model.getDisplayName();
        // TODO : initiate successful logged in experience
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }
}