package com.spinytech.macore;

import java.util.HashMap;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by wanglei on 2016/12/27.
 */

public class RouterRequest {
    private static final String TAG = "RouterRequest";

    private String provider;
    private String action;
    private HashMap data;

    public RouterRequest() {
        this.provider = "";
        this.action = "";
        this.data = new HashMap<>();
    }

    public String getProvider() {
        return provider;
    }

    public String getAction() {
        return action;
    }

    public HashMap getData() {
        return data;
    }


    @Override
    public String toString() {
        //Here remove Gson to save about 10ms.
        //String result = new Gson().toJson(this);
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("provider", provider);
            jsonObject.put("action", action);

            try {
                JSONObject jsonData = new JSONObject();
                Set keySet = data.keySet();
                for (Object key :  keySet) {
                    jsonData.put(key.toString(),data.get(key));
                }
                jsonObject.put("data", jsonData);
            } catch (Exception e) {
                e.printStackTrace();
                jsonObject.put("data", "{}");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject.toString();
    }

    public RouterRequest provider(String provider) {
        this.provider = provider;
        return this;
    }

    public RouterRequest action(String action) {
        this.action = action;
        return this;
    }

    public RouterRequest data(String key, Object data) {
        this.data.put(key, data);
        return this;
    }
}
