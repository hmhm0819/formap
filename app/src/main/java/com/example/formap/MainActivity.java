package com.example.formap;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private MainPage mainPage = new MainPage();
    private Map map = new Map();
    private BoardList boardList = new BoardList();
    private MyPage myPage = new MyPage();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.menu_bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(new ItemSelectedListener());
    }

    class ItemSelectedListener implements NavigationBarView.OnItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

            if(menuItem.getItemId() == R.id.menu_main) {
                getSupportFragmentManager().beginTransaction().replace(R.id.menu_frame_layout, mainPage).commit();
            }
            else if(menuItem.getItemId() == R.id.menu_map){
                getSupportFragmentManager().beginTransaction().replace(R.id.menu_frame_layout, map).commit();
            }
            else if(menuItem.getItemId() == R.id.menu_board) {
                getSupportFragmentManager().beginTransaction().replace(R.id.menu_frame_layout, boardList).commit();
            }
            else if(menuItem.getItemId() == R.id.menu_my) {
                getSupportFragmentManager().beginTransaction().replace(R.id.menu_frame_layout, myPage).commit();
            }
            else {

            }
            return true;
        }
    }
}