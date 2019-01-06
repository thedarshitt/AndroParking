package com.codecoresolutions.androparking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    private EditText Email,Password;
    private TextView userSignUp;
    private Button login=(Button) findViewById(R.id.buttonLogin);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupdetails();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void setupdetails(){
        Email=(EditText) findViewById(R.id.etEmail);
        Password=(EditText)findViewById(R.id.etPass);
        userSignUp=(TextView)findViewById(R.id.textViewSignUp);

    }

    public void onClickLogin(View view) {
        Intent i=new Intent(Login.this,Home.class);
        startActivity(i);
    }

    public void onClickTvSignUp(View view) {
        Intent i=new Intent(Login.this,SignUp.class);
        startActivity(i);
    }
}
