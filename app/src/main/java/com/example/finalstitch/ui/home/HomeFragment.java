package com.example.finalstitch.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.example.finalstitch.Adapter.CustomViewPagerAdapter;
import com.example.finalstitch.BigActivity;
import com.example.finalstitch.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private CardView cv1,cv2,cv3,cv4,cv5,cv6,cv7,cv8;
    private static final long SLIDER_TIMER = 2000; // change slider interval
    private int currentPage = 0; // this will tell us the current page available on the view pager
    // please see ViewPager Listener on the onPageSelected method to see how we are updating
    // currentPage variable

    private boolean isCountDownTimerActive = false; // let the timer start if and only if it has completed previous task


    private Handler handler;
    private ViewPager viewPager;

    private final Runnable runnable = new Runnable() {
        @Override
        public void run() {

            if (!isCountDownTimerActive) {
                automateSlider();
            }

            handler.postDelayed(runnable, 1000);
            // our runnable should keep running for every 1000 milliseconds (1 seconds)
        }
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        /*final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }
    private void automateSlider() {
        isCountDownTimerActive = true;
        new CountDownTimer(SLIDER_TIMER, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {

                int nextSlider = currentPage + 1;

                // remember view pager pages, starts from 0
                // our maximum page is: 2 because we have 3 sliders

                if (nextSlider == 3) {
                    nextSlider = 0; // if it's last Image, let it go to the first image
                }

                viewPager.setCurrentItem(nextSlider);
                isCountDownTimerActive = false;
            }
        }.start();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        handler = new Handler();

        handler.postDelayed(runnable, 1000);
        runnable.run();

        viewPager = view.findViewById(R.id.view_pager_slider);
        CustomViewPagerAdapter viewPagerAdapter = new CustomViewPagerAdapter(getFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);

        cv1=view.findViewById(R.id.c1);
        cv2=view.findViewById(R.id.c2);
        cv3=view.findViewById(R.id.c3);
        cv4=view.findViewById(R.id.c4);
        cv5=view.findViewById(R.id.c5);
        cv6=view.findViewById(R.id.c6);
        cv7=view.findViewById(R.id.c7);
        cv8=view.findViewById(R.id.c8);

        cv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(v.getContext(), BigActivity.class);
                i.putExtra("one",1);
                startActivity(i);
            }
        });
        cv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(v.getContext(), BigActivity.class);
                i.putExtra("one",2);
                startActivity(i);
            }
        });
        cv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(v.getContext(), BigActivity.class);
                i.putExtra("one",3);
                startActivity(i);
            }
        });
        cv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(v.getContext(), BigActivity.class);
                i.putExtra("one",4);
                startActivity(i);
            }
        });
        cv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(v.getContext(), BigActivity.class);
                i.putExtra("one",5);
                startActivity(i);
            }
        });
        cv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(v.getContext(), BigActivity.class);
                i.putExtra("one",6);
                startActivity(i);
            }
        });
        cv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(v.getContext(), BigActivity.class);
                i.putExtra("one",7);
                startActivity(i);
            }
        });
        cv8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(v.getContext(), BigActivity.class);
                i.putExtra("one",8);
                startActivity(i);
            }
        });



        // now it's time to think about our sliders


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    currentPage = 0;
                } else if (position == 1) {
                    currentPage = 1;
                } else {
                    currentPage = 2;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



    }


}
