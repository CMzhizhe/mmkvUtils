package com.gxx.mmkvapplication;

import com.gxx.mmkvlibrary.MMKvUtils;

public class BaseApplication extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        new MMKvUtils.Builder().setContext(this).setMMkvName("gxx").build();
    }
}
