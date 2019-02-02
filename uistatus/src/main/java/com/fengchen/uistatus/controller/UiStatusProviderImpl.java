package com.fengchen.uistatus.controller;

import android.support.annotation.IdRes;
import android.support.annotation.IntRange;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.util.SparseArray;

import com.fengchen.uistatus.Postcard;
import com.fengchen.uistatus.UiStatusConfig;
import com.fengchen.uistatus.annotation.UiStatus;
import com.fengchen.uistatus.listener.OnLayoutStatusChangedListener;
import com.fengchen.uistatus.listener.OnRetryListener;

/**
 * Created by 段露 on 2019/01/31 16:24.
 *
 * @author 段露
 * @version 1.0.0
 * @class UiStatusProviderImpl
 * @describe UiStatus视图内容相关提供者实现类.
 */
public class UiStatusProviderImpl<C extends UiStatusProviderImpl> implements IUiStatusProvider<C> {

    /**
     * 状态视图数据集.
     */
    private SparseArray<Postcard> mPostcardArray;

    /**
     * 视图状态改变监听器.
     */
    private OnLayoutStatusChangedListener mOnLayoutStatusChangedListener;

    /**
     * 重试时是否自动切换到加载中视图:true自动切换,false不切换.
     */
    private boolean isAutoLoadingWhenRetry = true;

    /**
     * 是否自动隐藏Elfin视图:true自动隐藏，false不隐藏.默认自动隐藏.
     */
    private boolean isAutoHideElfin = true;

    /**
     * Elfin显示时长.
     * 仅isAutoHideElfin = true;时有效.
     */
    private int mElfinDuration = 3000;

    private boolean mNetworkErrorWidgetEnable = false;

    public UiStatusProviderImpl() {
        mPostcardArray = new SparseArray<>(UiStatusConfig.UI_STATUS_SIZE);
    }

    @Override
    @SuppressWarnings("unchecked")
    public C addUiStatusConfig(@UiStatus int uiStatus, @LayoutRes int layoutResId) {
        getPostcardByUiStatus(uiStatus).layoutResId = layoutResId;
        return (C) this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public C addUiStatusConfig(@UiStatus int uiStatus, @LayoutRes int layoutResId, @IdRes int retryTriggerViewId, OnRetryListener retryListener) {
        Postcard map = getPostcardByUiStatus(uiStatus);
        map.layoutResId = layoutResId;
        map.triggerViewId = retryTriggerViewId;
        map.retryListener = retryListener;
        return (C) this;
    }

    @Override
    public Postcard getUiStatusConfig(@UiStatus int uiStatus) {
        return getPostcardByUiStatus(uiStatus);
    }

    @Override
    @SuppressWarnings("unchecked")
    public C setWidgetMargin(@UiStatus @IntRange(from = 7, to = 9) int uiStatus, int topMarginPx, int bottomMarginPx) {
        Postcard postcard = getPostcardByUiStatus(uiStatus);
        postcard.topMarginPx = topMarginPx;
        postcard.bottomMarginPx = bottomMarginPx;
        return (C) this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public C setListener(@UiStatus int uiStatus, OnRetryListener retryListener) {
        getPostcardByUiStatus(uiStatus).retryListener = retryListener;
        return (C) this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public C setOnLayoutStatusChangedListener(OnLayoutStatusChangedListener listener) {
        this.mOnLayoutStatusChangedListener = listener;
        return (C) this;
    }

    @Override
    public OnLayoutStatusChangedListener getOnLayoutStatusChangedListener() {
        return this.mOnLayoutStatusChangedListener;
    }

    @Override
    @SuppressWarnings("unchecked")
    public C setAutoLoadingWithRetry(boolean isAutoLoadingWithRetry) {
        this.isAutoLoadingWhenRetry = isAutoLoadingWithRetry;
        return (C) this;
    }

    @Override
    public boolean isAutoLoadingWithRetry() {
        return this.isAutoLoadingWhenRetry;
    }

    @NonNull
    private Postcard getPostcardByUiStatus(@UiStatus int uiStatus) {
        Postcard postcard = mPostcardArray.get(uiStatus);
        if (null == postcard) {
            postcard = new Postcard(uiStatus);
            mPostcardArray.put(uiStatus, postcard);
        }
        return postcard;
    }

    @SuppressWarnings("unchecked")
    public final void copyConfig(UiStatusProviderImpl provider) {
        try {
            int size = this.mPostcardArray.size();
            for (int i = 0; i < size; i++) {
                provider.mPostcardArray.put(this.mPostcardArray.keyAt(i)
                        , this.mPostcardArray.valueAt(i).clone());
            }
            provider.mOnLayoutStatusChangedListener = this.mOnLayoutStatusChangedListener;
            provider.isAutoLoadingWhenRetry = this.isAutoLoadingWhenRetry;
            provider.isAutoHideElfin = this.isAutoHideElfin;
            provider.mElfinDuration = this.mElfinDuration;
            provider.mNetworkErrorWidgetEnable = this.mNetworkErrorWidgetEnable;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }


}