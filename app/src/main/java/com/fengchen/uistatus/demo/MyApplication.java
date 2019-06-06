package com.fengchen.uistatus.demo;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.fengchen.uistatus.UiStatusManager;
import com.fengchen.uistatus.UiStatusNetworkStatusProvider;
import com.fengchen.uistatus.annotation.UiStatus;
import com.fengchen.uistatus.controller.IUiStatusController;
import com.fengchen.uistatus.listener.OnCompatRetryListener;
import com.fengchen.uistatus.listener.OnRequestNetworkStatusEvent;
import com.fengchen.uistatus.listener.OnRetryListener;

/**
 * Created by 段露 on 2018/12/29 9:45.
 *
 * @author 段露
 * @version 1.0.0
 * @class MyApplication
 * @describe
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        UiStatusManager.getInstance()
                .setWidgetMargin(UiStatus.WIDGET_NETWORK_ERROR, 48 * 3, 0)
                .setWidgetMargin(UiStatus.WIDGET_ELFIN, 48 * 3, 0)
                .setWidgetMargin(UiStatus.WIDGET_FLOAT, 0, 0)
                .addUiStatusConfig(UiStatus.LOADING, R.layout.ui_status_layout_loading)//加载中.
                .addUiStatusConfig(UiStatus.NETWORK_ERROR, R.layout.ui_status_layout_network_error, R.id.tv_network_error_retry
                        , null
//                        new OnRetryListener() {
//                            @Override
//                            public void onUiStatusRetry(Object target, final IUiStatusController controller, View trigger) {
//                                Toast.makeText(trigger.getContext(), "网络错误重试", Toast.LENGTH_LONG).show();
//                                new Handler().postDelayed(new Runnable() {
//                                    @Override
//                                    public void run() {
//                                        controller.changeUiStatus(UiStatus.LOAD_ERROR);
//                                    }
//                                }, 1000);
//                            }
//                        }
                )//网络错误.
                .addUiStatusConfig(UiStatus.LOAD_ERROR, R.layout.ui_status_layout_load_error, R.id.tv_load_error_retry
                        , new OnRetryListener() {
                            @Override
                            public void onUiStatusRetry(Object target, final IUiStatusController controller, View trigger) {
                                Toast.makeText(trigger.getContext(), "加载失败重试", Toast.LENGTH_SHORT).show();
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        controller.changeUiStatus(UiStatus.EMPTY);
                                    }
                                }, 1000);
                            }
                        })//加载失败.
                .addUiStatusConfig(UiStatus.EMPTY, R.layout.ui_status_layout_empty, R.id.tv_empty_retry
                        , new OnRetryListener() {
                            @Override
                            public void onUiStatusRetry(Object target, final IUiStatusController controller, View trigger) {
                                Toast.makeText(trigger.getContext(), "空布局重试", Toast.LENGTH_SHORT).show();
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        controller.changeUiStatus(UiStatus.NOT_FOUND);
                                    }
                                }, 1000);
                            }
                        })//空布局.
                .addUiStatusConfig(UiStatus.NOT_FOUND, R.layout.ui_status_layout_not_found, R.id.tv_not_found_retry
                        , new OnRetryListener() {
                            @Override
                            public void onUiStatusRetry(Object target, final IUiStatusController controller, View trigger) {
                                Toast.makeText(trigger.getContext(), "未找到内容重试", Toast.LENGTH_SHORT).show();
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        controller.changeUiStatus(UiStatus.CONTENT);
                                        new Handler().postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                controller.changeUiStatus(UiStatus.WIDGET_ELFIN);
                                            }
                                        }, 1000);
                                    }
                                }, 1000);
                            }
                        })//未找到内容布局.
                .addUiStatusConfig(UiStatus.WIDGET_ELFIN, R.layout.ui_status_layout_hint, R.id.tv_hint_retry
                        , new OnRetryListener() {
                            @Override
                            public void onUiStatusRetry(Object target, final IUiStatusController controller, View trigger) {
                                Toast.makeText(trigger.getContext(), "提示内容重试", Toast.LENGTH_SHORT).show();
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        new Handler().postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                controller.changeUiStatus(UiStatus.WIDGET_ELFIN);
                                            }
                                        }, 1000);
                                    }
                                }, 1000);
                            }
                        })//提示布局.
                .addUiStatusConfig(UiStatus.WIDGET_NETWORK_ERROR, R.layout.widget_ui_status_network_error_widget, R.id.tv_check_network, new OnRetryListener() {
                    @Override
                    public void onUiStatusRetry(Object target, IUiStatusController controller, View trigger) {
                        Toast.makeText(trigger.getContext(), "检查网络设置", Toast.LENGTH_SHORT).show();
                    }
                })
                .addUiStatusConfig(UiStatus.WIDGET_FLOAT, R.layout.widget_ui_status__widget_float, R.id.tv_float, new OnRetryListener() {
                    @Override
                    public void onUiStatusRetry(Object target, IUiStatusController controller, View trigger) {
                        Toast.makeText(trigger.getContext(), "我是Float", Toast.LENGTH_SHORT).show();
                    }
                })
                .setOnCompatRetryListener(new OnCompatRetryListener() {
                    @Override
                    public void onUiStatusRetry(int uiStatus, @NonNull Object target, final @NonNull IUiStatusController controller, @NonNull View trigger) {
                        Log.i("--", "全局设置" + uiStatus);

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                controller.changeUiStatus(UiStatus.LOAD_ERROR);
                            }
                        }, 1000);
                    }
                });

        UiStatusNetworkStatusProvider.getInstance()
                .registerOnRequestNetworkStatusEvent(new OnRequestNetworkStatusEvent() {
                    @Override
                    public boolean onRequestNetworkStatus(@NonNull Context context) {
                        return NetworkManager.isConnected(context);
                    }
                });
    }

}
