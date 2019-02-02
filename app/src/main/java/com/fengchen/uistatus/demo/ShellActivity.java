package com.fengchen.uistatus.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by 段露 on 2019/02/01 16:00.
 *
 * @author 段露
 * @version 1.0.0
 * @class ShellActivity
 * @describe
 */
public class ShellActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shell);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Fragment 示例");

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, new ExampleFragment())
                .commit();
    }
}
