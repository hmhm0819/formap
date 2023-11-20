package com.example.formap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MyEdit extends AppCompatActivity {

    ImageView myEditBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_edit);

        myEditBack = (ImageView) findViewById(R.id.myEditCancel);
        myEditBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyEdit.this, MyPage.class);
                startActivity(intent);
                finish();
            }
        });
    }
}