package com.example.videolist;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = findViewById(R.id.imageview);
        TextView date = findViewById(R.id.date);
        TextView title = findViewById(R.id.title);
        TextView description = findViewById(R.id.description);
        TextView username = findViewById(R.id.username);
        TextView email = findViewById(R.id.email);

        Bundle bundle = getIntent().getExtras();

        String mtitle = bundle.getString("title");
        String mavatarURL = bundle.getString("avatarURL");
        String mdescription = bundle.getString("description");
        String mdate = bundle.getString("date");
        String musername = bundle.getString("username");
        String memail = bundle.getString("email");

        Glide.with(this).load(mavatarURL).into(imageView);
        date.setText(mdate);
        title.setText(mtitle);
        description.setText(mdescription);
        username.setText(musername);
        email.setText(memail);
    }
}