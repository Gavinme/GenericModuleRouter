package com.spinytech.macore;

import java.util.HashMap;

import android.content.Context;

/**
 * Created by wanglei on 2016/12/28.
 */

public class ErrorAction implements RouterAction {

    private static final String DEFAULT_MESSAGE = "Something was really wrong. Ha ha!";

    public ErrorAction() {
    }

    @Override
    public void invoke(Context context, HashMap requestData, RouterCallback callback) {
        if (callback != null) {
            HashMap result = new HashMap();
            result.put(RouterCallback.KEY_ERROR_MSG,DEFAULT_MESSAGE);
            callback.onResult(RouterCallback.CODE_NOT_IMPLEMENT, result);
        }
    }
}
