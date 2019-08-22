package com.example.crudfirebase.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crudfirebase.Model.Requestt;
import com.example.crudfirebase.R;

import java.util.List;

public class RequestAdapterRecyclerView extends RecyclerView.Adapter<RequestAdapterRecyclerView.MyViewHolder> {


    private List<Requestt> moviesList;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false);

//        ImageView img = itemView.findViewById(R.id.iconid);

//        img.setImageResource(R.drawable.ic_person_outline_black_24dp);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final  Requestt movie = moviesList.get(position);

        holder.tvTittle.setText(movie.getUsername());
        holder.tvNumber.setText(movie.getNomor());


    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView tvTittle,tvNumber;

        public MyViewHolder(View view){
            super(view);
            tvTittle = view.findViewById(R.id.tv_namaUser);
            tvNumber = view.findViewById(R.id.tv_nomorTelepon);
        }
    }

    public RequestAdapterRecyclerView(List<Requestt> moviesList){

        
        this.moviesList = moviesList;
    }


}
