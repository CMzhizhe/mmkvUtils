

#### 1.引入依赖
```
  maven { url 'https://jitpack.io' }
  implementation 'com.github.CMzhizhe:mmkvUtils:v1.0.5'
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
 override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MMKvUtils.Builder().setContext(this).setMMkvName("gxx").build();
        MMKvUtils.putString("name", "张三");
        Log.e("MainActivity", "使用mmkv->" + MMKvUtils.getString("name", "")+"????")

        GlobalScope.launch {
            MMKvUtils.writeFileString("abc","你好你好你好你好你好你好你好你好你好1111111111")
            Log.e("MainActivity", MMKvUtils.getFileString("abc"))
        }
    }

```








