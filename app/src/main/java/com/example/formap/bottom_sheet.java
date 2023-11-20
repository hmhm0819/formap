package com.example.formap;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class bottom_sheet extends AppCompatActivity {

    private Button btnPopupClose;

    private Button btnPopupLoad;
    private PopupWindow popupWindow;
    private EditText txtData;

    private Button btnData;

    private ListView listPopup;
    List list = new ArrayList<>();

    ArrayAdapter adapter;

    private int mWidthPixel = 0;
    private int mHeightPixel = 0;

    public bottom_sheet(Button btnPopupLoad) {
        this.btnPopupLoad = btnPopupLoad;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_sheet);

        WindowManager wm = getWindowManager();
        Display dp = wm.getDefaultDisplay();
        DisplayMetrics dm = new DisplayMetrics();
        dp.getMetrics(dm);

        mWidthPixel = dm.widthPixels;
        mHeightPixel = dm.heightPixels;

        listPopup = (ListView) findViewById(R.id.listPopup);

        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, list);

        listPopup.setAdapter(adapter);

        Button btnPopupLoad = (Button) findViewById(R.id.btnPopupLoad);
        btnPopupLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initiatePopupWindow();
            }
        });

    }

    @SuppressLint("MissingInflatedId")
    private void initiatePopupWindow() {
        try{
            LayoutInflater inflater = (LayoutInflater) bottom_sheet.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View layout = inflater.inflate(R.layout.layout_popup, (ViewGroup) findViewById(R.id.popupLayout));

            popupWindow = new PopupWindow(layout, mWidthPixel-100, mHeightPixel-500, true);

            popupWindow.showAtLocation(layout, Gravity.CENTER, 0,0);

            btnPopupClose = (Button) layout.findViewById(R.id.btnPopupClose);
            btnPopupClose.setOnClickListener(disListener);

            txtData = (EditText) layout.findViewById(R.id.txtData);
            btnData = (Button) layout.findViewById(R.id.btnData);

            btnData.setOnClickListener(addListener);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    private View.OnClickListener disListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            popupWindow.dismiss();
        }
    };

    private View.OnClickListener addListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            list.add(txtData.getText().toString());
            adapter.notifyDataSetChanged();
        }
    };
}