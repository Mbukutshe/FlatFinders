package com.wiseman.flatfinders;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener,View.OnTouchListener,View.OnClickListener{
    ViewPager viewPager;
    FragmentManager fragmentManager;
    Menu optionUser;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
       // setupViewPager(viewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        //tabLayout.setupWithViewPager(viewPager);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.flat).setText("Flats"));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.house).setText("Houses"));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.question).setText("Questions Asked"));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.pricing).setText("Pricing"));
        tabLayout.setOnTabSelectedListener(this);
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_main,new Flats()).commit();

        ((TextView)findViewById(R.id.close)).setOnTouchListener(this);
        ((TextView)findViewById(R.id.reg)).setOnTouchListener(this);
        ((Button)findViewById(R.id.btnSign)).setOnTouchListener(this);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        switch (tab.getPosition())
        {
            case 0:
                fragmentManager.beginTransaction().replace(R.id.content_main,new Flats()).commit();
                break;
            case 1:
                fragmentManager.beginTransaction().replace(R.id.content_main,new Houses()).commit();
                break;
            case 2:
                fragmentManager.beginTransaction().replace(R.id.content_main,new AskedQuestions()).commit();
                break;
        }

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        this.optionUser = menu;
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        switch(id)
        {
            case R.id.action_settings:
                break;

            case R.id.action_users:
                switch(drawerLayout.getDrawerLockMode(Gravity.RIGHT))
                {
                    case DrawerLayout.LOCK_MODE_LOCKED_CLOSED:
                        Animation animGone = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.translate_down);
                        ((CardView)findViewById(R.id.user_login)).setVisibility(View.VISIBLE);
                        ((CardView)findViewById(R.id.user_login)).requestFocus();
                        ((CardView)findViewById(R.id.user_login)).setClickable(true);
                        ((CardView)findViewById(R.id.user_login)).startAnimation(animGone);
                        ((CardView)findViewById(R.id.user_login)).getBackground().setAlpha(230);
                        ((ScrollView)findViewById(R.id.scroll)).getBackground().setAlpha(0);
                        break;
                    case DrawerLayout.LOCK_MODE_UNLOCKED:
                        drawerLayout.openDrawer(Gravity.RIGHT);
                        break;
                }
            break;
        }
        return super.onOptionsItemSelected(item);
    }
    private void setupViewPager(ViewPager viewPager) {
        viewPagerAdapter adapter = new viewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new Flats(), "Flats");
        adapter.addFrag(new Houses(), "Houses");

        viewPager.setAdapter(adapter);
    }
    class viewPagerAdapter extends FragmentStatePagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public viewPagerAdapter(FragmentManager manager) {
            super(manager);
        }
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public void onBackPressed() {
        if( ((CardView)findViewById(R.id.user_login)).getVisibility()==View.VISIBLE)
        {
            if(((ScrollView)findViewById(R.id.register)).getVisibility()==View.VISIBLE)
            {
                ((ScrollView)findViewById(R.id.scroll)).setVisibility(View.VISIBLE);
                ((ScrollView)findViewById(R.id.register)).setVisibility(View.GONE);

            }
            else
            {
                Animation animGone = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out);
                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.translate_right);
                ((CardView)findViewById(R.id.user_login)).setVisibility(View.GONE);
                ((CardView)findViewById(R.id.user_login)).startAnimation(anim);
                ((CardView)findViewById(R.id.user_login)).startAnimation(animGone);
            }


        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int id = view.getId();
        switch(id)
        {
            case R.id.close:
                Animation animGone = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out);
                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.translate_right);
                ((CardView)findViewById(R.id.user_login)).setVisibility(View.GONE);
                ((CardView)findViewById(R.id.user_login)).startAnimation(anim);
                ((CardView)findViewById(R.id.user_login)).startAnimation(animGone);
                break;
            case R.id.reg:
                ((ScrollView)findViewById(R.id.scroll)).setVisibility(View.GONE);
                ((ScrollView)findViewById(R.id.register)).setVisibility(View.VISIBLE);
                break;
            case R.id.btnSign:
                Animation zoomOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out);
                ((CardView)findViewById(R.id.user_login)).startAnimation(zoomOut);
                ((CardView)findViewById(R.id.user_login)).setVisibility(View.GONE);
                optionUser.getItem(1).setIcon(R.drawable.active);
                //((FloatingActionButton)findViewById(R.id.add)).setVisibility(View.VISIBLE);
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
                break;
        }
        return false;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch(id) {

        }
    }
}
