package com.codecoresolutions.androparking;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class SignUp extends AppCompatActivity {

    private EditText Name,Email,Contact,Password;
    private Button mSignUp;
    private TextView login;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        firebaseAuth=FirebaseAuth.getInstance();

        setupdetails();
        mSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    //uploading to db
                    String email=Email.getText().toString().trim();
                    String pass=Password.getText().toString().trim();
                    firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isComplete()){
                                Toast.makeText(SignUp.this,"Registration Successfull",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(SignUp.this,Login.class));
                            }
                            else {
                                Toast.makeText(SignUp.this,"Registration Failed",Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this,Login.class));
            }
        });
    }

    public void onClickSignUp(View view) {
        Intent i=new Intent(SignUp.this,Login.class);
        startActivity(i);
    }

    private void setupdetails(){
        Name=(EditText)findViewById(R.id.etName);
        Password=(EditText)findViewById(R.id.etPassword);
        Email=(EditText)findViewById(R.id.etEmail);
        Contact=(EditText)findViewById(R.id.etContact);
        mSignUp=(Button)findViewById(R.id.buttonSignUp);
        login=(TextView)findViewById(R.id.tvLogin);
    }

    private Boolean validate(){
        Boolean result=false;
        String name=Name.getText().toString();
        String password=Password.getText().toString();
        String email=Email.getText().toString();
        String contact=Contact.getText().toString();

        if(name.isEmpty() || password.isEmpty() || contact.isEmpty() || email.isEmpty()){
            Toast.makeText(this,"Please enter all the details",Toast.LENGTH_SHORT).show();
        }
        else{
            result=true;
        }
        return result;
    }

}
