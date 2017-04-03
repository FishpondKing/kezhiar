package com.kezhiar.android.kezhiar.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.kezhiar.android.kezhiar.R;
import com.kezhiar.android.kezhiar.base.BaseActivity;

/**
 * Author: FishpondKing
 * Date: 2017/4/3:10:46
 * Email: song511653502@gmail.com
 * Description: 登陆模块
 */

public class LoginActivity extends BaseActivity {

    public static void activityStart(Context context){
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initVariables(Bundle params) {

    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_login;
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
