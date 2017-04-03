package com.kezhiar.android.kezhiar.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.kezhiar.android.kezhiar.R;
import com.kezhiar.android.kezhiar.base.BaseFragment;

/**
 * Author: FishpondKing
 * Date: 2017/4/2:20:52
 * Email: song511653502@gmail.com
 * Description: AR模块
 */

public class ARFragment extends BaseFragment {

    public static ARFragment newInstance() {
        ARFragment arFragment = new ARFragment();
        return arFragment;
    }

    @Override
    protected int bindLayout() {
        return R.layout.fragment_ar;
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
