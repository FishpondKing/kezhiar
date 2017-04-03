package com.kezhiar.android.kezhiar.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.kezhiar.android.kezhiar.R;
import com.kezhiar.android.kezhiar.base.BaseFragment;

/**
 * Author: FishpondKing
 * Date: 2017/4/2:20:38
 * Email: song511653502@gmail.com
 * Description: “关于我们”模块
 */

public class AboutUsFragment extends BaseFragment {

    public static AboutUsFragment newInstance() {
        AboutUsFragment aboutUsFragment = new AboutUsFragment();
        return aboutUsFragment;
    }

    @Override
    protected int bindLayout() {
        return R.layout.fragment_about_us;
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
