package com.example.videolist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.MovieHolder> {

    private final Context context;
    private final List<Video> videoList;

    public VideoAdapter(Context context, List<Video> videos) {
        this.context = context;
        videoList = videos;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {      // SET DATA IN ITEM VIEW

        Video video = videoList.get(position);
        holder.title.setText(video.getTitle());
        holder.description.setText(video.getDescription());
        holder.date.setText(video.getCreated());
        Glide.with(context).load(video.getAvatarURL()).into(holder.imageView);

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                                           // SET DATA IN DETAILED VIEW

                Intent intent = new Intent(context, DetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("title", video.getTitle());
                bundle.putString("description", video.getDescription());
                bundle.putString("avatarURL", video.getAvatarURL());
                bundle.putString("date", video.getCreated());
                bundle.putString("username", video.getUserName());
                bundle.putString("email", video.getEmail());

                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }

    public class MovieHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView title, description, date;
        ConstraintLayout constraintLayout;

        public MovieHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageview);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            date = itemView.findViewById(R.id.date);
            constraintLayout = itemView.findViewById(R.id.main_layout);
        }
    }
}
