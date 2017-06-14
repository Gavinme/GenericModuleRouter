package com.spinytech.maindemo;

import java.util.HashMap;

import com.spinytech.macore.RouterAction;
import com.spinytech.macore.RouterCallback;

import android.content.Context;

/**
 * Created by wanglei on 2016/12/28.
 */

public class SyncAction implements RouterAction {

    @Override
    public void invoke(Context context, HashMap requestData, RouterCallback callback) {
        if (callback != null) {
            HashMap result = new HashMap();
            result.put(RouterCallback.KEY_VALUE,"sync success");
            callback.onResult(RouterCallback.CODE_SUCCESS, result);
        }
    }
}
