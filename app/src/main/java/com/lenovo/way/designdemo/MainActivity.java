package com.lenovo.way.designdemo;

import android.Manifest;
import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    // SnackBar
    private FloatingActionButton btnFab ;
    private CoordinatorLayout layoutRoot ;

    // BottomSheet
    private Button btnBottomSheet , btnBottomSheetList , btnNavigatioMenu ;

    // TextInputLayout
    private Button btnTextInputLayout ;

    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, 100);

        initViews();

        btnFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(layoutRoot , "已收藏!" ,Snackbar.LENGTH_SHORT)
                        .setAction("去查看", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent();
                                intent.setClass(MainActivity.this , SecondActivity.class );
                                startActivity(intent);
                            }
                        })
                        .show();
            }
        });

        btnBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , BottomSheetActivity.class);
                startActivity(intent);
            }
        });

        btnBottomSheetList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , BottomSheetListActivity.class);
                startActivity(intent);
            }
        });

        btnTextInputLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , TextInputActivity.class);
                startActivity(intent);
            }
        });

        btnNavigatioMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , NavigationMenuActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initViews() {
        layoutRoot = (CoordinatorLayout) findViewById(R.id.layoutRoot);
        btnFab = (FloatingActionButton) findViewById(R.id.btnFloatingAction);
        btnBottomSheet = (Button) findViewById(R.id.btn_bottomsheet);
        btnBottomSheetList = (Button) findViewById(R.id.btn_bottomsheet_list);
        btnTextInputLayout = (Button)findViewById(R.id.btn_text_input_layout);
        btnNavigatioMenu = (Button)findViewById(R.id.btn_navigation_menu);
    }
}
