package com.example.crudfirebase.User;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.crudfirebase.R;
import com.example.crudfirebase.TampilanMenu;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText etUsername, etPassword;
    private ProgressDialog loading;
//    private FirebaseAuth.AuthStateListener checkLoggedIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);


        Button btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRegister = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intentRegister);
                finish();
            }
        });

        FloatingActionButton fabLogSubmit = findViewById(R.id.btnLogSubmit);
        fabLogSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                if (username.equals("")) {
                    Toast.makeText(LoginActivity.this, "Silahkan Masukkan Username Anda", Toast.LENGTH_SHORT).show();
                    etUsername.requestFocus();
                } else if (password.equals("")) {
                    Toast.makeText(LoginActivity.this, "Silahkan Masukkan Password Anda", Toast.LENGTH_SHORT).show();
                    etPassword.requestFocus();
                } else {

                    loading = ProgressDialog.show(LoginActivity.this,
                            null,
                            "Please Wait",
                            true,
                            false);

                    mAuth.signInWithEmailAndPassword(username, password)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        Intent goHome = new Intent(LoginActivity.this, TampilanMenu.class);
                                        startActivity(goHome);
                                        finish();
                                    } else {
                                        loading.dismiss();
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(LoginActivity.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();
                                    }

                                    // ...
                                }
                            });

                }
            }
        });

    }


}
