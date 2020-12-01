package com.wjxls.mmkvapplication;

import com.wjxls.mmkvlibrary.WJSharePreferenceConfigImpl;

public class BaseApplication extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        WJSharePreferenceConfigImpl.init(this,null);
    }
}
