package com.spinytech.macore;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;

/**
 * Created by wanglei on 2016/11/25.
 */

public class RouterManager {
    private static final String TAG = "MaApplication";
    private static RouterManager sInstance = new RouterManager();
    private ArrayList<ApplicationLogicWrapper> mLogicClassList = new ArrayList<>();

    public static RouterManager getInstance() {
        return sInstance;
    }

    private RouterManager(){
    }

    public void init(Context context) {
        if( context == null){
            throw new RuntimeException("Router manager init with context null");
        }
        context = context.getApplicationContext();
        // double check
        if( context == null){
            throw new RuntimeException("Router manager init with applciation context null");
        }
        Log.d(TAG, "Application onCreate start: " + System.currentTimeMillis());
        LocalRouter.init(context);
        appLogicInit(context);
        Log.d(TAG, "Application onCreate end: " + System.currentTimeMillis());
    }

    private void appLogicInit(Context context) {
        if( mLogicClassList == null || mLogicClassList.size() < 1){
            return ;
        }
        for (ApplicationLogicWrapper priorityLogicWrapper : mLogicClassList) {
            // construct
            if (null != priorityLogicWrapper) {
                try {
                    priorityLogicWrapper.instance = priorityLogicWrapper.logicClass.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (null != priorityLogicWrapper && null != priorityLogicWrapper.instance) {
                    priorityLogicWrapper.instance.onCreate(context);
                }
            }
        }
    }

    public boolean registerApplicationLogic(Class<? extends BaseApplicationLogic> logicClass) {
        boolean result = false;
        if (null != mLogicClassList) {
            for (ApplicationLogicWrapper applicationLogicWrapper : mLogicClassList) {
                if(applicationLogicWrapper.logicClass.equals(logicClass)){
                    throw new RuntimeException(logicClass.getName() + " has registered.");
                }
            }
        mLogicClassList.add(new ApplicationLogicWrapper(logicClass));
        result = true ;
        }
        return result;
    }

    public void route(Context context, RouterRequest routerRequest, RouterCallback callback) {
        LocalRouter.getInstance().route(context, routerRequest, callback);
    }

    public void registerProvider(String providerName, RouterProvider provider) {
        LocalRouter.getInstance().registerProvider(providerName, provider);
    }
}
