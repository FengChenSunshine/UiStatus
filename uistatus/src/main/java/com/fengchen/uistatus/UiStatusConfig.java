package com.fengchen.uistatus;

import android.util.SparseIntArray;

import com.fengchen.uistatus.annotation.UiStatus;

/**
 * Created by 段露 on 2019/01/31 14:46.
 *
 * @author 段露
 * @version 1.0.0
 * @class UiStatusConfig
 * @describe 配置.
 */
public class UiStatusConfig {
    /**
     * 状态数量.
     */
    public static final int UI_STATUS_SIZE = 9;

    public static volatile SparseIntArray ID_ROUTER = new SparseIntArray();

    static {
        ID_ROUTER.put(UiStatus.LOADING, R.id.view_stub_loading);
        ID_ROUTER.put(UiStatus.NETWORK_ERROR, R.id.view_stub_network_error);
        ID_ROUTER.put(UiStatus.LOAD_ERROR, R.id.view_stub_load_error);
        ID_ROUTER.put(UiStatus.EMPTY, R.id.view_stub_empty);
        ID_ROUTER.put(UiStatus.NOT_FOUND, R.id.view_stub_not_found);
        ID_ROUTER.put(UiStatus.WIDGET_NETWORK_ERROR, R.id.view_stub_network_error_widget);
        ID_ROUTER.put(UiStatus.WIDGET_ELFIN, R.id.view_stub_hint);
        ID_ROUTER.put(UiStatus.WIDGET_FLOAT, R.id.view_stub_bottom_float);
    }

}
