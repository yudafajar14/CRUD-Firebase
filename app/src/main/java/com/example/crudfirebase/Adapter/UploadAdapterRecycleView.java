package com.example.crudfirebase.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crudfirebase.CostumLayoutAdd;
import com.example.crudfirebase.Model.Upload;
import com.example.crudfirebase.R;
import com.example.crudfirebase.TampilanMenu;

import java.util.List;

public class UploadAdapterRecycleView extends RecyclerView.Adapter<UploadAdapterRecycleView.MyViewHolder> {


    private List<Upload> moviesList;
    private Activity mActivity;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_barang,parent,false);

//        ImageView img = itemView.findViewById(R.id.iconid);

//        img.setImageResource(R.drawable.ic_person_outline_black_24dp);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Upload movie = moviesList.get(position);

        holder.tvNamaProduk.setText(movie.getNamaProduk());
        holder.tvDeskripsi.setText(movie.getDeskripsi());
        holder.tvJml.setText(movie.getStok());


    }

    @Override
    public int getItemCount() {
        return moviesList.size();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvNamaProduk,tvDeskripsi,tvJml;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNamaProduk = itemView.findViewById(R.id.tvNamaProduk);
            tvDeskripsi = itemView.findViewById(R.id.tvDeskripsi);
            tvJml = itemView.findViewById(R.id.tvJmlStok);
        }
    }

    public UploadAdapterRecycleView(List<Upload> moviesList){


        this.moviesList = moviesList;
    }
}
