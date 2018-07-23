package com.huangyuanlove.jandanrxjava;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.view.ViewGroup;

import com.huangyuanlove.jandanrxjava.base.BaseActivity;
import com.huangyuanlove.jandanrxjava.databinding.ActivityMainBinding;
import com.huangyuanlove.jandanrxjava.fragment.GirlsFragment;
import com.huangyuanlove.jandanrxjava.fragment.JokeFragment;
import com.huangyuanlove.jandanrxjava.fragment.NewsFragment;
import com.huangyuanlove.jandanrxjava.fragment.PicsFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding binding;
    private List<String> tabNames = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        tabNames.add("新鲜事");
        tabNames.add("无聊图");
        tabNames.add("妹子图");
        tabNames.add("段子");
        initView();


    }

    private void initView() {
        setSupportActionBar(binding.toolbar);
        binding.toolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white));
        fragmentList.add(new NewsFragment());
        fragmentList.add(new PicsFragment());
        fragmentList.add(new GirlsFragment());
        fragmentList.add(new JokeFragment());
        binding.viewPager.setAdapter(new ContentPagerAdapter(getSupportFragmentManager(), fragmentList, tabNames));
        binding.tabLayout.setupWithViewPager(binding.viewPager);
    }

    class ContentPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragments;
        private List<String> tabNames;
        public ContentPagerAdapter(FragmentManager fm, List<Fragment> fragments, List<String> tabNames) {
            super(fm);
            this.fragments = fragments;
            this.tabNames = tabNames;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabNames == null ?"":tabNames.get(position);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments==null?0:fragments.size();
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
        }
    }

}
