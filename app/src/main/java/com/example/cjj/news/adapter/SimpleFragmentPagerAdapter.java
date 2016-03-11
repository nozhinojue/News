package com.example.cjj.news.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.cjj.news.fragment.PageFragment;


/**
 * Created by CJJ on 2016/2/16.
 */
public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    public static String TIYU_URL="http://apis.baidu.com/txapi/tiyu/tiyu";      //体育新闻
    public static String KEJI_URL="http://apis.baidu.com/txapi/keji/keji";      //科技新闻
    public static String WORLD_URL="http://apis.baidu.com/txapi/world/world";   //国际新闻

    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[]{"体育新闻","科技新闻","国际新闻"};
    private String dataUrl[]=new String[]{TIYU_URL,KEJI_URL,WORLD_URL};
    private Context context;

    public SimpleFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return PageFragment.newInstance(dataUrl[position]);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
