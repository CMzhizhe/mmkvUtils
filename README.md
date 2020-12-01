

#### 1.引入依赖
```
  implementation 'com.tencent:mmkv-static:x.x.x' //https://github.com/Tencent/MMKV/blob/master/readme_cn.md
```

#### 2.添加混淆
```
-keepclasseswithmembers,includedescriptorclasses class com.tencent.mmkv.** {
    native <methods>;
    long nativeHandle;
    private static *** onMMKVCRCCheckFail(***);
    private static *** onMMKVFileLengthError(***);
    private static *** mmkvLogImp(...);
    private static *** onContentChangedByOuterProcess(***);
}

```

### 3.使用方式
```
      WJSharePreferenceConfigImpl.init(context,null);//初始化 可以指定名称

     WJSharePreferenceConfigImpl.getWjSharePreferenceConfigImpl().setString("name","张三");
     Log.e("MainActivity",WJSharePreferenceConfigImpl.getWjSharePreferenceConfigImpl().getString("name",""));
```








