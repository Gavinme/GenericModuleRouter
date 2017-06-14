package com.spinytech.picdemo;

import java.util.HashMap;

import com.spinytech.macore.RouterAction;
import com.spinytech.macore.RouterCallback;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by wanglei on 2017/1/4.
 */

public class PicAction implements RouterAction {

    @Override
    public void invoke(Context context, HashMap requestData, RouterCallback callback) {
        String isBigString = (String) requestData.get("is_big");
        boolean isBig = "1".equals(isBigString);
        if (context instanceof Activity) {
            Intent i = new Intent(context, PicActivity.class);
            i.putExtra("is_big", isBig);
            context.startActivity(i);
        } else {
            Intent i = new Intent(context, PicActivity.class);
            i.putExtra("is_big", isBig);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
        if (callback != null) {
            HashMap result = new HashMap();
            result.put(RouterCallback.KEY_VALUE,"pic success");
            callback.onResult(RouterCallback.CODE_SUCCESS, result);
        }
    }
}
