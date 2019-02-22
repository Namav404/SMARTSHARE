package com.example.smartshare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class RegistrationActivity extends AppCompatActivity {

    String en_no, user_name, user_email, user_pass, user_pno;
    private EditText userName, userPassword, userEmail, userEnroll, userPhone;
    private Button Register;
    private TextView userLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        setupUIViews();
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    en_no = userEnroll.getText().toString();
                    user_name = userName.getText().toString();
                    user_email = userEmail.getText().toString();
                    user_pno = userPhone.getText().toString();
                    user_pass = userPassword.getText().toString();
                    String method = "register";
                    BackgroundTask backgroundTask = new BackgroundTask(RegistrationActivity.this);
                    backgroundTask.execute(method,en_no,user_name,user_email,user_pno,user_pass);
                    finish();
                }
            }
        });

        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
            }
        });

    }

    private void setupUIViews(){
        userEnroll = findViewById(R.id.EditTextEnroll);
        userName = findViewById(R.id.EditTextName);
        userEmail = findViewById(R.id.EditTextEmail);
        userPhone = findViewById(R.id.EditTextPhone);
        userPassword = findViewById(R.id.EditTextPassword);
        Register = findViewById(R.id.btnRegister);
        userLogin = findViewById(R.id.TextViewLogin);
    }

    private boolean validate() {
        boolean result = false;

        String enroll = userEnroll.getText().toString();
        String name = userName.getText().toString();
        String email = userEmail.getText().toString();
        String phone = userPhone.getText().toString();
        String password = userPassword.getText().toString();

        if (name.isEmpty() && enroll.isEmpty() && email.isEmpty() && phone.isEmpty() && password.isEmpty()) {
            Toast.makeText(this, "Please fill in all the details!", Toast.LENGTH_SHORT).show();
        } else {
            result = true;
        } return result;
    }

}
