package com.lenovo.way.designdemo;

import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

/**
 * @author way
 * @data 2017/6/21
 * @description .
 */

public class BottomSheetListActivity extends AppCompatActivity {

    private Button btn_list ;
    private MusicAdapter musicAdapter ;
    // private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bs_list);

        btn_list = (Button)findViewById(R.id.btn_list);

        musicAdapter = new MusicAdapter(this);

        LayoutInflater factorys = LayoutInflater.from(BottomSheetListActivity.this);
        final View textEntryView = factorys.inflate(R.layout.player_list, null);
        RecyclerView mRecyclerView = (RecyclerView) textEntryView.findViewById(R.id.id_recyclerview);
        // mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(musicAdapter);

        final BottomSheetDialog dialog = new BottomSheetDialog(BottomSheetListActivity.this);
        dialog.setContentView(textEntryView);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);

        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });

    }
}

