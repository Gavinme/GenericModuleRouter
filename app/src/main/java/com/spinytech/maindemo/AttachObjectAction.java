package com.spinytech.maindemo;

import java.util.HashMap;

import com.spinytech.macore.RouterAction;
import com.spinytech.macore.RouterCallback;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by wanglei on 2017/2/15.
 */

public class AttachObjectAction implements RouterAction {

    @Override
    public void invoke(Context context, HashMap requestData, RouterCallback callback) {
        if(requestData!= null && requestData.containsKey("textview")){
            Object textview = requestData.get("textview");
            if(textview instanceof TextView){
                ((TextView) textview).setText("The text is changed by async.");
            }
        }
        if (callback != null) {
            HashMap result = new HashMap();
            result.put(RouterCallback.KEY_VALUE,"attach object success");
            Toast toast = Toast.makeText(context, "toast from attach", Toast.LENGTH_SHORT);
            result.put("toast",toast);
            callback.onResult(RouterCallback.CODE_SUCCESS, result);
        }
    }
}
