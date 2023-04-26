package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Vector;

public class Adapter extends RecyclerView.Adapter <Adapter.ViewHolder> {

    Context ctx;
    Vector<Item> itemVector;

    public Adapter(Context ctx) {
        this.ctx = ctx;
    }

    public void setItemVector(Vector<Item> itemVector) {
        this.itemVector = itemVector;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        //Set data disini
        holder.nameTxt.setText(itemVector.get(position).getName());
        //Jika tipe datanya integer maka kita perlu type cast int --> string
        // Kita bisa menggunakan String.valueOf() untuk melakukan type casting pada int
        holder.quantityTxt.setText(String.valueOf(itemVector.get(position).getQuantity()));

    }

    @Override
    public int getItemCount() {
        //Return sesuai dengan size dari vector Item
        return itemVector.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        //Declare/call id from card
        TextView nameTxt;
        TextView quantityTxt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //Get component here
            nameTxt = itemView.findViewById(R.id.nameTxt);
            quantityTxt = itemView.findViewById(R.id.quantityTxt);
        }
    }
}
