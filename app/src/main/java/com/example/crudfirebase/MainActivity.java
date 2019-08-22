package com.example.crudfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crudfirebase.Model.Requestt;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference database;
    private EditText etNama,etEmail,etNomor;
    private ProgressDialog loading;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance().getReference();

        etNama = findViewById(R.id.etNama);
        etEmail = findViewById(R.id.etEmail);
        etNomor = findViewById(R.id.etNomor);

        Button btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Snama = etNama.getText().toString();
                String Semail = etEmail.getText().toString();
                String Snomor = etNomor.getText().toString();

                if (etNama.equals("")){
                    etNama.setError("Silahkan Masukkan Nama Anda");
                    etNama.requestFocus();

                }
                else if (etEmail.equals("")){
                    etEmail.setError("Silahkan Masukkan Email Anda");
                    etEmail.requestFocus();
                }
                else if (etNomor.equals("")){
                    etNomor.setError("Silahkan Masukkan Nomor Anda");
                }else {
                    loading = ProgressDialog.show(MainActivity.this,
                            null,
                            "Please Wait",
                            true,
                            false);

                    submitUser(new Requestt(
                            Snama,
                            Semail.toLowerCase(),
                            Snomor.toLowerCase()));
                }
            }
        });


    }

    private void submitUser(Requestt Requestt) {
        database.child("Data Diri")
                .push()
                .setValue(Requestt)
                .addOnSuccessListener(this, new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {

                        loading.dismiss();
                        etNama.setText("");
                        etEmail.setText("");
                        etNomor.setText("");

                        Toast.makeText(MainActivity.this,
                                "Data Berhasil di Input",
                                Toast.LENGTH_SHORT).show();
                    }
                });

    }
}
