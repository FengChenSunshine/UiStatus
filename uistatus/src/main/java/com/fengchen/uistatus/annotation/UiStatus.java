package com.fengchen.uistatus.annotation;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by 段露 on 2018/11/02 16:49.
 *
 * @author 段露
 * @version 1.0.0
 * @class UiStatusConfig
 * @describe 布局状态.
 */
@Retention(RetentionPolicy.CLASS)
@IntDef({UiStatus.LOADING
        , UiStatus.NETWORK_ERROR, UiStatus.LOAD_ERROR
        , UiStatus.EMPTY, UiStatus.NOT_FOUND
        , UiStatus.CONTENT
        , UiStatus.WIDGET_NETWORK_ERROR, UiStatus.WIDGET_ELFIN, UiStatus.WIDGET_FLOAT})
public @interface UiStatus {
    /**
     * 加载中.
     */
    int LOADING = 1;
    /**
     * 网络错误.
     */
    int NETWORK_ERROR = 2;
    /**
     * 加载失败.
     */
    int LOAD_ERROR = 3;
    /**
     * 空布局.
     */
    int EMPTY = 4;
    /**
     * 未找到内容布局.
     */
    int NOT_FOUND = 5;
    /**
     * 内容.
     */
    int CONTENT = 6;
    /**
     * 网络错误小部件.
     * 一般会悬浮在Toolbar视图下方.
     * 视图层级上在ELFIN之下,其他状态之上.
     */
    int WIDGET_NETWORK_ERROR = 7;
    /**
     * 小精灵(提示布局).
     * 可以用来做像QQ聊天列表界面无网络时最近联系人列表顶部的网络提示布局,该布局会覆盖在其他所有视图上.
     */
    int WIDGET_ELFIN = 8;
    /**
     * 底部Float.
     */
    int WIDGET_FLOAT = 9;
}
