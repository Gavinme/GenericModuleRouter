package com.spinytech.macore;


/**
 * Created by wanglei on 2016/11/25.
 */

public class ApplicationLogicWrapper {

    public Class<? extends BaseApplicationLogic> logicClass = null;
    public BaseApplicationLogic instance;

    public ApplicationLogicWrapper(Class<? extends BaseApplicationLogic> logicClass) {
        this.logicClass = logicClass;
    }
}
