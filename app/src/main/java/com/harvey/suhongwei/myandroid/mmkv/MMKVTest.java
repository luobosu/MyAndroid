package com.harvey.suhongwei.myandroid.mmkv;

import android.content.Context;

import com.tencent.mmkv.MMKV;

public class MMKVTest {
    public static void test(Context context){
        String rootDir = MMKV.initialize(context);
        MMKV mmkv = MMKV.defaultMMKV();
    }
}
