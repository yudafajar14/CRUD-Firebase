package com.example.crudfirebase;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.crudfirebase.Model.Requestt;
import com.example.crudfirebase.Model.Upload;
import com.example.crudfirebase.User.RegisterActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class CostumLayoutAdd extends AppCompatActivity {

//    private static final int CHOOSE_IMAGE = 1;
    private Button btnCancel,btnUpload;
    private EditText etNamaProduk,etDeskripsiProduk,etStok;
    private ImageView preview;



    RadioGroup kategori;

    private ProgressDialog loading;

//    private Uri imgUrl;
//
//    private StorageReference storageReference;
    private DatabaseReference databaseReference;

    private StorageTask uploadTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.costum_layout_tambah_data);


        etNamaProduk = findViewById(R.id.et_NamaProduk);
        etDeskripsiProduk = findViewById(R.id.et_DeskripsiProduk);
        etStok = findViewById(R.id.et_StokBarang);
        kategori = findViewById(R.id.Rg_Kategori);
        int id = kategori.getCheckedRadioButtonId();
        RadioButton itemKategori = findViewById(id);



//        preview = findViewById(R.id.iv_gambar);
//        btnPiilihGambar = findViewById(R.id.btn_Pilihgambar);

//        storageReference = FirebaseStorage.getInstance().getReference("uploads");
        databaseReference = FirebaseDatabase.getInstance().getReference();



        btnUpload = findViewById(R.id.btn_Submit);



        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String SnamaProduk = etNamaProduk.getText().toString();
                String Sdeskripsi = etDeskripsiProduk.getText().toString();
                String Sstok = etStok.getText().toString();
                int id = kategori.getCheckedRadioButtonId();
                RadioButton itemKategori = findViewById(id);
                String pilih = itemKategori.getText().toString();



                if (uploadTask != null && uploadTask.isInProgress()) {
                    Toast.makeText(CostumLayoutAdd.this, "Upload in progress", Toast.LENGTH_SHORT).show();

                } else {
                    loading = ProgressDialog.show(CostumLayoutAdd.this,
                            null,
                            "Please Wait",
                            true,
                            false);

//                    uploadimage();
                    submitUser(new Upload(
                            SnamaProduk,
                            Sstok.toLowerCase(),
                            Sdeskripsi.toLowerCase(),
                            pilih.toLowerCase()));

                }
            }
        });


//        btnPiilihGambar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                showFileChoose();
//            }
//        });

    }

    private void submitUser(Upload Upload) {



        databaseReference
                .child("Barang")
                .push()
                .setValue(Upload)
                .addOnSuccessListener(this, new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {

                        loading.dismiss();


                        Toast.makeText(CostumLayoutAdd.this,
                                "Data Berhasil di Input",
                                Toast.LENGTH_SHORT).show();
                    }
                });

    }


//    private void uploadimage() {
//        if (imgUrl != null)
//        {
//            StorageReference filereference = storageReference.child(System.currentTimeMillis()+"."+getFileExstentsion(imgUrl));
//
//            uploadTask = filereference.putFile(imgUrl)
//                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                        @Override
//                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                            Handler handler = new Handler();
//                            handler.postDelayed(new Runnable() {
//                                @Override
//                                public void run() {
//                                    uploadProgres.dismiss();
//                                }
//                            },5000);
//
//                            Toast.makeText(CostumLayoutAdd.this, "Upload Success", Toast.LENGTH_SHORT).show();
//
//
//                        }
//                    }).addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            Toast.makeText(CostumLayoutAdd.this, e.getMessage() , Toast.LENGTH_SHORT).show();
//                        }
//                    }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
//                        @Override
//                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
//                            uploadProgres = ProgressDialog.show(CostumLayoutAdd.this,
//                                    null,
//                                    "Please Wait",
//                                    true,
//                                    false);
//                        }
//                    });
//        }else
//        {
//            Toast.makeText(this, "No File Selected", Toast.LENGTH_SHORT).show();
//
//        }
//    }

//    private String getFileExstentsion(Uri uri) {
//        ContentResolver contentResolver = getContentResolver();
//        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
//        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));
//    }
//
//    private void showFileChoose() {
//
//        Intent intent = new Intent();
//        intent.setType("image/*");
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(intent, CHOOSE_IMAGE);
//
//    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode==CHOOSE_IMAGE && resultCode == RESULT_OK && data !=null && data.getData()!=null){
//            imgUrl = data.getData();
//
//            Picasso.with(this).load(imgUrl).into(preview);
//        }
//
//    }
}
