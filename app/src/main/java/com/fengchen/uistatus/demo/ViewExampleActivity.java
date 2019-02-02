package com.fengchen.uistatus.demo;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.fengchen.uistatus.UiStatusController;
import com.fengchen.uistatus.annotation.UiStatus;

/**
 * Created by 段露 on 2019/02/01 16:12.
 *
 * @author 段露
 * @version 1.0.0
 * @class ViewExampleActivity
 * @describe View中使用示例.
 */
public class ViewExampleActivity extends AppCompatActivity {

    private UiStatusController mUiStatusController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("View中使用示例");

        mUiStatusController = UiStatusController.get().bind(findViewById(R.id.tv_example));
    }

    @Override
    protected void onResume() {
        super.onResume();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mUiStatusController.changeUiStatusIgnore(UiStatus.CONTENT);
            }
        }, 1000);
    }
}
