package com.example.formap;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

public class MyBellSet extends AppCompatActivity {

    ImageView myBellSetBack;
    Switch swAll;
    Switch swMap;
    Switch swPlace;
    Switch swNote;
    Switch swFollow;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_bellset);

        myBellSetBack = (ImageView) findViewById(R.id.myBellSetBack);
        myBellSetBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyBellSet.this, MyPage.class);
                startActivity(intent);
                finish();
            }
        });

        swAll = (Switch) findViewById(R.id.swAll);
        swAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton v, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(getApplicationContext(), "All_On", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "All_Off", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}