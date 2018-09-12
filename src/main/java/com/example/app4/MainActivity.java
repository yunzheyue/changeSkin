package com.example.app4;

import android.os.Environment;
import android.preference.Preference;
import android.preference.SwitchPreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.app4.loader.CustomSDCardLoader;

import java.io.File;

import skin.support.SkinCompatManager;
import skin.support.content.res.ColorState;
import skin.support.content.res.SkinCompatUserThemeManager;

public class MainActivity extends AppCompatActivity {

    private boolean boolValue = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt_app = findViewById(R.id.bt_app);
        Button bt_plugin = findViewById(R.id.bt_plugin);
        Button bt_sdcard = findViewById(R.id.bt_sdcard);
        bt_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!boolValue) {
                    boolValue = true;
                    SkinCompatManager.getInstance().loadSkin("night", null, SkinCompatManager.SKIN_LOADER_STRATEGY_BUILD_IN);
                } else {
                    boolValue = false;
                    SkinCompatManager.getInstance().restoreDefaultTheme();
                }
            }
        });
        bt_plugin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!boolValue) {
                    boolValue = true;
                    SkinCompatManager.getInstance().loadSkin("night.skin", new SkinCompatManager.SkinLoaderListener() {
                        @Override
                        public void onStart() {
                            Log.e("TAG", "----start");
                        }

                        @Override
                        public void onSuccess() {
                            Log.e("TAG", "----onSuccess");
                        }

                        @Override
                        public void onFailed(String errMsg) {
                            Log.e("TAG", "----onFailed---" + errMsg);
                        }
                    }, SkinCompatManager.SKIN_LOADER_STRATEGY_ASSETS);
                } else {
                    boolValue = false;
                    SkinCompatManager.getInstance().restoreDefaultTheme();
                }
            }
        });


        bt_sdcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!boolValue) {
                    boolValue = true;

                    SkinCompatManager.getInstance().loadSkin("night.skin", new SkinCompatManager.SkinLoaderListener() {
                        @Override
                        public void onStart() {
                            Log.e("TAG", "----start");
                        }

                        @Override
                        public void onSuccess() {
                            Log.e("TAG", "----onSuccess");
                        }

                        @Override
                        public void onFailed(String errMsg) {
                            Log.e("TAG", "----onFailed---" + errMsg);
                        }
                    }, CustomSDCardLoader.SKIN_LOADER_STRATEGY_SDCARD);
                } else {
                    boolValue = false;
                    SkinCompatManager.getInstance().restoreDefaultTheme();
                }
            }
        });


        TextView tv_love = findViewById(R.id.tv_love);
        tv_love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!boolValue) {
                    boolValue = true;
                    SkinCompatUserThemeManager.get().addColorState(R.color.colorPrimary, "#ffffff");
                    //SkinCompatUserThemeManager.get().addColorState(R.color.colorPrimary, new ColorState.ColorBuilder().a().build());
                } else {
                    boolValue = false;
//                     清除所有已有颜色值。
//                    SkinCompatUserThemeManager.get().clearColors();
                }
            }
        });
        TextView tv_like = findViewById(R.id.tv_like);
        tv_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!boolValue) {
                    boolValue = true;
                    SkinCompatUserThemeManager.get().addDrawablePath(R.mipmap.tab_home_select, Environment.getExternalStorageDirectory() + File.separator + "Pictures/JPEG_20180628_162533.jpg");
//                     要换肤的资源id，图片路径，图片旋转角度(默认为0)
//                    SkinCompatUserThemeManager.get().addDrawablePath(R.drawable.windowBackground, "／sdcard/DCIM/Camera/xxx.jpg", 90);
                } else {
                    boolValue = false;
                    // 清除所有已有图片路径。
//                    SkinCompatUserThemeManager.get().clearDrawables();
                }

            }
        });


    }
}
