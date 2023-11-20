package com.example.formap;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

public class BoardList extends Fragment {

    ImageView boardSearch;
    Button boardPlus;
    Button boardList;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.board_list, container, false);

        boardSearch = (ImageView) rootView.findViewById(R.id.boardSearch);
        boardSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), BoardSearch.class);
                startActivity(intent);
            }
        });

        boardPlus = (Button) rootView.findViewById(R.id.boardPlus);
        boardPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getActivity(), BoardWrite.class);
                startActivity(intent2);
            }
        });
        return rootView;
    }
}