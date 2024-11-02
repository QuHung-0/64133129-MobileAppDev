package ntu.nlqh.midtermtestrun;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import ntu.nlqh.midtermtestrun.recycleview.ImageAdapter;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_activity);

        recyclerView = findViewById(R.id.recycler_view);

        // Dynamically load images from a folder (e.g., "MyImages" folder in external storage)
        List<Integer> imageResources = loadImagesFromFolder();

        // Set up the adapter and RecyclerView
        adapter = new ImageAdapter(this, imageResources);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2)); // 3 columns
        recyclerView.setAdapter(adapter);
    }

    private List<Integer> loadImagesFromFolder() {
        List<Integer> images = new ArrayList<>();

        // Load images from drawable manually for demonstration.
        images.add(R.drawable.image1);
        images.add(R.drawable.image2);
        images.add(R.drawable.image3);
        images.add(R.drawable.image4);
        images.add(R.drawable.image5);
        images.add(R.drawable.image6);
        images.add(R.drawable.image7);
        images.add(R.drawable.image8);
        images.add(R.drawable.image9);
        images.add(R.drawable.image10);
        images.add(R.drawable.image11);
        images.add(R.drawable.image12);

        return images;
    }

    public void Return(View v) {
        Intent iMainActivity = new Intent(RecyclerViewActivity.this, MainActivity.class);
        startActivity(iMainActivity);
    }
}
