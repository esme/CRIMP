package com.nusclimb.live.crimp.hello;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

/**
 * Created by weizhi on 16/7/2015.
 */
public class ClimberIdTextWatcher implements TextWatcher {
    private final String TAG = ClimberIdTextWatcher.class.getSimpleName();
    private ToFragmentInteraction mToFragmentInteraction;

    public ClimberIdTextWatcher(ToFragmentInteraction toFragmentInteraction){
        mToFragmentInteraction = toFragmentInteraction;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Log.v(TAG+".beforeTextChanged()", "CharSequence="+s+", start="+start+", count="+count+", after="+after);
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Log.v(TAG+".onTextChanged()", "CharSequence="+s+", start="+start+", before="+before+", count="+count);
    }

    @Override
    public void afterTextChanged(Editable s) {
        Log.d(TAG + ".afterTextChanged()", "afterTextChanged: "+s.toString());
        mToFragmentInteraction.updateClimberName();
        mToFragmentInteraction.updateNextButton(s.toString().length()==3);
    }

    public interface ToFragmentInteraction {
        public void updateClimberName();
        public void updateNextButton(boolean enable);
    }
}
