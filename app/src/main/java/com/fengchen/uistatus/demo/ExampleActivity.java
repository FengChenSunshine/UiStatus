package com.fengchen.uistatus.demo;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.fengchen.uistatus.UiStatusController;
import com.fengchen.uistatus.annotation.UiStatus;

/**
 * Created by 段露 on 2018/12/29 16:16.
 *
 * @author 段露
 * @version 1.0.0
 * @class ExampleActivity
 * @describe 在Activity中使用.
 */
public class ExampleActivity extends AppCompatActivity {

    private UiStatusController mUiStatusController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("在Activity中使用：");

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mUiStatusController.isVisibleUiStatus(UiStatus.WIDGET_ELFIN)) {
                    mUiStatusController.hideWidget(UiStatus.WIDGET_ELFIN);
                } else {
                    mUiStatusController.showWidget(UiStatus.WIDGET_ELFIN);
                }
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });

        mUiStatusController = UiStatusController.get().bind(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mUiStatusController.changeUiStatusIgnore(UiStatus.NETWORK_ERROR);
            }
        }, 1000);
    }

}