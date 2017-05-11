package com.prolink.loundry;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Lenovo on 28-May-16.
 */
public class mainfragment extends Fragment{
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewGroup view;

    @Nullable //
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    view = (ViewGroup)inflater.inflate(R.layout.main_fragment, container, false);

        viewPager=(ViewPager)view.findViewById(R.id.viewpager);
        viewPager.setAdapter(new CustomAdapter(getFragmentManager(),getActivity()));

        tabLayout=(TabLayout)view.findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
        });

        return  view;

    }


    private class CustomAdapter extends FragmentPagerAdapter {
        private String fragments[]={"Male","Female","Others"};
        public CustomAdapter(FragmentManager supportFragmentManager, Context applicationContext) {
            super (supportFragmentManager);

        }

        @Override
        public Fragment getItem(int position) {
            switch(position){
                case 0:
                    return new Tab2_Laundary_service();
                case 1:
                    return new Tab3_Female_service();
                case 2:
                    return new Tab4_Others_service();
                default:
                    return null;
            }

        }

        @Override
        public int getCount() {
            return fragments.length;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return fragments[position];
        }


    }
}























//package com.prolink.loundry;
//
//import android.content.Context;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.design.widget.TabLayout;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentPagerAdapter;
//import android.support.v4.view.PagerAdapter;
//import android.support.v4.view.ViewPager;
//import android.support.v7.app.AppCompatActivity;
//import android.util.AttributeSet;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
///**
// * Created by Lenovo on 30-May-16.
// */
//public class mainfragment extends Fragment {
//
//
//     TabLayout tabLayout;
//     ViewPager viewPager;
//    public static int int_items = 3 ;
//
//
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View x = inflater.inflate(R.layout.main_fragment, null);
//
//        tabLayout = (TabLayout) x.findViewById(R.id.tablayout);
//        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                viewPager.setCurrentItem(tab.getPosition());
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//                viewPager.setCurrentItem(tab.getPosition());
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//                viewPager.setCurrentItem(tab.getPosition());
//            }
//        });
//        viewPager = (ViewPager) x.findViewById(R.id.viewpager);
//
//        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
//        tabLayout.post(new Runnable() {
//            @Override
//            public void run() {
//                tabLayout.setupWithViewPager(viewPager);
//            }
//        });
//        return x;
//    }
//
//    private class MyAdapter extends FragmentPagerAdapter {
//
//
//        public MyAdapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            switch (position){
//                case 0 : return new fragment1();
//                case 1 : return new fragment2();
//                case 2 : return new fragment3();
//            }
//            return null;
//        }
//
//        @Override
//        public int getCount() {
//            return int_items;
//        }
//
//        @Override
//        public CharSequence getPageTitle(int position) {
//            switch (position){
//                case 0 :
//                    return "Male";
//                case 1 :
//                    return "Female";
//                case 2 :
//                    return "Others";
//            }
//            return null;
//        }
//        }
//    }
//
//    /* @Override
//     protected void onCreate( Bundle savedInstanceState) {
//         super.onCreate(savedInstanceState);
//         setContentView(R.layout.main_fragment);
//         viewPager=(ViewPager)findViewById(R.id.viewpager);
//         viewPager.setAdapter(new CustomAdapter(getSupportFragmentManager(),getApplicationContext()));
//
//         tabLayout=(TabLayout)findViewById(R.id.tablayout);
//         tabLayout.setupWithViewPager(viewPager);
//         tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//             @Override
//             public void onTabSelected(TabLayout.Tab tab) {
//                 viewPager.setCurrentItem(tab.getPosition());
//             }
//
//             @Override
//             public void onTabUnselected(TabLayout.Tab tab) {
//                 viewPager.setCurrentItem(tab.getPosition());
//             }
//
//             @Override
//             public void onTabReselected(TabLayout.Tab tab) {
//                 viewPager.setCurrentItem(tab.getPosition());
//             }
//         });
//     }
//    private class MyAdapter extends FragmentPagerAdapter {
//        private String fragments[] = {"Male", "Female", "Others"};
//
//        public MyAdapter(FragmentManager supportFragmentManager, Context applicationContext) {
//            super(supportFragmentManager);
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            switch (position) {
//                case 0:
//                    return new fragment1();
//                case 1:
//                    return new fragment2();
//                case 2:
//                    return new fragment3();
//                default:
//                    return null;
//            }
//        }
//
//        @Override
//        public int getCount() {
//            return fragments.length;
//        }
//
//        @Override
//        public CharSequence getPageTitle(int position) {
//            return fragments[position];
//        }
//
//
//    }*/
//
//
