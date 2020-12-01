package com.wjxls.mmkvlibrary;

import android.content.Context;

import com.tencent.mmkv.MMKV;

public class WJSharePreferenceConfigImpl implements WJSharePreferenceConfig{
    private static WJSharePreferenceConfigImpl wjSharePreferenceConfigImpl;
    private Context mContext;
    private MMKV mmkv = null;

    public WJSharePreferenceConfigImpl() {
    }

    public static WJSharePreferenceConfigImpl getWjSharePreferenceConfigImpl() {
        return wjSharePreferenceConfigImpl;
    }

    public WJSharePreferenceConfigImpl(Context mContext,String mmkvName) {
        this.mContext = mContext;
        if (mmkvName == null || mmkvName.isEmpty()){
            loadConfig();
        }else {
            loadConfig(mmkvName);
        }
    }

    public static WJSharePreferenceConfigImpl init(Context context,String mmkvName){
        if (wjSharePreferenceConfigImpl == null){
            synchronized (WJSharePreferenceConfigImpl.class){
                if (wjSharePreferenceConfigImpl == null){
                    wjSharePreferenceConfigImpl = new WJSharePreferenceConfigImpl(context,mmkvName);
                }
            }
        }
        return wjSharePreferenceConfigImpl;
    }

    @Override
    public void loadConfig() {
        String dirs = this.mContext.getFilesDir().getAbsolutePath() + "/mmkv";
        MMKV.initialize(dirs);//初始化mmkv
        mmkv = MMKV.mmkvWithID("sdkWJSharePreference", MMKV.MULTI_PROCESS_MODE);
    }

    @Override
    public void loadConfig(String mmkvName) {
        String dirs = this.mContext.getFilesDir().getAbsolutePath() + "/mmkv";
        MMKV.initialize(dirs);//初始化mmkv
        mmkv = MMKV.mmkvWithID(mmkvName, MMKV.MULTI_PROCESS_MODE);
    }

    @Override
    public void setString(String key, String value) {
        mmkv.encode(key,value);
    }

    @Override
    public void setInt(String key, int value) {
        mmkv.encode(key,value);
    }

    @Override
    public void setBoolean(String key, Boolean value) {
        mmkv.encode(key,value);
    }

    @Override
    public void setByte(String key, byte[] value) {
        this.setString(key, String.valueOf(value));
    }

    @Override
    public void setShort(String key, short value) {
        this.setString(key, String.valueOf(value));
    }

    @Override
    public void setLong(String key, long value) {
        mmkv.encode(key,value);
    }

    @Override
    public void setFloat(String key, float value) {
        mmkv.encode(key,value);
    }

    @Override
    public void setDouble(String key, double value) {
        this.setString(key, String.valueOf(value));
    }

    @Override
    public void setString(int resID, String value) {
        this.setString(this.mContext.getString(resID), value);
    }

    @Override
    public void setInt(int resID, int value) {
        this.setInt(this.mContext.getString(resID), value);
    }

    @Override
    public void setBoolean(int resID, Boolean value) {
        this.setBoolean(this.mContext.getString(resID), value);
    }

    @Override
    public void setByte(int resID, byte[] value) {
        this.setByte(this.mContext.getString(resID), value);
    }

    @Override
    public void setShort(int resID, short value) {
        this.setShort(this.mContext.getString(resID), value);
    }

    @Override
    public void setLong(int resID, long value) {
        this.setLong(this.mContext.getString(resID), value);
    }

    @Override
    public void setFloat(int resID, float value) {
        this.setFloat(this.mContext.getString(resID), value);
    }

    @Override
    public void setDouble(int resID, double value) {
        this.setDouble(this.mContext.getString(resID), value);
    }

    @Override
    public String getString(String key, String defaultValue) {
        return mmkv.decodeString(key,defaultValue);
    }

    @Override
    public int getInt(String key, int defaultValue) {
        return mmkv.decodeInt(key,defaultValue);
    }

    @Override
    public boolean getBoolean(String key, Boolean defaultValue) {
        return mmkv.decodeBool(key,defaultValue);
    }

    @Override
    public byte[] getByte(String key, byte[] defaultValue) {
        try {
            return this.getString(key, "").getBytes();
        } catch (Exception var4) {
            return defaultValue;
        }
    }

    @Override
    public short getShort(String key, Short defaultValue) {
        try {
            return Short.valueOf(this.getString(key, ""));
        } catch (Exception var4) {
            return defaultValue;
        }
    }

    @Override
    public long getLong(String key, Long defaultValue) {
        return  mmkv.decodeLong(key, defaultValue);
    }

    @Override
    public float getFloat(String key, Float defaultValue) {
        return  mmkv.decodeFloat(key, defaultValue);
    }

    @Override
    public double getDouble(String key, Double defaultValue) {
        try {
            return Double.valueOf(this.getString(key, ""));
        } catch (Exception var4) {
            return defaultValue;
        }
    }

    @Override
    public String getString(int resID, String defaultValue) {
        return this.getString(this.mContext.getString(resID), defaultValue);
    }

    @Override
    public int getInt(int resID, int defaultValue) {
        return this.getInt(this.mContext.getString(resID), defaultValue);
    }

    @Override
    public boolean getBoolean(int resID, Boolean defaultValue) {
        return this.getBoolean(this.mContext.getString(resID), defaultValue);
    }

    @Override
    public byte[] getByte(int resID, byte[] defaultValue) {
        return this.getByte(this.mContext.getString(resID), defaultValue);
    }

    @Override
    public short getShort(int resID, Short defaultValue) {
        return this.getShort(this.mContext.getString(resID), defaultValue);
    }

    @Override
    public long getLong(int resID, Long defaultValue) {
        return this.getLong(this.mContext.getString(resID), defaultValue);
    }

    @Override
    public float getFloat(int resID, Float defaultValue) {
        return this.getFloat(this.mContext.getString(resID), defaultValue);
    }

    @Override
    public double getDouble(int resID, Double defaultValue) {
        return this.getDouble(this.mContext.getString(resID), defaultValue);
    }

    @Override
    public void remove(String key) {
        mmkv.removeValueForKey(key);
    }

    @Override
    public void remove(String... keys) {
        String[] var2 = keys;
        int var3 = keys.length;

        for (int var4 = 0; var4 < var3; ++var4) {
            String key = var2[var4];
            this.remove(key);
        }

    }

    @Override
    public void clear() {
        mmkv.clearAll();
    }
}
