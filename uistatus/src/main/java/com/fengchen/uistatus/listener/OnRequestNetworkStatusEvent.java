package com.fengchen.uistatus.listener;

import android.content.Context;

/**
 * Created by 段露 on 2018/11/23 9:50.
 *
 * @author 段露
 * @version 1.0.0
 * @class OnRequestNetworkStatusEvent
 * @describe 请求获取当前网络状态.
 */
public interface OnRequestNetworkStatusEvent {
    /**
     * 获取当前网络状态.
     *
     * @param context Context
     * @return true连接, false未连接.
     */
    boolean onRequestNetworkStatus(Context context);
}
