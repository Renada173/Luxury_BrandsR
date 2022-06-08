package com.example.luxury_brands;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public class SignUpActivity extends AppCompatActivity {

    private EditText etEmail,etPassword;
    private Utilities utils;
    private FirebaseServices fbs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        connectComponents();
    }

    private void connectComponents() {

        etEmail = findViewById(R.id.etEmailSignup);
        etPassword = findViewById(R.id.etPasswordSignup);
        utils = Utilities.getInstance();
        fbs = FirebaseServices.getInstance();
    }

    public void signup(View view) {

        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

            if (email.trim().isEmpty() || password.trim().isEmpty()) {
                Toast.makeText(this, "Some fields are empty!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!utils.validateEmail(email) || !utils.validatePassword(password)) {
                Toast.makeText(this, "Incorrect email or password!", Toast.LENGTH_SHORT).show();
                return;
            }

            fbs.getAuth().createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(SignUpActivity.this, "User successfully registered!", Toast.LENGTH_SHORT).show();

                            } else {
                                // TODO: what to do if fails
                            }
                        }
                    });
        }

    public void gotoMainPage(View view) {
            Intent i = new Intent(this, MainPageActivity.class);
            startActivity(i);

    }
}