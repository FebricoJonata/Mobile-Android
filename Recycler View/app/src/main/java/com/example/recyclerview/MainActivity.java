package com.example.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

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


        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setSelectedItemId(R.id.article);
        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.article:
                        return true;

                    case R.id.ticket:
                        startActivity(new Intent(getApplicationContext(), TicketActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }

                return false;
            }
        });

    }
}