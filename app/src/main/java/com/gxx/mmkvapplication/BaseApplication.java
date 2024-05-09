package com.gxx.mmkvapplication;

import com.gxx.mmkvlibrary.MMSp;

public class BaseApplication extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        new MMSp.Builder().setContext(this).setMMkvName("gxx").build();
    }
}
