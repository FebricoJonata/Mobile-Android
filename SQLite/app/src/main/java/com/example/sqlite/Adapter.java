package com.example.sqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Vector;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    //Declare Context & Vector Here!
    Context ctx;
    List<News> newsList;


    public Adapter(Context ctx, List<News> newsList) {
        this.ctx = ctx;
        this.newsList = newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.card_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        holder.image.setImageResource(newsList.get(position).getImage());
        holder.tittleTxt.setText(newsList.get(position).getTittle());
        holder.descriptionTxt.setText(newsList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tittleTxt, descriptionTxt;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            image = itemView.findViewById(R.id.image_view);
            tittleTxt = itemView.findViewById(R.id.tittleTxt);
            descriptionTxt = itemView.findViewById(R.id.descriptionTxt);
        }
    }
}
