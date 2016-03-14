package com.example.cjj.news.fragment;


import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.cjj.news.R;
import com.example.cjj.news.adapter.SimpleFragmentPagerAdapter;


public class NewsFragment extends BaseFragment {
    private SimpleFragmentPagerAdapter mPagerAdapter;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected int setLayoutResourceId() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initViews(View view) {
        mPagerAdapter = new SimpleFragmentPagerAdapter(getChildFragmentManager(), getContext());

        mTabLayout = (TabLayout) view.findViewById(R.id.tabLayout_newsFg);
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);//tab均分,适合少的tab,TabLayout.GRAVITY_CENTER
        //tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);//适合很多tab
        //tabLayout.setTabMode(TabLayout.MODE_FIXED);//tab均分,适合少的tab

        mViewPager= (ViewPager) view.findViewById(R.id.viewPager_newsFg);
        mViewPager.setOffscreenPageLimit(4);    // 设置缓存多少个 Tab对应的 fragment
        mViewPager.setAdapter(mPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

}
