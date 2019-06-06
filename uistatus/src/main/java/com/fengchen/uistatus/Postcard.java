package com.fengchen.uistatus;

import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.fengchen.uistatus.annotation.UiStatus;
import com.fengchen.uistatus.listener.OnRetryListener;

/**
 * Created by 段露 on 2019/01/31 16:48.
 *
 * @author 段露
 * @version 1.0.0
 * @class Postcard
 * @describe 状态视图数据.
 */
public class Postcard implements Cloneable {

    @UiStatus
    public int uiStatus;

    @LayoutRes
    public int layoutResId;

    /**
     * 仅Widget有效.
     */
    public int topMarginPx;//一般为48dp.
    /**
     * 仅Widget有效.
     */
    public int bottomMarginPx;//.

    @IdRes
    public int triggerViewId;

    public OnRetryListener retryListener;

    public Postcard(@UiStatus int uiStatus) {
        this.uiStatus = uiStatus;
    }

    public Postcard(@UiStatus int uiStatus, @LayoutRes int layoutResId) {
        this.uiStatus = uiStatus;
        this.layoutResId = layoutResId;
    }

    public Postcard(@UiStatus int uiStatus, @LayoutRes int layoutResId, @IdRes int triggerViewId, @Nullable OnRetryListener retryListener) {
        this.uiStatus = uiStatus;
        this.layoutResId = layoutResId;
        this.triggerViewId = triggerViewId;
        this.retryListener = retryListener;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
