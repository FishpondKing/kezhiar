package com.kezhiar.android.kezhiar.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.kezhiar.android.kezhiar.R;
import com.kezhiar.android.kezhiar.base.BaseActivity;
import com.kezhiar.android.kezhiar.fragment.ARFragment;
import com.kezhiar.android.kezhiar.fragment.AboutUsFragment;
import com.kezhiar.android.kezhiar.fragment.ClassicCaseFragment;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends BaseActivity
        implements BottomNavigationBar.OnTabSelectedListener {

    private Toolbar mToolbar;
    private CircleImageView mUserHeadCIV;
    private TextView mUserNameTV;
    private FragmentManager mFragmentManager;
    private Fragment mFragment;
    private AboutUsFragment mAboutUsFragment;
    private ARFragment mARFragment;
    private ClassicCaseFragment mClassicCaseFragment;
    private BottomNavigationBar mBottomNavigationBar;

    private List<Fragment> mFragments;

    public static void activityStart(Context context){
        Intent intent = new Intent(context, HomeActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initVariables(Bundle params) {
        mAboutUsFragment = AboutUsFragment.newInstance();
        mARFragment = ARFragment.newInstance();
        mClassicCaseFragment = ClassicCaseFragment.newInstance();
        mFragments = getFragments();
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_home;
    }

    @Override
    protected void initViews(View view, Bundle savedInstanceState) {

        mToolbar = $(R.id.toolbar_home_activity);
        mUserHeadCIV = $(R.id.civ_home_activity_toolbar_user_head);
        mUserNameTV = $(R.id.tv_home_activity_toolbar_user_name);
        mFragmentManager = getSupportFragmentManager();
        mFragment = mFragmentManager.findFragmentById(R.id.fragment_container_home_activity);
        mBottomNavigationBar = $(R.id.bottom_navigation_bar_home_activity);

        mUserHeadCIV.setOnClickListener(this);

        if(mFragment == null){
            mFragmentManager.beginTransaction()
                    .add(R.id.fragment_container_home_activity, mAboutUsFragment)
                    .add(R.id.fragment_container_home_activity, mARFragment)
                    .add(R.id.fragment_container_home_activity, mClassicCaseFragment)
                    .hide(mARFragment)
                    .hide(mClassicCaseFragment)
                    .commit();
        }

        mBottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_about_us,
                        R.string.about_us))
                .addItem(new BottomNavigationItem(R.drawable.ic_ar,
                        R.string.AR))
                .addItem(new BottomNavigationItem(R.drawable.ic_classic_case,
                        R.string.classic_case))
                .setFirstSelectedPosition(0)
                .initialise();
        mBottomNavigationBar.setTabSelectedListener(this);

    }

    @Override
    protected void doBusiness(Context context) {

    }

    @Override
    public void viewClick(View v) {
        switch (v.getId()){
            case R.id.civ_home_activity_toolbar_user_head:
                LoginActivity.activityStart(this);
                break;
            default:
                break;
        }
    }

    private List<Fragment> getFragments() {
        ArrayList<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(mAboutUsFragment);
        fragments.add(mARFragment);
        fragments.add(mClassicCaseFragment);
        return fragments;
    }

    @Override
    public void onTabSelected(int position) {
        if (mFragments != null) {
            if (position < mFragments.size()) {
                mFragment = mFragments.get(position);
                mFragmentManager.beginTransaction()
                        .show(mFragment)
                        .commit();
            }
        }
    }

    @Override
    public void onTabUnselected(int position) {
        if (mFragments != null) {
            if (position < mFragments.size()) {
                mFragment = mFragments.get(position);
                mFragmentManager.beginTransaction()
                        .hide(mFragment)
                        .commit();
            }
        }
    }

    @Override
    public void onTabReselected(int position) {

    }
}
