package com.example.smartshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

     private EditText Email, Password;
    String user_email, user_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Email = findViewById(R.id.EditTextEmail);
        Password = findViewById(R.id.EditTextPassword);
        Button login = findViewById(R.id.btnLogin);
        TextView register = findViewById(R.id.TextViewRegister);
        TextView adminLogin = findViewById(R.id.TextViewAdminLogin);
        TextView forgotPassword = findViewById((R.id.TextViewFGP));

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Email.getText().toString(), Password.getText().toString());
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
            }
        });

        adminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, AdminLoginActivity.class));
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, CompDepActivity.class));
            }
        });

    }

    private void validate(String userEmail, String userPassword) {
        if (userEmail.isEmpty() && userPassword.isEmpty()) {
            Toast.makeText(this, "Please enter the correct details!", Toast.LENGTH_SHORT).show();
        } else {
            user_email = Email.getText().toString();
            user_pass = Password.getText().toString();
            String method = "login";
            BackgroundTask backgroundTask = new BackgroundTask(LoginActivity.this);
            backgroundTask.execute(method,user_email,user_pass);
        }
    }

}
