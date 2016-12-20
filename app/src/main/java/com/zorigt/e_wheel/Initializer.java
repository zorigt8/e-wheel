package com.zorigt.e_wheel;

import android.app.Application;

import com.vungle.publisher.VunglePub;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Zorigt on 12/11/16.
 */

public class Initializer extends Application{


    private String mGlobalVarValue;
    private JSONObject primary = new JSONObject();
    private JSONObject secondary = new JSONObject();
    // get the VunglePub instance
    final VunglePub vunglePub = VunglePub.getInstance();



    public String getGlobalVarValue() {
        return mGlobalVarValue;
    }

    public void setGlobalVarValue(String str) {
        mGlobalVarValue = str;
    }

    public void initPrimary() {
        try {
            primary.put("happy", false);
            primary.put("sad", false);
            primary.put("anger", false);
            primary.put("fear", false);
            primary.put("surprise", false);
            primary.put("disgust", false);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public boolean setPrimary(String str) {
        try {
            if (primary.getBoolean(str) == false) {
                primary.put(str, true);
                return true;
            } else {
                primary.put(str, false);
                return false;
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }

    public boolean getPrimary(String str) {
        try {
            if (primary.getBoolean(str) == false) {
                return false;
            } else {
                return true;
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }

    public void initSecondary() {
        try {
            secondary.put("joyful", false);
            secondary.put("liberated", false);
            secondary.put("ecstatic", false);
            secondary.put("proud", false);
            secondary.put("important", false);
            secondary.put("confident", false);
            secondary.put("startled", false);
            secondary.put("shocked", false);
            secondary.put("dismayed", false);
            secondary.put("excited", false);
            secondary.put("eager", false);
            secondary.put("energetic", false);
            secondary.put("humiliated", false);
            secondary.put("ridiculed", false);
            secondary.put("disrespected", false);
            secondary.put("hurt", false);
            secondary.put("devastated", false);
            secondary.put("embarrassed", false);
            secondary.put("disapproval", false);
            secondary.put("judgemental", false);
            secondary.put("loathing", false);
            secondary.put("guilty", false);
            secondary.put("remorseful", false);
            secondary.put("ashamed", false);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void setSecondary(String str) {
        try {
                secondary.put(str, true);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void unsetSecondary(String str) {
        try {
            secondary.put(str, false);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public boolean getSecondary(String str) {
        try {
            return secondary.getBoolean(str);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }


    public JSONObject getSecondaryJson() {
        return secondary;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // get your App ID from the app's main page on the Vungle Dashboard after setting up your app
        final String app_id = "58542b8f49704450630001b8";

        // initialize the Publisher SDK
        vunglePub.init(this, app_id);


    }

}
