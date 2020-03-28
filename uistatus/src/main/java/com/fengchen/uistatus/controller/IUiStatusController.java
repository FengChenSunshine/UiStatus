package com.fengchen.uistatus.controller;

import android.support.annotation.IntRange;
import android.support.annotation.Nullable;
import android.view.View;

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

    /**
     * fix github issues #5 and #6.
     * <p>
     * 获取对应视图状态View.
     * 注意：1.如果该状态视图没有显示过那么它就没有被初始化而被返回null
     *
     * @param uiStatus 需要获取的视图状态.
     * @return uiStatus视图状态对应的View.
     */
    @Nullable
    View getView(@UiStatus int uiStatus);

    /**
     * fix github issues #5 and #6.
     * <p>
     * 获取对应视图状态View.
     * 注意：1.如果该状态视图没有初始化那么会尝试初始化并返回.
     * 2.该方法任然可能会返回null,因为你可能没有设置该状态对应的视图.
     *
     * @param uiStatus 需要获取的视图状态.
     * @return uiStatus视图状态对应的View.
     */
    @Nullable
    View getViewStrong(@UiStatus int uiStatus);

    /**
     * 切换视图状态.
     *
     * @param uiStatus 需要切换的视图状态.
     */
    void changeUiStatus(@UiStatus @IntRange(from = 1, to = 6) int uiStatus);

    /**
     * 切换视图状态,如果当前是{@link UiStatus#CONTENT}状态则忽略该次切换请求.
     *
     * @param uiStatus 需要切换的视图状态.
     */
    void changeUiStatusIgnore(@UiStatus @IntRange(from = 1, to = 6) int uiStatus);

    /**
     * 获取当前状图状态,不包含WIDGET类型.
     *
     * @return 当前状图状态.
     */
    @IntRange(from = 1, to = 6)
    @UiStatus
    int getCurrentUiStatus();

    /**
     * 显示WIDGET类型下状态视图.
     *
     * @param uiStatus {@link UiStatus}.
     */
    void showWidget(@UiStatus @IntRange(from = 7, to = 10) int uiStatus);

    /**
     * 显示WIDGET类型下状态视图,并在duration时间后自动隐藏.
     *
     * @param uiStatus {@link UiStatus}.
     * @param duration 持续时间(单位：ms).
     */
    void showWidget(@UiStatus @IntRange(from = 7, to = 10) int uiStatus, int duration);

    /**
     * 隐藏WIDGET类型下状态视图.
     *
     * @param uiStatus {@link UiStatus}.
     */
    void hideWidget(@UiStatus @IntRange(from = 7, to = 10) int uiStatus);

    /**
     * 获取对应状态下视图的可见性.
     *
     * @param uiStatus {@link UiStatus}.
     * @return true:{@link View#VISIBLE};false:{@link View#GONE}.
     */
    boolean isVisibleUiStatus(@UiStatus int uiStatus);

}
