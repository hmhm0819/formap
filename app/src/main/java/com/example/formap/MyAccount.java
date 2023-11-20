package com.example.formap;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class MyAccount extends AppCompatActivity {
    private FirebaseAuth mFirebaseAuth;

    private ImageView myAccountBack;
    private TextView myAccountOut;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_account);

        myAccountBack = (ImageView)findViewById(R.id.myAccountBack);
        myAccountBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyAccount.this, MyPage.class);
                startActivity(intent);
                finish();
            }
        });

        mFirebaseAuth = FirebaseAuth.getInstance();

        myAccountOut = (TextView) findViewById(R.id.myAccountOut);
        myAccountOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 회원 탈퇴 하기
                mFirebaseAuth.getCurrentUser().delete();
                Intent intent2 = new Intent(MyAccount.this, OnBoarding.class);
                startActivity(intent2);
            }
        });
    }
}