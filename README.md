

#### 1.引入依赖
```
  implementation 'com.github.CMzhizhe:mmkvUtils:v1.0.3'
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
import com.gxx.mmkvlibrary.MMSp.Companion.instance
    
class MainActivity:Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        instance.setString("name", "张三")
        Log.e("MainActivity", "使用mmkv->" + instance.getString("name", "")+"????")
        //写文字到本地的文件里面
        GlobalScope.launch {
            instance.writeFileString("abc","你好你好你好你好你好你好你好你好你好1111111111")
            Log.e("MainActivity", instance.getFileString("abc"))
        }
    }

}
```








