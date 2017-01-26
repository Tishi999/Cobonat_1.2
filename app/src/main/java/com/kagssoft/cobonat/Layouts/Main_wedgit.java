package com.kagssoft.cobonat.Layouts;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kagssoft.cobonat.Tabs.SlidingTabLayout;
import com.kagssoft.cobonat.fragments.NavigationDrawerFragment;
import com.kagssoft.cobonat.R;

public class Main_wedgit extends AppCompatActivity {

    private Toolbar toolbar ;
    private ViewPager mPager ;
    private SlidingTabLayout mTabs ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_wedgit);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        NavigationDrawerFragment drawerFragment=(NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer,(DrawerLayout)findViewById(R.id.drawe_layout),toolbar);
       mPager=(ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        mTabs=(SlidingTabLayout)findViewById(R.id.tabs);
        mTabs.setDistributeEvenly(true);
        mTabs.setCustomTabView(R.layout.custom_tab_view,R.id.tabText);
        mTabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.bg_drop_row_dark);
            }
        });
        mTabs.setViewPager(mPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_wedgit, menu);
        return true;
    }

    class MyPagerAdapter extends FragmentPagerAdapter {
        int icons[] = {R.drawable.ic_giftcard,R.drawable.ic_receipt,R.drawable.ic_stars};
        String [] tabsText = getResources().getStringArray(R.array.tabs);

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
            tabsText =getResources().getStringArray(R.array.tabs);
        }

        @Override
        public Fragment getItem(int position) {
            MyFragment myFragment = MyFragment.getInstance(position);
            return myFragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Drawable drawable =getResources().getDrawable(icons[position]);
            drawable.setBounds(0,0,112,112);
            ImageSpan imageSpan =new ImageSpan(drawable);
            SpannableString spannableString = new SpannableString(" ");
            spannableString.setSpan(imageSpan,0,spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            return spannableString;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

    public static class MyFragment extends Fragment {
        private TextView textView ;
        public static MyFragment getInstance(int position) {
            MyFragment myFragment = new MyFragment();
            Bundle args=new Bundle();
            args.putInt("position",position);
            myFragment.setArguments(args);
            return myFragment;
        }


        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View layout = inflater.inflate(R.layout.fragment_my, container, false);
            textView=(TextView)layout.findViewById(R.id.position);
            Bundle bundle=getArguments();

            return layout ;

        }
    }
}
