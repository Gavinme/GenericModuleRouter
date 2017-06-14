package com.spinytech.musicdemo;

import java.util.HashMap;

import com.spinytech.macore.RouterAction;
import com.spinytech.macore.RouterCallback;

import android.content.Context;
import android.content.Intent;

/**
 * Created by wanglei on 2016/12/28.
 */

public class ShutdownAction implements RouterAction {

    @Override
    public void invoke(Context context, HashMap requestData, RouterCallback callback) {
        context.getApplicationContext().stopService(new Intent(context, MusicService.class));
        if (callback != null) {
            HashMap result = new HashMap();
            result.put(RouterCallback.KEY_VALUE,"shutdown success");
            callback.onResult(RouterCallback.CODE_SUCCESS, result);
        }
    }
}
