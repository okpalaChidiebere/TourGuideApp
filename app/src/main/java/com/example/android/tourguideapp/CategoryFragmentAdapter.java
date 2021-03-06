package com.example.android.tourguideapp;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class CategoryFragmentAdapter extends FragmentPagerAdapter {

    /** Context of the app */
    private Context mContext;

    public CategoryFragmentAdapter(Context context, FragmentManager fm){
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new ResturantFragmet();
        } else if (position == 1){
            return new MuseumFragment();
        } else if(position == 2){
            return new ParkFragment();
        } else{
            return new SportsFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.resturant_category);
            //return null;
        } else if (position == 1) {
            return mContext.getString(R.string.museum_category);
        } else if (position == 2){
            return mContext.getString(R.string.park_category);
        }else {
            return mContext.getString(R.string.sports_category);
        }
    }


}
