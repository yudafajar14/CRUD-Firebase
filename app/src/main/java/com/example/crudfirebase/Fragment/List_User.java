package com.example.crudfirebase.Fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.crudfirebase.Adapter.RequestAdapterRecyclerView;
import com.example.crudfirebase.Model.Requestt;
import com.example.crudfirebase.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class List_User extends Fragment {

    private DatabaseReference database;
    private ArrayList<Requestt> daftarReg;
    private RequestAdapterRecyclerView requestAdapterRecyclerView;
    private RecyclerView rc_listView;
    private ProgressDialog loading;

    View view;

    public List_User() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_list_user, container, false);

        rc_listView = view.findViewById(R.id.rc_listUser);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext().getApplicationContext());
        rc_listView.setLayoutManager(layoutManager);
        rc_listView.setItemAnimator(new DefaultItemAnimator());

        database = FirebaseDatabase.getInstance().getReference();

        loading = ProgressDialog.show(getContext(),
                null,
                "Please Wait",
                true,
                false);

        database.child("Pengguna").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                daftarReg = new ArrayList<>();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()){

                    Requestt requestt = snapshot.getValue(Requestt.class);
                    requestt.setKey(snapshot.getKey());

                    daftarReg.add(requestt);
                }

                requestAdapterRecyclerView = new RequestAdapterRecyclerView(daftarReg);
                rc_listView.setAdapter(requestAdapterRecyclerView);
                loading.dismiss();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                System.out.println(databaseError.getDetails()+ " "+databaseError.getMessage());

                loading.dismiss();
            }
        });


        return view;

    }



}
