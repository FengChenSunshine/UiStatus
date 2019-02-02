package com.fengchen.uistatus.listener;

import android.view.View;

import com.fengchen.uistatus.controller.IUiStatusController;

/**
 * Created by 段露 on 2018/11/06 19:34.
 *
 * @author 段露
 * @version 1.0.0
 * @class OnRetryListener
 * @describe 重试监听器.
 */
public interface OnRetryListener {

    /**
     * 重试.
     *
     * @param target     bind Object.
     * @param controller 当前视图状态控制器.
     * @param trigger    重试触发控件.
     */
    void onUiStatusRetry(Object target, IUiStatusController controller, View trigger);
}
