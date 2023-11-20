package com.example.formap;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.os.Bundle;

public class TasteAnalysis extends AppCompatActivity {
    ImageButton tasteImg1;
    ImageButton tasteImg2;
    ImageButton tasteImg3;
    ImageButton tasteImg4;
    ImageButton tasteImg5;
    ImageButton tasteImg6;
    ImageButton tasteImg7;
    ImageButton tasteImg8;
    ImageButton tasteImg9;
    ImageButton tasteImg10;
    ImageButton tasteImg11;
    ImageButton tasteImg12;
    Button tasteCheck;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.taste_analysis);

        tasteImg1 = (ImageButton)findViewById(R.id.tasteImg1);
        tasteImg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tasteImg1.setEnabled(false);
            }
        });
        tasteImg2 = (ImageButton)findViewById(R.id.tasteImg2);
        tasteImg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { tasteImg2.setEnabled(false); }
        });
        tasteImg3 = (ImageButton)findViewById(R.id.tasteImg3);
        tasteImg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tasteImg3.setEnabled(false);
            }
        });
        tasteImg4 = (ImageButton)findViewById(R.id.tasteImg4);
        tasteImg4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tasteImg4.setEnabled(false);
            }
        });
        tasteImg5 = (ImageButton)findViewById(R.id.tasteImg5);
        tasteImg5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tasteImg5.setEnabled(false);
            }
        });
        tasteImg6 = (ImageButton)findViewById(R.id.tasteImg6);
        tasteImg6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tasteImg6.setEnabled(false);
            }
        });
        tasteImg7 = (ImageButton)findViewById(R.id.tasteImg7);
        tasteImg7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tasteImg7.setEnabled(false);
            }
        });
        tasteImg8 = (ImageButton)findViewById(R.id.tasteImg8);
        tasteImg8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tasteImg8.setEnabled(false);
            }
        });
        tasteImg9 = (ImageButton)findViewById(R.id.tasteImg9);
        tasteImg9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tasteImg9.setEnabled(false);
            }
        });
        tasteImg10 = (ImageButton)findViewById(R.id.tasteImg10);
        tasteImg10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tasteImg10.setEnabled(false);
            }
        });
        tasteImg11 = (ImageButton)findViewById(R.id.tasteImg11);
        tasteImg11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tasteImg11.setEnabled(false);
            }
        });
        tasteImg12 = (ImageButton)findViewById(R.id.tasteImg12);
        tasteImg12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tasteImg12.setEnabled(false);
            }
        });
        tasteCheck = (Button)findViewById(R.id.tasteCheck);
        tasteCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TasteAnalysis.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}