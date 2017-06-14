package com.spinytech.maindemo;

import com.spinytech.macore.BaseApplicationLogic;
import com.spinytech.macore.LocalRouter;
import com.spinytech.macore.RouterManager;

import android.content.Context;

/**
 * Created by wanglei on 2016/11/29.
 */

public class MainApplicationLogic extends BaseApplicationLogic {
    @Override
    public void onCreate(Context context) {
        super.onCreate(context);
        RouterManager.getInstance().registerProvider("main",new MainProvider());
    }
}
