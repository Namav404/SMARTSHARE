package com.example.smartshare;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLoginActivity extends AppCompatActivity {

    private EditText Username, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        Username = findViewById(R.id.EditTextName);
        Password = findViewById(R.id.EditTextPassword);
        Button login = findViewById(R.id.btnLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Username.getText().toString(), Password.getText().toString());
            }
        });

    }

    private void validate(String Username, String Password) {
        if (Username.isEmpty() && Password.isEmpty()){
            Toast.makeText(this, "Please enter the correct details!", Toast.LENGTH_SHORT).show();
        }
    }

}
