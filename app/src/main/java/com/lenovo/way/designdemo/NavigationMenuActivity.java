package com.lenovo.way.designdemo;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * @author way
 * @data 2017/6/21
 * @description .
 */

public class NavigationMenuActivity extends AppCompatActivity {

    DrawerLayout drawerlayout ;
    NavigationView navigationView ;
    private Button btnNvLeft ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_menu);

        navigationView = (NavigationView)findViewById(R.id.navigation_view);
        btnNvLeft = (Button)findViewById(R.id.btn_nv_left);
        drawerlayout = (DrawerLayout)findViewById(R.id.drawerlayout);

        // 让图标就是显示其图片本身的颜色，不然都是灰色的
        navigationView.setItemIconTintList(null);

        // 按钮显示侧滑菜单
        btnNvLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerlayout.openDrawer(Gravity.LEFT);
            }
        });

        // 头部点击事件
        // 先获取头布局文件
        View headerView = navigationView.getHeaderView(0);
        ImageView user_header = (ImageView)headerView.findViewById(R.id.user_header);
        user_header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"设置头像",Toast.LENGTH_SHORT).show();
            }
        });

        // item的点击事件
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                //在这里处理item的点击事件
                switch (item.getItemId()){
                    case R.id.nv_shouye:
                        Toast.makeText(getApplicationContext(),"首页",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nv_faxian:
                        Toast.makeText(getApplicationContext(),"发现",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nv_guanzhu:
                        Toast.makeText(getApplicationContext(),"关注",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nv_shoucang:
                        Toast.makeText(getApplicationContext(),"收藏",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nv_caogao:
                        Toast.makeText(getApplicationContext(),"草稿",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nv_tiwen:
                        Toast.makeText(getApplicationContext(),"提问",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nv_change:
                        Toast.makeText(getApplicationContext(),"切换主题",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nv_set:
                        Toast.makeText(getApplicationContext(),"设置",Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }
}
