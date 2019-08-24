package com.example.splash;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class ParallaxContainer extends FrameLayout implements ViewPager.OnPageChangeListener {

    List<ParallaxFragment> fragments;

    public ParallaxContainer(Context context) {
        super(context);
    }

    public ParallaxContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    public void setUp(int... chlidIds) {

        fragments = new ArrayList<>();
        for (int i = 0; i < fragments.size(); i++) {
            ParallaxFragment f = new ParallaxFragment();
            Bundle args = new Bundle();
            args.putInt("layoutId", chlidIds[i]);
            f.setArguments(args);

            fragments.add(f);
        }

        ViewPager vp = new ViewPager(getContext());
        vp.setId(R.id.parallax_pager);

        SplashActivity activity = (SplashActivity) getContext();

        ParallaxPagerAdapter adapter = new ParallaxPagerAdapter(activity.getSupportFragmentManager(), fragments);
        vp.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        vp.setAdapter(adapter);
        addView(vp,0);
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
