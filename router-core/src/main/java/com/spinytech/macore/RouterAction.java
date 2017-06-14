package com.spinytech.macore;

import java.util.HashMap;

import android.content.Context;

/**
 * Created by guofeng on 2016/11/29.
 */

public interface RouterAction {
    public void invoke(Context context, HashMap requestData, RouterCallback callback);
}
