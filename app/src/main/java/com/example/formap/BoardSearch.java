package com.example.formap;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class BoardSearch extends AppCompatActivity {

    ImageView boardSearchBack;
    ImageView boardSearchCancel;
    ImageView boardSearchTry;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board_search);

        boardSearchBack = (ImageView)findViewById(R.id.boardSearchBack);
        boardSearchBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BoardSearch.this, BoardList.class);
                startActivity(intent);
            }
        });
    }
}