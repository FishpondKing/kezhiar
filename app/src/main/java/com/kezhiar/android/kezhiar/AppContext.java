package com.kezhiar.android.kezhiar;

import android.app.Activity;
import android.app.Application;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/**
 * Author: FishpondKing
 * Date: 2017/4/1:20:35
 * Email: song511653502@gmail.com
 * Description:
 */

public class AppContext extends Application {

    private static final HashMap<String, WeakReference<Activity>> sActivities =
            new HashMap<String, WeakReference<Activity>>();

    public static String APP_NAME;

    @Override
    public void onCreate() {
        super.onCreate();
        APP_NAME = getResources().getString(R.string.app_name);
    }

    public static synchronized void addActivityContext(Activity context) {
        WeakReference<Activity> reference = new WeakReference<Activity>(context);
        sActivities.put(context.getClass().getSimpleName(), reference);
    }

    public static synchronized void removeActivityContext(Activity context) {
        sActivities.remove(context.getClass().getSimpleName());
    }

    public static void removeAllActivities() {
        for (WeakReference<Activity> reference : sActivities.values()) {
            Activity activity = reference.get();
            if (activity != null && !activity.isFinishing()){
                activity.finish();
            }
        }
    }

}
