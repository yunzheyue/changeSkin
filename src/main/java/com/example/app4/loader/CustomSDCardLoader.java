package com.example.app4.loader;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;

import skin.support.load.SkinSDCardLoader;
import skin.support.utils.SkinFileUtils;

public class CustomSDCardLoader extends SkinSDCardLoader {
    public static final int SKIN_LOADER_STRATEGY_SDCARD = Integer.MAX_VALUE;

    @Override
    protected String getSkinPath(Context context, String skinName) {
        Log.e("TAG", "----file---AbsolutePath()===" + new File(Environment.getExternalStorageDirectory() + File.separator + skinName).getAbsolutePath());
        return new File(Environment.getExternalStorageDirectory() + File.separator + skinName).getAbsolutePath();
    }

    @Override
    public int getType() {
        return SKIN_LOADER_STRATEGY_SDCARD;
    }
}
