package com.example.smartshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
public class RegistrationActivity extends AppCompatActivity {

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
        userEnroll = (EditText) findViewById(R.id.EditTextEnroll);
        userName = (EditText)findViewById(R.id.EditTextName);
        userEmail = (EditText)findViewById(R.id.EditTextEmail);
        userPhone = (EditText) findViewById(R.id.EditTextPhone);
        userPassword = (EditText)findViewById(R.id.EditTextPassword);
        Register = (Button)findViewById(R.id.btnRegister);
        userLogin = (TextView)findViewById(R.id.TextViewLogin);
    }

    private boolean validate() {
        Boolean result = false;

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
