package com.spinytech.macore;

import java.util.HashMap;

/**
 * Created by guofeng on 2017/5/11.
 */

public interface RouterCallback {
    public static final int CODE_SUCCESS = 0x0000;
    public static final int CODE_ERROR = 0x0001;
    public static final int CODE_NOT_FOUND = 0X0002;
    public static final int CODE_INVALID = 0X0003;
    public static final int CODE_ROUTER_NOT_REGISTER = 0X0004;
    public static final int CODE_NOT_IMPLEMENT = 0X0005;

    public static final String KEY_ERROR_MSG="errorMsg";
    public static final String KEY_VALUE="value";
    public void onResult(int resultCode, HashMap resultData);
}
