package com.spinytech.webdemo;

import com.spinytech.macore.RouterProvider;

/**
 * Created by wanglei on 2017/1/4.
 */

public class WebProvider extends RouterProvider {
    @Override
    protected void registerActions() {
        registerAction("web",new WebAction());
    }
}
