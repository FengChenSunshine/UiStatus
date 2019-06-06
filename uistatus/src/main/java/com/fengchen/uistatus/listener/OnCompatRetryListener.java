package com.fengchen.uistatus.listener;

import android.support.annotation.NonNull;
import android.view.View;

import com.fengchen.uistatus.annotation.UiStatus;
import com.fengchen.uistatus.controller.IUiStatusController;

/********************************
 * @name OnCompatRetryListener
 * @author 段露
 * @createDate 2019/06/06 14:23
 * @updateDate 2019/06/06 14:23
 * @version V1.0.0
 * @describe 包含所有状态的重试监听器.
 * @since 1.0.1
 ********************************/
public interface OnCompatRetryListener {

    /**
     * 重试.
     *
     * @param uiStatus   UiStatus.
     * @param target     bind Object.
     * @param controller 当前视图状态控制器.
     * @param trigger    重试触发控件.
     */
    void onUiStatusRetry(@UiStatus int uiStatus, @NonNull Object target, @NonNull IUiStatusController controller, @NonNull View trigger);

}
