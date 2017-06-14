package com.spinytech.maindemo;

import com.spinytech.macore.RouterProvider;

/**
 * Created by wanglei on 2016/12/28.
 */

public class MainProvider extends RouterProvider {
    @Override
    protected void registerActions() {
        registerAction("sync",new SyncAction());
        registerAction("async",new AsyncAction());
        registerAction("attachment",new AttachObjectAction());
    }
}
