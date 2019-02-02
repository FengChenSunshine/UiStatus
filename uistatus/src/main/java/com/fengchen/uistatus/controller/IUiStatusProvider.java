package com.fengchen.uistatus.controller;

import android.support.annotation.IdRes;
import android.support.annotation.IntRange;
import android.support.annotation.LayoutRes;

import com.fengchen.uistatus.Postcard;
import com.fengchen.uistatus.annotation.UiStatus;
import com.fengchen.uistatus.listener.OnLayoutStatusChangedListener;
import com.fengchen.uistatus.listener.OnRetryListener;

/**
 * Created by 段露 on 2019/01/31 16:05.
 *
 * @author 段露
 * @version 1.0.0
 * @class IUiStatusProvider
 * @describe UiStatus视图内容相关提供者.
 */
public interface IUiStatusProvider<C extends IUiStatusProvider> {

    C addUiStatusConfig(@UiStatus int uiStatus, @LayoutRes int layoutResId);

    C addUiStatusConfig(@UiStatus int uiStatus, @LayoutRes int layoutResId, @IdRes int retryTriggerViewId, OnRetryListener retryListener);

    Postcard getUiStatusConfig(@UiStatus int uiStatus);

    C setWidgetMargin(@UiStatus @IntRange(from = 7, to = 9) int uiStatus, int topMarginPx, int bottomMarginPx);

    C setListener(@UiStatus int uiStatus, OnRetryListener retryListener);

    C setOnLayoutStatusChangedListener(OnLayoutStatusChangedListener retryListener);

    OnLayoutStatusChangedListener getOnLayoutStatusChangedListener();

    C setAutoLoadingWithRetry(boolean isAutoLoadingWithRetry);

    boolean isAutoLoadingWithRetry();

}