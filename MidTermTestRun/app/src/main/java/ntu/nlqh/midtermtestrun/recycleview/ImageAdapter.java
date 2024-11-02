package ntu.nlqh.midtermtestrun.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ntu.nlqh.midtermtestrun.R;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder>
{
    private final List<Integer> imageResources;
    private final Context context;

    public ImageAdapter(Context context, List<Integer> imageResources)
    {
        this.context = context;
        this.imageResources = imageResources;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.recycleview_item_image, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position)
    {
        holder.imageView.setImageResource(imageResources.get(position));
    }

    @Override
    public int getItemCount()
    {
        return imageResources.size();

    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;

        public ImageViewHolder(@NonNull View itemView)
        {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
        }
    }
}
