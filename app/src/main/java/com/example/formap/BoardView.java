package com.example.formap;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class BoardView extends AppCompatActivity {

    ImageView boardViewBack;
    ImageView boardViewLike;
    ImageView boardViewInput;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board_view);

        boardViewBack = (ImageView)findViewById(R.id.boardViewBack);
        boardViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BoardView.this, BoardList.class);
                startActivity(intent);
                finish();
            }
        });
    }
}