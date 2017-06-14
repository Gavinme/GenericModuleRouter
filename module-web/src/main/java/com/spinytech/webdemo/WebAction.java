package com.spinytech.webdemo;

import java.util.HashMap;

import com.spinytech.macore.RouterAction;
import com.spinytech.macore.RouterCallback;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by wanglei on 2017/1/4.
 */

public class WebAction implements RouterAction {

    @Override
    public void invoke(Context context, HashMap requestData, RouterCallback callback) {
        if (context instanceof Activity) {
            Intent i = new Intent(context, WebActivity.class);
            context.startActivity(i);
        } else {
            Intent i = new Intent(context, WebActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
        if (callback != null) {
            HashMap result = new HashMap();
            result.put(RouterCallback.KEY_VALUE,"web success");
            callback.onResult(RouterCallback.CODE_SUCCESS, result);
        }
    }
}
