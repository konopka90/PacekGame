package com.ganjastudio.pacekgame;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class WikiItemActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wiki_item);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Intent intent = this.getIntent();
        String title = intent.getStringExtra("title");

        String[] wikiItems = getResources().getStringArray(R.array.wiki_array);

        toolbar.setTitle(title);

        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), title);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private String title;
        private int size;

        public SectionsPagerAdapter(FragmentManager fm, String title) {
            super(fm);
            this.title = title;

            int images_id = WikiItemActivity.this.getResources().getIdentifier("packopedia_array_images_"+title.toLowerCase(), "array", "com.ganjastudio.pacekgame");
            TypedArray images = WikiItemActivity.this.getResources().obtainTypedArray(images_id);
            size = images.length();
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1, title);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return size;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        private static final String ARG_TITLE = "title";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber, String title) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            args.putString(ARG_TITLE, title);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            int sectionNumber = this.getArguments().getInt(ARG_SECTION_NUMBER)-1;
            String title = this.getArguments().getString(ARG_TITLE);
            Log.println(Log.DEBUG, "packopedia", "title = " + "packopedia_array_images_"+title.toLowerCase());


            int images_id = this.getResources().getIdentifier("packopedia_array_images_"+title.toLowerCase(), "array", "com.ganjastudio.pacekgame");
            TypedArray images = this.getResources().obtainTypedArray(images_id);

            int strings_id = this.getResources().getIdentifier("packopedia_array_strings_"+title.toLowerCase(), "array", "com.ganjastudio.pacekgame");
            String[] strings = this.getResources().getStringArray(strings_id);


            View rootView = inflater.inflate(R.layout.fragment_wiki_item, container, false);
            ImageView image = (ImageView) rootView.findViewById(R.id.imageView);

            image.setImageDrawable(images.getDrawable(sectionNumber));

            TextView textView = (TextView) rootView.findViewById(R.id.textView);
            textView.setText( strings[sectionNumber]);

            return rootView;
        }
    }
}
