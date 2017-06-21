package com.lenovo.way.designdemo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.cocosw.bottomsheet.BottomSheet;

/**
 * @author way
 * @data 2017/6/21
 * @description .
 */

public class BottomSheetActivity extends AppCompatActivity {

    private Button btn_list ,btn_grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet);

        btn_list = (Button)findViewById(R.id.btn_bs_list);
        btn_grid = (Button)findViewById(R.id.btn_bs_grid);

        // BottomSheet的一种写法

        // 列表样式

        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new BottomSheet.Builder(BottomSheetActivity.this)
                        .title("Bottom Sheet")
                        .sheet(R.menu.menu)
                        .listener(new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which) {
                                    case R.id.download:
                                        Toast.makeText(BottomSheetActivity.this,"download",Toast.LENGTH_SHORT).show();
                                        break;
                                    case R.id.like:
                                        Toast.makeText(BottomSheetActivity.this,"like",Toast.LENGTH_SHORT).show();
                                        break;
                                    case R.id.answer:
                                        Toast.makeText(BottomSheetActivity.this,"answer",Toast.LENGTH_SHORT).show();
                                        break;
                                    case R.id.share:
                                        Toast.makeText(BottomSheetActivity.this,"share",Toast.LENGTH_SHORT).show();
                                        break;
                                    case R.id.help:
                                        Toast.makeText(BottomSheetActivity.this,"help",Toast.LENGTH_SHORT).show();
                                        break;
                                }
                            }
                        }).build().show();
            }
        });

        // 表格样式 不过是多了一句 .grid()

        btn_grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new BottomSheet.Builder(BottomSheetActivity.this)
                        .title("Bottom Sheet")
                        .grid()
                        .sheet(R.menu.menu)
                        .listener(new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which) {
                                    case R.id.download:
                                        Toast.makeText(BottomSheetActivity.this,"download",Toast.LENGTH_SHORT).show();
                                        break;
                                    case R.id.like:
                                        Toast.makeText(BottomSheetActivity.this,"like",Toast.LENGTH_SHORT).show();
                                        break;
                                    case R.id.answer:
                                        Toast.makeText(BottomSheetActivity.this,"answer",Toast.LENGTH_SHORT).show();
                                        break;
                                    case R.id.share:
                                        Toast.makeText(BottomSheetActivity.this,"share",Toast.LENGTH_SHORT).show();
                                        break;
                                    case R.id.help:
                                        Toast.makeText(BottomSheetActivity.this,"help",Toast.LENGTH_SHORT).show();
                                        break;
                                }
                            }
                        }).build().show();
            }
        });
    }
}
