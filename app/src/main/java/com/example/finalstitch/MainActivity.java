package com.example.finalstitch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.finalstitch.Fragments.HelpsFragment;
import com.example.finalstitch.Fragments.PantsFragment;
import com.example.finalstitch.Fragments.SavedMeasurementFragment;
import com.example.finalstitch.Fragments.ShirtsFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ImageView iv;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
/*    private int[] tabIcons = {
            R.drawable.ic_history_black_24dp,
            R.drawable.ic_help_outline_black_24dp,
            R.drawable.ic_tab_contacts
    };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        int im=getIntent().getIntExtra("two",0);

        iv=findViewById(R.id.main_img);

        if (im==1) {
            iv.setImageResource(R.drawable.lkj);



        }
        else if (im==2) {
            iv.setImageResource(R.drawable.mnb);
        }
        else if(im == 3){
            iv.setImageResource(R.drawable.bnm);
        }
        else if (im == 4){
            iv.setImageResource(R.drawable.tyu);
        }
        else if (im==5){
            iv.setImageResource(R.drawable.zxc);
        }
        else if (im==6){
            iv.setImageResource(R.drawable.cxz);
        }
        else if(im==7){
            iv.setImageResource(R.drawable.iop);
        }
        else{
            iv.setImageResource(R.drawable.poi);
        }
    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new SavedMeasurementFragment(), "History");
        adapter.addFrag(new ShirtsFragment(), "Kurta");
        adapter.addFrag(new PantsFragment(), "Shalwar");
        adapter.addFrag(new HelpsFragment(), "Help");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
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
}
