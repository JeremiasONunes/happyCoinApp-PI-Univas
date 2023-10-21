package com.happy.happycoin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.happy.happycoin.helper.ConfigFirebase;

public class MainActivity extends AppCompatActivity {
    private Button loginButton;
    private EditText emailField, passwordField;

    private FirebaseAuth auth;

    private void initializeComponents() {
        emailField = findViewById(R.id.campoEmail);
        passwordField = findViewById(R.id.campoPassword);
        loginButton = findViewById(R.id.buttonAcesso);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeComponents();
        auth = ConfigFirebase.getFirebaseAuth();

        loginButton.setOnClickListener(v -> {
            String email = emailField.getText().toString();
            String password = passwordField.getText().toString();

            if (!email.isEmpty() && !password.isEmpty()) {


                auth.signInWithEmailAndPassword(
                        email, password
                ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if( task.isSuccessful() ){

                            Toast.makeText(MainActivity.this,
                                    "Logado",
                                    Toast.LENGTH_LONG).show();

                            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                            startActivity(intent);
                            finish();

                        }else {
                            Toast.makeText(MainActivity.this,
                                    "Erro ao fazer login : " + task.getException() ,
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }else {
                Toast.makeText(MainActivity.this,
                        "Erro, verifique se a senha e o e-mail  estão preenchidos corretamente!",
                        Toast.LENGTH_LONG).show();
            }
        });

    }
}