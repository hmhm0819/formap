package com.example.formap;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MyFollowing extends AppCompatActivity {

    ImageView myFollowingBack;
    TextView myFollowerGo;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_following);

        myFollowingBack = (ImageView) findViewById(R.id.myFollowingBack);
        myFollowingBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyFollowing.this, MyPage.class);
                startActivity(intent);
                finish();
            }
        });

        myFollowerGo = (TextView) findViewById(R.id.myFollowerGo);
        myFollowerGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MyFollowing.this, MyFollower.class);
                startActivity(intent2);
                finish();
            }
        });

    }
}