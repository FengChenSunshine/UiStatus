package com.fengchen.uistatus.demo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fengchen.uistatus.UiStatusController;
import com.fengchen.uistatus.annotation.UiStatus;

/********************************
 * @name TestWeightFragment.
 * @author 段露.
 * @company 浙江托普云农科技股份有限公司.
 * @createDate 2020/3/30 9:45.
 * @updateDate 2020/3/30 9:45.
 * @version V1.0.0
 * @describe .
 ********************************/
public class TestWeightFragment extends Fragment {
    private UiStatusController mUiStatusController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_test_weight, container, false);
        TextView tvTestWeight = rootView.findViewById(R.id.tv_test_weight);
        ViewGroup.LayoutParams lp = tvTestWeight.getLayoutParams();
        mUiStatusController = UiStatusController.get();
        mUiStatusController.bind(tvTestWeight);
        mUiStatusController.changeUiStatusIgnore(UiStatus.CONTENT);
        return rootView;
    }

}
