package com.nusclimb.live.crimp.qr;

import android.content.Context;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * A subclass of SurfaceView for displaying of camera preview.
 *
 * @author Lin Weizhi (ecc.weizhi@gmail.com)
 *
 */
public class PreviewView extends SurfaceView {
    private static final String TAG = PreviewView.class.getSimpleName();

    public PreviewView(Context context) {
        super(context);
        Log.d(TAG, "Create with context");

        // deprecated setting, but required on Android versions prior to 3.0
        getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }
}