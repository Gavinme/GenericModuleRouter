package com.spinytech.macore;

import java.util.HashMap;

import android.content.Context;
import android.util.Log;

/**
 * The Local Router
 */

public class LocalRouter {
    private static final String TAG = "LocalRouter";
    private static LocalRouter sInstance = null;
    private HashMap<String, RouterProvider> mProviders = null;
    private Context mApplication;

    private LocalRouter(Context context) {
        mApplication = context;
        mProviders = new HashMap<>();
    }

    public static synchronized LocalRouter init(Context context) {
        if (sInstance == null) {
            sInstance = new LocalRouter(context);
        }
        return sInstance;
    }
    public static synchronized LocalRouter getInstance() {
        if (sInstance == null) {
            throw new RuntimeException("Local Router must be init first");
        }
        return sInstance;
    }


    void registerProvider(String providerName, RouterProvider provider) {
        mProviders.put(providerName, provider);
    }

    /**
     * 路由只涉及功能分发，不做线程切换，在调起线程执行，并在该线程回调，如果有耗时或者UI线程需求，自行切换
     * @param context context
     * @param routerRequest 请求
     * @param callback 回调
     */
    void route(Context context, RouterRequest routerRequest, RouterCallback callback) {
        Log.d(TAG, "Process:Local route start: " + System.currentTimeMillis());
        // Local request
        Log.d(TAG, "Process:Local find action start: " + System.currentTimeMillis());
        RouterAction targetAction = findRequestAction(routerRequest);
        Log.d(TAG, "Process:Local find action end: " + System.currentTimeMillis());
        // Sync result, return the result immediately.
        try {
            targetAction.invoke(context, routerRequest.getData() ,callback);
        } catch (Exception e) {
            e.printStackTrace();
            HashMap result = new HashMap();
            result.put(RouterCallback.KEY_ERROR_MSG,e.getMessage());
            callback.onResult(RouterCallback.CODE_ERROR, result);
        }
        Log.d(TAG, "Process:Local route end: " + System.currentTimeMillis());
    }

    private RouterAction findRequestAction(RouterRequest routerRequest) {
        RouterProvider targetProvider = mProviders.get(routerRequest.getProvider());
        ErrorAction defaultNotFoundAction = new ErrorAction();
        if (null == targetProvider) {
            return defaultNotFoundAction;
        } else {
            RouterAction targetAction = targetProvider.findAction(routerRequest.getAction());
            if (null == targetAction) {
                return defaultNotFoundAction;
            } else {
                return targetAction;
            }
        }
    }

}
