package com.example.formap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class BoardWrite extends AppCompatActivity {

    ImageView boardWriteBack;
    ImageView boardWriteFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board_write);

        boardWriteBack = (ImageView)findViewById(R.id.boardWriteBack);
        boardWriteBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BoardWrite.this, BoardList.class);
                startActivity(intent);
                finish();
            }
        });

        boardWriteFinish = (ImageView)findViewById(R.id.boardWriteFinish);
        boardWriteFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(BoardWrite.this, BoardView.class);
                startActivity(intent2);
                finish();
            }
        });
    }
}