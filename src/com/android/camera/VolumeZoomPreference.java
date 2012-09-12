package com.android.camera;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;

public class VolumeZoomPreference extends IconListPreference {
    
    public static final String KEY = "pref_camera_volumezoom_key";
    
    public static final String VALUE_NONE = "none";
    
    private final ContentResolver mResolver;
    
    public VolumeZoomPreference(Context context, AttributeSet attrs) {
        super(context,attrs);
        mResolver = context.getContentResolver();
    }
    
    @Override
    public String getValue() {
        return get(getSharedPreferences(), mResolver) ? CameraSettings.VALUE_ON : CameraSettings.VALUE_OFF;
    }
    
    public static boolean get(SharedPreferences pref, ContentResolver resolver) {
        String value = pref.getString(KEY, VALUE_NONE);
        return CameraSettings.VALUE_ON.equalsIgnoreCase(value);
    }
}
