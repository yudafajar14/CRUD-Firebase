package com.example.crudfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.crudfirebase.User.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        TextView tvprofile = findViewById(R.id.tvProfile);
        tvprofile.setText(firebaseUser.getEmail());
    }

    public void logout(View view) {
       FirebaseAuth.getInstance().signOut();
       Intent intent = new Intent(this, LoginActivity.class);
       intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
       intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
       startActivity(intent);
       finish();

    }
}
