package com.example.smartshare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLoginActivity extends AppCompatActivity {

    private EditText Username, Password;
    private Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        Username = (EditText)findViewById(R.id.EditTextEmail);
        Password = (EditText)findViewById(R.id.EditTextPassword);
        Login = (Button)findViewById(R.id.btnLogin);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Username.getText().toString(), Password.getText().toString());
            }
        });

    }

    private void validate(String Username, String Password) {
        if (Username.equals("admin") && Password.equals("q12we34r")){
            Toast.makeText(this, "Logged in successfully!", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Please enter the correct details!", Toast.LENGTH_SHORT).show();
        }
    }

}
