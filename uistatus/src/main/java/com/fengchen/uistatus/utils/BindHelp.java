package com.fengchen.uistatus.utils;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.fengchen.uistatus.widget.UiStatusLayout;

/**
 * Created by 段露 on 2019/02/01 11:28.
 *
 * @author 段露
 * @version 1.0.0
 * @class BindHelp
 * @describe Bind帮助类.
 */
public class BindHelp {

    public static UiStatusLayout bind(Object target) {

        checkTarget(target);

        ViewGroup contentParent;
        int contentIndex = 0;
        if (target instanceof Activity) {
            Activity activity = (Activity) target;
            contentParent = activity.getWindow().findViewById(android.R.id.content);
        } else if (target instanceof View) {
            contentParent = (ViewGroup) ((View) target).getParent();
            View child;
            int childCount = contentParent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                child = contentParent.getChildAt(i);
                if (child == target) {
                    contentIndex = i;
                    break;
                }
            }
        } else {
            throw new IllegalArgumentException("Check your target is Activity or Fragment or View.");
        }

        return _bind(target, contentParent, contentIndex);
    }

    public static UiStatusLayout bindFragmentView(@NonNull View fragmentView) {

        checkTarget(fragmentView);

        return createUiStatusLayout(fragmentView, fragmentView);
    }

    private static UiStatusLayout _bind(Object target, ViewGroup parentView, int index) {
        View contentView = parentView.getChildAt(index);
        parentView.removeViewAt(index);
        UiStatusLayout uiStatusLayout = createUiStatusLayout(target, contentView);
        parentView.addView(uiStatusLayout, index, contentView.getLayoutParams());
        return uiStatusLayout;
    }

    private static void checkTarget(Object target) {
        if (null == target) throw new NullPointerException("target can not null");
    }

    private static UiStatusLayout createUiStatusLayout(Object target, View contentView) {
        return new UiStatusLayout(contentView, target);
    }

}
