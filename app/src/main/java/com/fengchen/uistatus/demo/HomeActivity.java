package com.fengchen.uistatus.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.fengchen.uistatus.UiStatusController;
import com.fengchen.uistatus.annotation.UiStatus;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private UiStatusController mUiStatusController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("UiStatus示例");

        findViewById(R.id.btn_example_activity).setOnClickListener(this);
        findViewById(R.id.btn_example_fragment).setOnClickListener(this);
        findViewById(R.id.btn_example_view).setOnClickListener(this);
        findViewById(R.id.btn_example_network_error_widget).setOnClickListener(this);
        findViewById(R.id.btn_example_elfin).setOnClickListener(this);
        findViewById(R.id.btn_example_elfin_cancel).setOnClickListener(this);
        findViewById(R.id.btn_example_widget_bottom_float).setOnClickListener(this);

        mUiStatusController = UiStatusController.get().bind(this);
        mUiStatusController.changeUiStatusIgnore(UiStatus.CONTENT);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_example_activity:
                startActivity(new Intent(this, ExampleActivity.class));
                break;
            case R.id.btn_example_fragment:
                startActivity(new Intent(this, ShellActivity.class));
                break;
            case R.id.btn_example_view:
                startActivity(new Intent(this, ViewExampleActivity.class));
                break;
            case R.id.btn_example_network_error_widget:
                if (mUiStatusController.isVisibleUiStatus(UiStatus.WIDGET_NETWORK_ERROR)) {
                    mUiStatusController.hideWidget(UiStatus.WIDGET_NETWORK_ERROR);
                } else {
                    mUiStatusController.showWidget(UiStatus.WIDGET_NETWORK_ERROR);
                }
                break;
            case R.id.btn_example_elfin:
                if (mUiStatusController.isVisibleUiStatus(UiStatus.WIDGET_ELFIN)) {
                    mUiStatusController.hideWidget(UiStatus.WIDGET_ELFIN);
                } else {
                    mUiStatusController.showWidget(UiStatus.WIDGET_ELFIN);
                }
                break;
            case R.id.btn_example_elfin_cancel:
                if (mUiStatusController.isVisibleUiStatus(UiStatus.WIDGET_ELFIN)) {
                    mUiStatusController.hideWidget(UiStatus.WIDGET_ELFIN);
                } else {
                    mUiStatusController.showWidget(UiStatus.WIDGET_ELFIN, 2000);
                }
                break;
            case R.id.btn_example_widget_bottom_float:
                if (mUiStatusController.isVisibleUiStatus(UiStatus.WIDGET_FLOAT)) {
                    mUiStatusController.hideWidget(UiStatus.LOADING);
                } else {
                    mUiStatusController.showWidget(UiStatus.WIDGET_FLOAT, 2000);
                }
                break;
        }
    }
}