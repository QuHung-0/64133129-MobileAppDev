package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity
{
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_activity);

        recyclerView = findViewById(R.id.recycler_view);

        // Use the utility to get images from the drawable "pic_" prefixed resources
        List<Integer> imageResources = ImageUtils.getDrawableImagesByPrefix(this, "pic_");

        ImageAdapter adapter = new ImageAdapter(this, imageResources);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setAdapter(adapter);
    }
}