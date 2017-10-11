package com.javasilev.testtask.ui;

import android.os.PersistableBundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.javasilev.testtask.R;
import com.javasilev.testtask.adapters.MainPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    public static final String KEY = "CardsFragment";

    @BindView(R.id.activity_main_viewpager)
    ViewPager mViewPager;

    @BindView(R.id.activity_main_tabs)
    TabLayout mTabLayout;

    private CardsFragment mCardsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (null != savedInstanceState) {
            mCardsFragment = (CardsFragment) getSupportFragmentManager().getFragment(savedInstanceState, KEY);
        } else {
            mCardsFragment = new CardsFragment();
        }

        MainPagerAdapter adapter = new MainPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(mCardsFragment, getString(R.string.label_tab_cards));
        adapter.addFragment(new InfoFragment(), getString(R.string.label_tab_contacts));

        mViewPager.setAdapter(adapter);

        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        getSupportFragmentManager().putFragment(outState, KEY, mCardsFragment);
    }
}
