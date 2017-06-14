package com.spinytech.maindemo;

import com.spinytech.macore.RouterManager;
import com.spinytech.musicdemo.MusicApplicationLogic;
import com.spinytech.picdemo.PicApplicationLogic;
import com.spinytech.webdemo.WebApplicationLogic;

import android.app.Application;

/**
 * Created by wanglei on 2016/11/29.
 */

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        RouterManager.getInstance().registerApplicationLogic(MainApplicationLogic.class);
        RouterManager.getInstance().registerApplicationLogic(WebApplicationLogic.class);
        RouterManager.getInstance().registerApplicationLogic(MusicApplicationLogic.class);
        RouterManager.getInstance().registerApplicationLogic(PicApplicationLogic.class);
        RouterManager.getInstance().init(this);
    }

}
