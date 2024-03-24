package com.example.myapplication;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import androidx.recyclerview.widget.GridLayoutManager;

import java.util.List;
public class Insta extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Integer> imageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insta);

        // Initialize image list with dummy data (replace with your actual data)
        imageList = new ArrayList<>();
        imageList.add(R.drawable.bg);
        imageList.add(R.drawable.bg1);
        imageList.add(R.drawable.bg2);
        imageList.add(R.drawable.bg);
        imageList.add(R.drawable.bg1);
        imageList.add(R.drawable.nisa);
        // Add more images as needed

        recyclerView = findViewById(R.id.recyclerViewImages);

        // Use GridLayoutManager with 3 columns
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        recyclerView.setAdapter(new ImageAdapter(imageList));
    }


    private static class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

        private List<Integer> imageList;

        ImageAdapter(List<Integer> imageList) {
            this.imageList = imageList;
        }

        @NonNull
        @Override
        public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
            return new ImageViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
            holder.imageView.setImageResource(imageList.get(position));
        }

        @Override
        public int getItemCount() {
            return imageList.size();
        }

        static class ImageViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;

            ImageViewHolder(View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.imageView);
            }
        }
    }

}
