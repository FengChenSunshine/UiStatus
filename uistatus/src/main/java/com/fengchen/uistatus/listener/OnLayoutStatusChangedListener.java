package com.fengchen.uistatus.listener;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.fengchen.uistatus.annotation.UiStatus;

/**
 * Created by 段露 on 2018/11/07 10:02.
 *
 * @author 段露
 * @version 1.0.0
 * @class OnLayoutStatusChangedListener
 * @describe 状态改变监听器.
 */
public interface OnLayoutStatusChangedListener {

    /**
     * 准备改变.
     *
     * @param target   bind Object.
     * @param view     视图，注意：在非内容视图时第一次为null.
     * @param uiStatus UiStatusConfig.
     * @param isShow   true显示,false隐藏.
     */
    void onPrepareChanged(@NonNull Object target, @Nullable View view, @UiStatus int uiStatus, boolean isShow);

    /**
     * 改变完成.
     *
     * @param target   bind Object.
     * @param view     视图.
     * @param uiStatus UiStatusConfig.
     * @param isShow   true显示,false隐藏.
     */
    void onChangedComplete(@NonNull Object target, @NonNull View view, @UiStatus int uiStatus, boolean isShow);
}
