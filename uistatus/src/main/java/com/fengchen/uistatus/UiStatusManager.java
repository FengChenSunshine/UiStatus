package com.fengchen.uistatus;

import com.fengchen.uistatus.controller.UiStatusProviderImpl;

/**
 * Created by 段露 on 2019/01/31 16:22.
 *
 * @author 段露
 * @version 1.0.0
 * @class UiStatusManager
 * @describe UiStatus全局配置管理者.
 */
public class UiStatusManager extends UiStatusProviderImpl<UiStatusManager> {

    private static volatile UiStatusManager sInstance;

    private UiStatusManager() {

    }

    public static UiStatusManager getInstance() {
        if (null == sInstance) {
            synchronized (UiStatusManager.class) {
                if (null == sInstance) {
                    sInstance = new UiStatusManager();
                }
            }
        }
        return sInstance;
    }

}