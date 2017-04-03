package com.kezhiar.android.kezhiar.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kezhiar.android.kezhiar.AppContext;

/**
 * Author: FishpondKing
 * Date: 2017/4/1:20:43
 * Email: song511653502@gmail.com
 * Description:
 */

public abstract class BaseFragment extends Fragment implements View.OnClickListener {

    /**
     * 应用名
     **/
    private static String APP_NAME = AppContext.APP_NAME;

    /**
     * Fragment类名
     **/
    private final String TAG = this.getClass().getSimpleName();

    /**
     * 是否输出日志
     **/
    private boolean isDebug = true;
    /**
     * 当前Activity渲染的视图View
     **/
    private View mContextView = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        $Log(TAG + "-> onCreate");
    }

    @Nullable
    @Override
    @Deprecated
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        $Log(TAG + "-> onCreateView");
        mContextView = inflater.inflate(bindLayout(), container, false);
        initViews(mContextView, savedInstanceState);
        doBusiness(getActivity());
        return mContextView;
    }

    /**
     * Method: bindLayout()
     * Description: 绑定布局
     *
     * @Return 一般直接返回R.layout.XXX布局文件
     * Author: FishpondKing
     * Date: 2017/4/2:16:06
     */

    protected abstract int bindLayout();

    /**
     * Method: initViews(View view, Bundle savedInstanceState)
     * Description: 初始化控件
     *
     * @Param view 当前Fragment的View
     * @Param savedInstanceState 用于保存临时状态，由onCreate传递进来
     * Author: FishpondKing
     * Date: 2017/4/2:16:09
     */
    
    protected abstract void initViews(View view, Bundle savedInstanceState);

    /**
     * Method: doBusiness(Context context)
     * Description: 业务逻辑操作
     *
     * @Param context 管理该Fragment的Activity
     * Author: FishpondKing
     * Date: 2017/4/2:16:11
     */

    protected abstract void doBusiness(Context context);

    /**
     * Method: viewClick(View v)
     * Description: 处理View的点击事件
     *
     * @Param v 触发点击事件的控件
     * Author: FishpondKing
     * Date: 2017/4/2:16:19
     */

    public abstract void viewClick(View v);

    /**
     * Method: $View(int resId)
     * Description: 绑定控件
     *
     * @Param view 父布局view,一般使用当前fragment的view
     * @Param resId view资源文件R.id.XXX
     * @Return 绑定的View控件
     * Author: FishpondKing
     * Date: 2017/4/2:16:21
     */

    @SuppressWarnings("unchecked")
    public <T extends View> T $(View view, int resId) {
        return (T) view.findViewById(resId);
    }

    /**
     * Method: showToast(String msg)
     * Description: 简化的Toast
     *
     * @Param msg 要显示的内容
     * Author: FishpondKing
     * Date: 2017/4/2:16:24
     */

    protected void showToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * Method: $Log(String msg)
     * Description: 日志输出
     *
     * @Param msg 要显示的内容
     * Author: FishpondKing
     * Date: 2017/4/2:15:59
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
    public void onStart() {
        super.onStart();
        $Log(TAG + "-> onPause()");
    }

    @Override
    public void onResume() {
        super.onResume();
        $Log(TAG + "-> onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        $Log(TAG + "-> onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        $Log(TAG + "-> onStop()");
    }

    public boolean isDebug() {
        return isDebug;
    }

    public void setDebug(boolean debug) {
        isDebug = debug;
    }
}
