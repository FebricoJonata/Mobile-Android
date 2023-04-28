package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DB = new DatabaseHelper(this);

        RecyclerView news_RV = findViewById(R.id.news_RV);


        ArrayList<News> newsList = new ArrayList<>();

        DB.addData(new News(R.drawable.slc, "SLC BINUS Y Update", "JAYA JAYA JAYAKALI"));
        DB.addData(new News(R.drawable.slc, "SLC BINUS N uppdate 99", "JAYA JAYA JAYA YAKALI"));


        newsList.addAll(DB.allData());

        //panggil Adapter & context cukup di isi dengan this
        Adapter adapter = new Adapter(this, newsList);
        //tambahkan data dari vector dengan menggunakan method adapter settter Vector item
        adapter.setNewsList(newsList);

        news_RV.setAdapter(adapter);
        news_RV.setLayoutManager(new LinearLayoutManager(this));

    }
}