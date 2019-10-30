package com.example.finalstitch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.github.ybq.android.spinkit.SpinKitView;
import com.github.ybq.android.spinkit.style.Wave;

public class SplashActivity extends AppCompatActivity {

    private RelativeLayout lgu;
    //private ImageView pnk, blue;
    private SpinKitView spin;
    private  int mProgressStatus=0;
    private Handler mHandler = new Handler();


    private Wave mWaveDrawable;

    ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        ///pnk=findViewById(R.id.pink);


        mWaveDrawable = new Wave();

        //spin.setIndeterminateDrawable(mWaveDrawable);

        //blue=findViewById(R.id.blue);
        //lgu=findViewById(R.id.logo);
        // spin=findViewById(R.id.spin_kit);
        Animation magic3= AnimationUtils.loadAnimation(this,R.anim.magic3);

        // lgu.setVisibility(View.VISIBLE);

        final Animation magic5= AnimationUtils.loadAnimation(this,R.anim.magic3);


        Animation magic4= AnimationUtils.loadAnimation(this,R.anim.magic4);


        // pnk.startAnimation(magic3);
        // blue.startAnimation(magic4);
        new Thread(new Runnable() {
            @Override
            public void run() {

                // lgu.setVisibility(View.VISIBLE);
                // lgu.startAnimation(magic5);
                while (mProgressStatus < 100){


                    mProgressStatus++;

                    android.os.SystemClock.sleep(50);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {


                            //pb.setProgress(mProgressStatus);
                            //.setIndeterminateDrawable(mWaveDrawable);

                            // lgu.startAnimation(magic5);


                        }
                    });
                }
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        final Intent t=new Intent(SplashActivity.this,SelectionActivity.class);
                        Thread timer =new Thread(){
                            public void run ()
                            {
                                try {
                                    sleep(500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                finally {
                                    startActivity( t);
                                    finish();
                                }

                            }
                        };
                        timer.start();
                    }
                });
            }
        }).start();
    }
}
