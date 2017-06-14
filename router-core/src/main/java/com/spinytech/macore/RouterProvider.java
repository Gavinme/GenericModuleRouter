package com.spinytech.macore;

import java.util.HashMap;

/**
 * Created by wanglei on 2016/11/29.
 */

public abstract class RouterProvider {
    //TODO this field is used for control the provider on and off
    private boolean mValid = true;
    private HashMap<String,RouterAction> mActions;
    public RouterProvider(){
        mActions = new HashMap<>();
        registerActions();
    }
    protected void registerAction(String actionName,RouterAction action){
        mActions.put(actionName,action);
    }

    public RouterAction findAction(String actionName){
        return mActions.get(actionName);
    }

    public boolean isValid(){
        return mValid;
    }

    protected abstract void registerActions();
}
