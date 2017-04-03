package com.kezhiar.android.kezhiar.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.kezhiar.android.kezhiar.R;
import com.kezhiar.android.kezhiar.base.BaseFragment;

/**
 * Author: FishpondKing
 * Date: 2017/4/2:20:40
 * Email: song511653502@gmail.com
 * Description: “经典案例”模块
 */

public class ClassicCaseFragment extends BaseFragment {

    public static ClassicCaseFragment newInstance() {
        ClassicCaseFragment classicCaseFragment = new ClassicCaseFragment();
        return classicCaseFragment;
    }

    @Override
    protected int bindLayout() {
        return R.layout.fragment_classic_case;
    }

    @Override
    protected void initViews(View view, Bundle savedInstanceState) {

    }

    @Override
    protected void doBusiness(Context context) {

    }

    @Override
    public void viewClick(View v) {

    }
}
