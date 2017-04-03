package com.kezhiar.android.kezhiar.base;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.kezhiar.android.kezhiar.AppContext;

/**
 * Author: FishpondKing
 * Date: 2017/4/1:20:43
 * Email: song511653502@gmail.com
 * Description: Activity基类，所有Activity都应该继承此类
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 应用名
     **/
    private static String APP_NAME = AppContext.APP_NAME;

    /**
     * Activity类名
     **/
    private final String TAG = this.getClass().getSimpleName();

    /**
     * 是否沉浸状态栏
     **/
    private boolean isSetStatusBar = true;
    /**
     * 是否允许全屏
     **/
    private boolean isAllowFullScreen = true;
    /**
     * 是否禁止旋转屏幕
     **/
    private boolean isAllowScreenRotate = true;
    /**
     * 是否输出日志
     **/
    private boolean isDebug = true;
    /**
     * 当前Activity渲染的视图View
     **/
    private View mContextView = null;

    @Override
    @Deprecated
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        $Log(TAG + "-> onCreate()");
        //添加到Activity集合中，易于管理
        AppContext.addActivityContext(this);

        try {
            Bundle bundle = getIntent().getExtras();
            initVariables(bundle);
            mContextView = LayoutInflater.from(this).inflate(bindLayout(), null);

            if (isAllowFullScreen) {
                this.getWindow().setFlags(
                        WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FULLSCREEN);
                requestWindowFeature(Window.FEATURE_NO_TITLE);
            }

            if (isSetStatusBar) {
                steepStatusBar();
            }

            setContentView(mContextView);

            if (!isAllowScreenRotate) {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            } else {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }

            initViews(mContextView, savedInstanceState);
            doBusiness(this);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method: steepStatusBar()
     * Description: 沉浸式状态栏
     * Author: FishpondKing
     * Date: 2017/4/2:11:51
     */

    private void steepStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 透明状态栏
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 透明导航栏
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    /**
     * Method: initVariables()
     * Description: 初始化变量
     *
     * @Param params 上个页面在intent中添加的bundle参数
     * Author: FishpondKing
     * Date: 2017/4/1:21:41
     */

    protected abstract void initVariables(Bundle params);

    /**
     * Method: bindLayout()
     * Description: 绑定布局
     *
     * @Return 一般直接返回R.layout.XXX布局文件
     * Author: FishpondKing
     * Date: 2017/4/2:10:07
     */

    protected abstract int bindLayout();

    /**
     * Method: initViews(View view, Bundle savedInstanceState)
     * Description: 初始化控件
     *
     * @Param view 当前Activity的View
     * @Param savedInstanceState 用于保存临时状态，由onCreate传递进来
     * Author: FishpondKing
     * Date: 2017/4/1:21:44
     */

    protected abstract void initViews(View view, Bundle savedInstanceState);

    /**
     * Method: doBusiness(Context context)
     * Description: 业务逻辑操作
     *
     * @Param context Activity本身
     * Author: FishpondKing
     * Date: 2017/4/1:21:45
     */

    protected abstract void doBusiness(Context context);

    /**
     * Method: viewClick(View v)
     * Description: 处理View的点击事件
     *
     * @Param v 触发点击事件的控件
     * Author: FishpondKing
     * Date: 2017/4/2:10:26
     */

    public abstract void viewClick(View v);

    /**
     * Method: $View(int resId)
     * Description: 绑定控件
     *
     * @Param resId view资源文件R.id.XXX
     * @Return 绑定的View控件
     * Author: FishpondKing
     * Date: 2017/4/2:10:49
     */

    @SuppressWarnings("unchecked")
    public <T extends View> T $(int resId) {
        return (T) super.findViewById(resId);
    }

    /**
     * Method: showToast(String msg)
     * Description: 简化的Toast
     *
     * @Param msg 要显示的内容
     * Author: FishpondKing
     * Date: 2017/4/2:11:06
     */

    protected void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * Method: $Log(String msg)
     * Description: 日志输出
     *
     * @Param msg 要显示的内容
     * Author: FishpondKing
     * Date: 2017/4/2:9:43
     */

    protected void $Log(String msg) {
        if (isDebug) {
            Log.d(APP_NAME, msg);
        }
    }

    @Override
    @Deprecated
    public void onClick(View view) {
        if (!isFastClick())
            viewClick(view);
    }

    private boolean isFastClick() {
        long lastClick = 0;
        if (System.currentTimeMillis() - lastClick <= 1000) {
            return true;
        }
        lastClick = System.currentTimeMillis();
        return false;
    }

    @Override
    protected void onStart() {
        super.onStart();
        $Log(TAG + "-> onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        $Log(TAG + "-> onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        $Log(TAG + "-> onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        $Log(TAG + "-> onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        $Log(TAG + "-> onDestroy()");
    }

    public boolean isSetStatusBar() {
        return isSetStatusBar;
    }

    public void setSetStatusBar(boolean setStatusBar) {
        isSetStatusBar = setStatusBar;
    }

    public boolean isAllowFullScreen() {
        return isAllowFullScreen;
    }

    public void setAllowFullScreen(boolean allowFullScreen) {
        isAllowFullScreen = allowFullScreen;
    }

    public boolean isAllowScreenRotate() {
        return isAllowScreenRotate;
    }

    public void setAllowScreenRotate(boolean allowScreenRotate) {
        isAllowScreenRotate = allowScreenRotate;
    }

    public boolean isDebug() {
        return isDebug;
    }

    public void setDebug(boolean debug) {
        isDebug = debug;
    }

}
