package com.fengchen.uistatus.controller;

import android.support.annotation.IntRange;

import com.fengchen.uistatus.annotation.UiStatus;

/**
 * Created by 段露 on 2019/01/31 14:34.
 *
 * @author 段露
 * @version 1.0.0
 * @class IUiStatusController
 * @describe 状态控制器方法定义.
 */
public interface IUiStatusController {

    void changeUiStatus(@UiStatus @IntRange(from = 1, to = 6) int uiStatus);

    void changeUiStatusIgnore(@UiStatus @IntRange(from = 1, to = 6) int uiStatus);

    @IntRange(from = 1, to = 6)
    @UiStatus
    int getCurrentUiStatus();

    void showWidget(@UiStatus @IntRange(from = 7, to = 9) int uiStatus);

    void showWidget(@UiStatus @IntRange(from = 7, to = 9) int uiStatus, int duration);

    void hideWidget(@UiStatus @IntRange(from = 7, to = 9) int uiStatus);

    boolean isVisibleUiStatus(@UiStatus int uiStatus);

}
