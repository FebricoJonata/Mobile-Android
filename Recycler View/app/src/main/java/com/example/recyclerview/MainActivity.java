package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView item_RV = findViewById(R.id.item_rv);

        //Add item dengan menggunakan vector
        Vector<Item> items = new Vector<>();
        items.add(new Item(R.drawable.person, "Nama Item", 9));
        items.add(new Item(R.drawable.person, "Nama Item", 9));
        items.add(new Item(R.drawable.person, "Nama Item", 9));
        items.add(new Item(R.drawable.person, "Nama Item", 9));
        items.add(new Item(R.drawable.person, "Nama Item", 10));
        items.add(new Item(R.drawable.person, "Nama Item", 9));
        items.add(new Item(R.drawable.person, "Nama Item", 9));
        items.add(new Item(R.drawable.person, "Nama Item", 9));
        items.add(new Item(R.drawable.person, "Nama Item", 9));
        items.add(new Item(R.drawable.person, "Nama Item", 9));
        items.add(new Item(R.drawable.person, "Nama Item", 7));


        //panggil Adapter & context cukup di isi dengan this
        Adapter adapter = new Adapter(this);
        //tambahkan data dari vector dengan menggunakan method adapter settter Vector item
        adapter.setItemVector(items);

        item_RV.setAdapter(adapter);
        item_RV.setLayoutManager(new LinearLayoutManager(this));
    }
}