package com.nusclimb.live.crimp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.nusclimb.live.crimp.hello.HelloActivity;
import com.nusclimb.live.crimp.hello.RouteFragment;
import com.nusclimb.live.crimp.hello.ScanFragment;
import com.nusclimb.live.crimp.hello.ScoreFragment;

/**
 * Created by user on 03-Jul-15.
 */
public class CrimpFragmentPagerAdapter extends FragmentPagerAdapter {
    private final String TAG = CrimpFragmentPagerAdapter.class.getSimpleName();

    private int crimpInternalCount;
    private HelloActivity mActivity;
    private int _count = 3;

    public CrimpFragmentPagerAdapter(FragmentManager fm, HelloActivity mActivity) {
        super(fm);
        this.mActivity = mActivity;
    }

    @Override
    public Fragment getItem(int i) {
        // This method name is misleading. This method will be call when
        // FragmentPagerAdapter needs an item and it does not exist. This
        // method instantiate the item.
        switch (i) {
            case 0:
                RouteFragment mRouteFragment = new RouteFragment();

                return mRouteFragment;

            case 1:
                ScanFragment mScanFragment = new ScanFragment();

                return mScanFragment;

            case 2:
                ScoreFragment mScoreFragment = new ScoreFragment();

                return mScoreFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        // TODO make this dynamic
        return _count;
    }


    public void set_count(int i){
        Log.d(TAG+".set_count()", "Set _count = "+i);

        _count = i;
        notifyDataSetChanged();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case 0:
                return "Route";
            case 1:
                return "Scan";
            case 2:
                return "Score";
            default:
                return null;
        }
    }


}