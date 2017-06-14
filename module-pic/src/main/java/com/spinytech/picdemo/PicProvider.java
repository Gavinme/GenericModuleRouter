package com.spinytech.picdemo;

import com.spinytech.macore.RouterProvider;

/**
 * Created by wanglei on 2017/1/4.
 */

public class PicProvider extends RouterProvider {
    @Override
    protected void registerActions() {
        registerAction("pic",new PicAction());
    }
}
