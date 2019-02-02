package com.fengchen.uistatus;

import android.support.annotation.IdRes;
import android.support.annotation.IntRange;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.View;

import com.fengchen.uistatus.annotation.UiStatus;
import com.fengchen.uistatus.controller.IUiStatusController;
import com.fengchen.uistatus.controller.IUiStatusProvider;
import com.fengchen.uistatus.controller.UiStatusProviderImpl;
import com.fengchen.uistatus.listener.OnLayoutStatusChangedListener;
import com.fengchen.uistatus.listener.OnRetryListener;
import com.fengchen.uistatus.utils.BindHelp;
import com.fengchen.uistatus.widget.UiStatusLayout;

/**
 * Created by 段露 on 2019/01/31 16:16.
 *
 * @author 段露
 * @version 1.0.0
 * @class UiStatusController
 * @describe 视图状态控制器.
 */
public class UiStatusController implements IUiStatusProvider, IUiStatusController {

    private IUiStatusProvider mIUiStatusProvider;
    private UiStatusLayout mUiStatusLayout;

    private UiStatusController() {
        mIUiStatusProvider = new UiStatusProviderImpl();
        UiStatusManager.getInstance().copyConfig((UiStatusProviderImpl) mIUiStatusProvider);
    }

    public static UiStatusController get() {
        return new UiStatusController();
    }

    public UiStatusController bind(@NonNull Object target) {
        mUiStatusLayout = BindHelp.bind(target);
        mUiStatusLayout.setUiStatusProvider(this);
        //默认显示加载中视图
        changeUiStatus(UiStatus.LOADING);
        return this;
    }

    public View bindFragment(@NonNull View fragmentView) {
        mUiStatusLayout = BindHelp.bindFragmentView(fragmentView);
        mUiStatusLayout.setUiStatusProvider(this);
        //默认显示加载中视图
        changeUiStatus(UiStatus.LOADING);
        return mUiStatusLayout;
    }

    @Override
    public IUiStatusProvider addUiStatusConfig(@UiStatus int uiStatus, @LayoutRes int layoutResId) {
        mIUiStatusProvider.addUiStatusConfig(uiStatus, layoutResId);
        return this;
    }

    @Override
    public UiStatusController addUiStatusConfig(@UiStatus int uiStatus, @LayoutRes int layoutResId, @IdRes int retryTriggerViewId, OnRetryListener listener) {
        mIUiStatusProvider.addUiStatusConfig(uiStatus, layoutResId, retryTriggerViewId, listener);
        return this;
    }

    @Override
    public Postcard getUiStatusConfig(@UiStatus int uiStatus) {
        return mIUiStatusProvider.getUiStatusConfig(uiStatus);
    }

    @Override
    public IUiStatusProvider setWidgetMargin(@UiStatus @IntRange(from = 7, to = 9) int uiStatus, int topMarginPx, int bottomMarginPx) {
        mIUiStatusProvider.setWidgetMargin(uiStatus, topMarginPx, bottomMarginPx);
        return this;
    }

    @Override
    public UiStatusController setListener(@UiStatus int uiStatus, OnRetryListener listener) {
        mIUiStatusProvider.setListener(uiStatus, listener);
        return this;
    }

    @Override
    public UiStatusController setOnLayoutStatusChangedListener(OnLayoutStatusChangedListener listener) {
        mIUiStatusProvider.setOnLayoutStatusChangedListener(listener);
        return this;
    }

    @Override
    public OnLayoutStatusChangedListener getOnLayoutStatusChangedListener() {
        return mIUiStatusProvider.getOnLayoutStatusChangedListener();
    }

    @Override
    public UiStatusController setAutoLoadingWithRetry(boolean isAutoLoadingWithRetry) {
        mIUiStatusProvider.setAutoLoadingWithRetry(isAutoLoadingWithRetry);
        return this;
    }

    @Override
    public boolean isAutoLoadingWithRetry() {
        return mIUiStatusProvider.isAutoLoadingWithRetry();
    }

    ///////////////////////////////////////////////////////////////////

    @Override
    public void changeUiStatus(@UiStatus int uiStatus) {
        mUiStatusLayout.changeUiStatus(uiStatus);
    }

    @Override
    public void changeUiStatusIgnore(@UiStatus int uiStatus) {
        mUiStatusLayout.changeUiStatusIgnore(uiStatus);
    }

    @Override
    public int getCurrentUiStatus() {
        return mUiStatusLayout.getCurrentUiStatus();
    }

    @Override
    public void showWidget(@UiStatus @IntRange(from = 7, to = 9) int uiStatus) {
        mUiStatusLayout.showWidget(uiStatus);
    }

    @Override
    public void showWidget(@UiStatus @IntRange(from = 7, to = 9) int uiStatus, int duration) {
        mUiStatusLayout.showWidget(uiStatus, duration);
    }

    @Override
    public void hideWidget( @IntRange(from = 7, to = 9)  @UiStatus int uiStatus) {
        mUiStatusLayout.hideWidget(uiStatus);
    }

    @Override
    public boolean isVisibleUiStatus(@UiStatus int uiStatus) {
        return mUiStatusLayout.isVisibleUiStatus(uiStatus);
    }
}
