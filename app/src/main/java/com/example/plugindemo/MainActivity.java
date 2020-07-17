package com.example.plugindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.plug_core.HookManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.mBtnLoadPlugin)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        loadPlugin();
                    }
                });


        findViewById(R.id.mBtnStartProxy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startProxy();
            }


        });
    }

    /**
     * 加载插件
     */
    private void loadPlugin() {
        HookManager.getInstance().loadPlugin(this);
        Toast.makeText(this, "加载完成", Toast.LENGTH_LONG).show();
    }

    /**
     * 跳转插件
     */
    private void startProxy() {
        Intent intent = new Intent(this, ProxyActivity.class);//这里就是一个占坑的activity
        //这里是拿到我们加载的插件的第一个activity的全类名
        intent.putExtra("ClassName", HookManager.getInstance().packageInfo.activities[0].name);

        startActivity(intent);
    }
}