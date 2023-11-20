package com.example.formap;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;

public class MyPage extends Fragment {

    private FirebaseAuth mFirebaseAuth;
    ImageView myModify;
    TextView myFollowing;
    TextView myFollower;
    TextView myAccount;
    TextView myBellSet;
    TextView myFqa;
    TextView myLogout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.my_page, container, false);

        myModify = (ImageView) rootView.findViewById(R.id.myModify);
        myModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MyEdit.class);
                startActivity(intent);
            }
        });

        myFollowing = (TextView) rootView.findViewById(R.id.myFollowing);
        myFollowing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getActivity(), MyFollowing.class);
                startActivity(intent2);
            }
        });

        myFollower = (TextView) rootView.findViewById(R.id.myFollower);
        myFollower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(getActivity(), MyFollower.class);
                startActivity(intent3);
            }
        });

        myAccount = (TextView) rootView.findViewById(R.id.myAccount);
        myAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(getActivity(), MyAccount.class);
                startActivity(intent4);
            }
        });

        myBellSet = (TextView) rootView.findViewById(R.id.myBellSet);
        myBellSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(getActivity(), MyBellSet.class);
                startActivity(intent5);
            }
        });

        mFirebaseAuth = FirebaseAuth.getInstance();

        myLogout = (TextView) rootView.findViewById(R.id.myLogout);
        myLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 로그아웃 하기
                mFirebaseAuth.signOut();
                Intent intent6 = new Intent(getActivity(), Login.class);
                startActivity(intent6);
            }
        });
        return rootView;
    }
}