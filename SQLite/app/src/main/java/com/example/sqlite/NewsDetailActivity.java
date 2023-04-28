package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsDetailActivity extends AppCompatActivity {

    String tittle, description;
    int image;

    TextView tittleTxt, descriptionTxt;
    ImageView image_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        image_view = findViewById(R.id.image_view);
        tittleTxt = findViewById(R.id.tittleTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);

        setAndGetIntentData();

    }

    void setAndGetIntentData(){
        if(getIntent().hasExtra("tittle") && getIntent().hasExtra("description")){
            tittle = getIntent().getStringExtra("tittle");
            description = getIntent().getStringExtra("description");
            image = getIntent().getIntExtra("image", 1);

            image_view.setImageResource(image);
            tittleTxt.setText(tittle);
            descriptionTxt.setText(description);
        }
    }
}