package com.fengchen.uistatus.demo;

import android.content.Context;
import android.content.Intent;
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

    public static Intent navigation(Context context, int type) {
        Intent intent = new Intent(context, ShellActivity.class);
        intent.putExtra("type", type);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shell);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Fragment 示例");

        Intent intent = getIntent();
        int type = intent.getIntExtra("type", 1);
        if (1 == type) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, new ExampleFragment())
                    .commit();
        } else if (2 == type) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, new TestWeightFragment())
                    .commit();
        }
    }

}
