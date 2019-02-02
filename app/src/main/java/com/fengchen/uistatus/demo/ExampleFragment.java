package com.fengchen.uistatus.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fengchen.uistatus.UiStatusController;
import com.fengchen.uistatus.annotation.UiStatus;

/**
 * Created by 段露 on 2019/02/01 15:50.
 *
 * @author 段露
 * @version 1.0.0
 * @class ExampleFragment
 * @describe Fragment示例.
 */
public class ExampleFragment extends Fragment {

    private UiStatusController mUiStatusController;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        textView.setText("我是Fragment");
        textView.setTextColor(Color.BLACK);
        textView.setTextSize(48);
        textView.setGravity(Gravity.CENTER);
        mUiStatusController = UiStatusController.get();
        return mUiStatusController.bindFragment(textView);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mUiStatusController.changeUiStatusIgnore(UiStatus.CONTENT);
            }
        }, 1000);
    }
}
