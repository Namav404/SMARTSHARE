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
    private Button Login;
    private TextView Register, AdminLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Email = (EditText)findViewById(R.id.EditTextEmail);
        Password = (EditText)findViewById(R.id.EditTextPassword);
        Login = (Button)findViewById(R.id.btnLogin);
        Register = (TextView)findViewById(R.id.TextViewRegister);
        AdminLogin = (TextView)findViewById(R.id.TextViewAdminLogin);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Email.getText().toString(), Password.getText().toString());
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
            }
        });

        AdminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, AdminLoginActivity.class));
            }
        });

    }

    private void validate(String userEmail, String userPassword) {
        if (userEmail.equals("nothing@gmail.com") && userPassword.equals("q12we34r")){
            Toast.makeText(this, "Logged in successfully!", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Please enter the correct details!", Toast.LENGTH_SHORT).show();
        }
    }

}
