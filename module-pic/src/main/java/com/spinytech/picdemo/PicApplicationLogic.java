package com.spinytech.picdemo;

import com.spinytech.macore.BaseApplicationLogic;
import com.spinytech.macore.LocalRouter;
import com.spinytech.macore.RouterManager;

import android.content.Context;

/**
 * Created by wanglei on 2017/1/4.
 */

public class PicApplicationLogic extends BaseApplicationLogic {

    @Override
    public void onCreate(Context context) {
        super.onCreate(context);
        RouterManager.getInstance().registerProvider("pic",new PicProvider());
    }
}
