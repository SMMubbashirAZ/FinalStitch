package com.example.finalstitch.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.example.finalstitch.Adapter.SwipAdapter;
import com.example.finalstitch.AdultActivity;
import com.example.finalstitch.BigActivity;
import com.example.finalstitch.CustomActivity;
import com.example.finalstitch.KidsActivity;
import com.example.finalstitch.MainActivity;
import com.example.finalstitch.Model.ImageModel;
import com.example.finalstitch.R;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {

    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private ArrayList<ImageModel> imageModelArrayList;

    private int[] myImageList = new int[]{R.drawable.bf, R.drawable.bnm,
            R.drawable.poi,R.drawable.jkl
            ,R.drawable.em,R.drawable.ded};


    private HomeViewModel homeViewModel;
    private CardView cv1,cv2,cv3,cv4,cv5,cv6,cv7,cv8,cv_adlt,cv_kid,cv_custm;

    Context c;

    private boolean isCountDownTimerActive = false; // let the timer start if and only if it has completed previous task

    private LinearLayout linearLayout;

    private  int custom_point=0;

    View v;

//    private int[] myImageList={R.drawable.poi,R.drawable.fl,R.drawable.fkk,R.drawable.ml,R.drawable.jkl};



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


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        handler = new Handler();
        c=view.getContext();
        imageModelArrayList = new ArrayList<>();
        imageModelArrayList = populateList();

        v=view;

        init();

        cv1=view.findViewById(R.id.c1);
        cv2=view.findViewById(R.id.c2);
        cv3=view.findViewById(R.id.c3);
        cv4=view.findViewById(R.id.c4);
        cv5=view.findViewById(R.id.c5);
        cv6=view.findViewById(R.id.c6);
        cv7=view.findViewById(R.id.c7);

        cv8=view.findViewById(R.id.c8);
        cv_adlt=view.findViewById(R.id.adlt);
        cv_kid=view.findViewById(R.id.kdi);
        cv_custm=view.findViewById(R.id.cstm);

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
        cv_adlt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(v.getContext(), AdultActivity.class);
                i.putExtra("one",8);
                startActivity(i);
            }
        });

        cv_kid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(v.getContext(), KidsActivity.class);
                i.putExtra("one",8);
                startActivity(i);
            }
        });


        cv_custm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(v.getContext(), MainActivity.class);
                i.putExtra("one",8);
                startActivity(i);
            }
        });



    }
    private ArrayList<ImageModel> populateList(){

        ArrayList<ImageModel> list = new ArrayList<>();

        for(int i = 0; i < 6; i++){
            ImageModel imageModel = new ImageModel();
            imageModel.setImage_drawable(myImageList[i]);
            list.add(imageModel);
        }

        return list;
    }
    private void init() {

        mPager = (ViewPager)v. findViewById(R.id.view_pager_slider);
        mPager.setAdapter(new SwipAdapter(c,imageModelArrayList));

        CirclePageIndicator indicator = (CirclePageIndicator)
                v.findViewById(R.id.indicator);

        indicator.setViewPager(mPager);

        final float density = getResources().getDisplayMetrics().density;

//Set circle indicator radius
        indicator.setRadius(5 * density);

        NUM_PAGES =imageModelArrayList.size();

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });

    }

}
