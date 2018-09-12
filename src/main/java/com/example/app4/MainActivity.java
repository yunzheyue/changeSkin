package com.example.app4;

import android.preference.Preference;
import android.preference.SwitchPreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.app4.loader.CustomSDCardLoader;

import skin.support.SkinCompatManager;

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
                    SkinCompatManager.getInstance().loadSkin("night.skin",  new SkinCompatManager.SkinLoaderListener() {
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
                            Log.e("TAG", "----onFailed---"+errMsg);
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
                            Log.e("TAG", "----onFailed---"+errMsg);
                        }
                    }, CustomSDCardLoader.SKIN_LOADER_STRATEGY_SDCARD);
                } else {
                    boolValue = false;
                    SkinCompatManager.getInstance().restoreDefaultTheme();
                }
            }
        });



    }
}
