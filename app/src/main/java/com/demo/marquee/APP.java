package com.demo.marquee;

import android.app.Application;
import android.content.Context;

public class APP extends Application {

    private static APP mApplication;

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplication = this;
        context = getApplicationContext();
    }

    public static APP getInstance() {
        return mApplication;
    }
}
