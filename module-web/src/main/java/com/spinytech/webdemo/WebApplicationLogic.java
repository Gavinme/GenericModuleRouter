package com.spinytech.webdemo;

import com.spinytech.macore.BaseApplicationLogic;
import com.spinytech.macore.LocalRouter;
import com.spinytech.macore.RouterManager;

import android.content.Context;

/**
 * Created by wanglei on 2017/1/4.
 */

public class WebApplicationLogic extends BaseApplicationLogic {

    @Override
    public void onCreate(Context context) {
        super.onCreate(context);
        RouterManager.getInstance().registerProvider("web",new WebProvider());
    }
}
