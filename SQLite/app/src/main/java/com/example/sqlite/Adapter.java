package com.example.sqlite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Vector;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    //Declare Context & Vector Here!
    Context ctx;
    List<News> newsList;
    Activity activity;


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

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ctx, NewsDetailActivity.class);
                intent.putExtra("image", newsList.get(position).getImage());
                intent.putExtra("tittle", newsList.get(position).getTittle());
                intent.putExtra("description", newsList.get(position).getDescription());
                ctx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tittleTxt, descriptionTxt;
        ImageView image;

        LinearLayout mainLayout;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            image = itemView.findViewById(R.id.image_view);
            tittleTxt = itemView.findViewById(R.id.tittleTxt);
            descriptionTxt = itemView.findViewById(R.id.descriptionTxt);
        }
    }
}
