package com.gxx.mmkvapplication

import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.gxx.mmkvlibrary.MMKvUtils
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity:Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MMKvUtils.putString("name", "张三");
        Log.e("MainActivity", "使用mmkv->" + MMKvUtils.getString("name", "")+"????")

        GlobalScope.launch {
            MMKvUtils.writeFileString("abc","你好你好你好你好你好你好你好你好你好1111111111")
            Log.e("MainActivity", MMKvUtils.getFileString("abc"))
        }
    }

}