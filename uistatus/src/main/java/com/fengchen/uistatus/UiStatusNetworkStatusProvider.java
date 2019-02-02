package com.fengchen.uistatus;

import android.content.Context;

import com.fengchen.uistatus.listener.OnRequestNetworkStatusEvent;

/**
 * Created by 段露 on 2018/11/13 16:40.
 *
 * @author 段露
 * @version 1.0.0
 * @class UiStatusNetworkStatusProvider
 * @describe UiStatus控制器网络状态提供者.
 */
public class UiStatusNetworkStatusProvider {

    private volatile static UiStatusNetworkStatusProvider sInstance;
    private OnRequestNetworkStatusEvent mNetworkStatusEvent;

    private UiStatusNetworkStatusProvider() {
    }

    public static UiStatusNetworkStatusProvider getInstance() {
        if (null == sInstance) {
            synchronized (UiStatusNetworkStatusProvider.class) {
                if (null == sInstance) {
                    sInstance = new UiStatusNetworkStatusProvider();
                }
            }
        }
        return sInstance;
    }

    public boolean isConnection(Context context) {
        return null == mNetworkStatusEvent || mNetworkStatusEvent.onRequestNetworkStatus(context);
    }

    public void registerOnRequestNetworkStatusEvent(OnRequestNetworkStatusEvent networkStatusEvent) {
        mNetworkStatusEvent = networkStatusEvent;
    }

}