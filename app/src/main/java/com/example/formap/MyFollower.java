package com.example.formap;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MyFollower extends AppCompatActivity {

    ImageView myFollowerBack;
    TextView myFollowingGo;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_follower);

        myFollowerBack = (ImageView) findViewById(R.id.myFollowerBack);
        myFollowerBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyFollower.this, MyPage.class);
                startActivity(intent);
                finish();
            }
        });

        myFollowingGo = (TextView) findViewById(R.id.myFollowingGo);
        myFollowingGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MyFollower.this, MyFollowing.class);
                startActivity(intent2);
                finish();
            }
        });

    }
}