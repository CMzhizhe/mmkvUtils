package com.wjxls.mmkvapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.wjxls.mmkvlibrary.WJSharePreferenceConfigImpl;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        WJSharePreferenceConfigImpl.getWjSharePreferenceConfigImpl().setString("name","张三");
        Log.e("MainActivity",WJSharePreferenceConfigImpl.getWjSharePreferenceConfigImpl().getString("name",""));
    }
}