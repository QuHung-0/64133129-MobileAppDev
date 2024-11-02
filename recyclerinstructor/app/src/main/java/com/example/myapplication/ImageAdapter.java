package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context context;
    private final List<Integer> imageResources;

    // Constructor
    public ImageAdapter(Context context, List<Integer> imageResources) {
        this.context = context;
        this.imageResources = imageResources;
    }

    // Define view types
    private static final int VIEW_TYPE_LEFT = 0;
    private static final int VIEW_TYPE_RIGHT = 1;

    // Determine item view type based on position
    @Override
    public int getItemViewType(int position) {
        return (position % 2 == 0) ? VIEW_TYPE_LEFT : VIEW_TYPE_RIGHT;
    }

    // Create ViewHolder based on view type
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == VIEW_TYPE_LEFT) {
            view = LayoutInflater.from(context).inflate(R.layout.tem_image_left, parent, false);
            return new LeftViewHolder(view);
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.item_image_right, parent, false);
            return new RightViewHolder(view);
        }
    }

    // Bind view holders based on their type
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int imageResource = imageResources.get(position);
        if (holder instanceof LeftViewHolder) {
            ((LeftViewHolder) holder).imageView.setImageResource(imageResource);
        } else if (holder instanceof RightViewHolder) {
            ((RightViewHolder) holder).imageView.setImageResource(imageResource);
        }
    }

    @Override
    public int getItemCount() {
        return imageResources.size();
    }

    // Left-aligned ViewHolder
    static class LeftViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        LeftViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.image_view);
        }
    }

    // Right-aligned ViewHolder
    static class RightViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        RightViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.image_view);
        }
    }
}
