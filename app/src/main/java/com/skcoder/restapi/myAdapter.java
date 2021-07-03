package com.skcoder.restapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class myAdapter extends RecyclerView.Adapter<myAdapter.myViewHolder>
{

    model data[];

    public myAdapter(model[] data) {
        this.data = data;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow, parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.t1.setText(data[position].getId());
        holder.t2.setText(data[position].getFirst_name()+" "+data[position].getLast_name());
        holder.t3.setText(data[position].getEmail());
        Glide.with(holder.t1.getContext()).load(data[position].getAvatar()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    class myViewHolder extends RecyclerView.ViewHolder{

    ImageView img;
    TextView t1,t2,t3;

    public myViewHolder(@NonNull View itemView) {
        super(itemView);

        img = itemView.findViewById(R.id.img);
        t1 = itemView.findViewById(R.id.t1);
        t2 = itemView.findViewById(R.id.t2);
        t3 = itemView.findViewById(R.id.t3);
    }
}
}
