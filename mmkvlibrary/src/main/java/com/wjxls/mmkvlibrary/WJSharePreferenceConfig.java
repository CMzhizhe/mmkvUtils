package com.wjxls.mmkvlibrary;

/**
 * 创建时间: 2018/7/19
 * 创建人: GaoXiaoXiong
 * 功能描述:
 */
public interface WJSharePreferenceConfig {
    void loadConfig();

    void loadConfig(String mmkvName);

    void setString(String var1, String var2);

    void setInt(String var1, int var2);

    void setBoolean(String var1, Boolean var2);

    void setByte(String var1, byte[] var2);

    void setShort(String var1, short var2);

    void setLong(String var1, long var2);

    void setFloat(String var1, float var2);

    void setDouble(String var1, double var2);

    void setString(int var1, String var2);

    void setInt(int var1, int var2);

    void setBoolean(int var1, Boolean var2);

    void setByte(int var1, byte[] var2);

    void setShort(int var1, short var2);

    void setLong(int var1, long var2);

    void setFloat(int var1, float var2);

    void setDouble(int var1, double var2);

    String getString(String var1, String var2);

    int getInt(String var1, int var2);

    boolean getBoolean(String var1, Boolean var2);

    byte[] getByte(String var1, byte[] var2);

    short getShort(String var1, Short var2);

    long getLong(String var1, Long var2);

    float getFloat(String var1, Float var2);

    double getDouble(String var1, Double var2);

    String getString(int var1, String var2);

    int getInt(int var1, int var2);

    boolean getBoolean(int var1, Boolean var2);

    byte[] getByte(int var1, byte[] var2);

    short getShort(int var1, Short var2);

    long getLong(int var1, Long var2);

    float getFloat(int var1, Float var2);

    double getDouble(int var1, Double var2);

    void remove(String var1);

    void remove(String... var1);

    void clear();
}
