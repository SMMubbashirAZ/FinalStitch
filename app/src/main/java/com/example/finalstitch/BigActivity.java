package com.example.finalstitch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class BigActivity extends AppCompatActivity {

    private ImageView iv;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button o,cd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big);
        int im=getIntent().getIntExtra("one",0);
        iv=findViewById(R.id.img_big);
        o=findViewById(R.id.odr);
        cd=findViewById(R.id.cust_des);
        radioGroup=findViewById(R.id.radioGroup);
        o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(BigActivity.this,MainActivity.class);
                //i.putExtra("two",1);
                startActivity(i);
              /*  int radioId=radioGroup.getCheckedRadioButtonId();

                radioButton=findViewById(radioId);

                if (radioId==0)
                {

                    Toast.makeText(BigActivity.this,"Please Select the size",Toast.LENGTH_LONG).show();

                }

                else
                {
                    Toast.makeText(BigActivity.this,"You have Selected " +radioButton.getText()+"size"+" and your order has been placed",Toast.LENGTH_LONG).show();

                }*/
            }
        });
        if (im==1) {
            iv.setImageResource(R.drawable.lkj);

            cd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(BigActivity.this,MainActivity.class);
                    i.putExtra("two",1);
                    startActivity(i);
                }
            });


        }
        else if (im==2) {
            iv.setImageResource(R.drawable.mnb);

            cd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(BigActivity.this,MainActivity.class);
                    i.putExtra("two",2);
                    startActivity(i);
                }
            });

        }
        else if(im == 3){
            iv.setImageResource(R.drawable.bnm);


            cd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(BigActivity.this,MainActivity.class);
                    i.putExtra("two",3);
                    startActivity(i);
                }
            });

        }
        else if (im == 4){
            iv.setImageResource(R.drawable.tyu);

            cd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(BigActivity.this,MainActivity.class);
                    i.putExtra("two",4);
                    startActivity(i);
                }
            });

        }
        else if (im==5){
            iv.setImageResource(R.drawable.zxc);

            cd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(BigActivity.this,MainActivity.class);
                    i.putExtra("two",5);
                    startActivity(i);
                }
            });

        }
        else if (im==6){
            iv.setImageResource(R.drawable.cxz);

            cd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(BigActivity.this,MainActivity.class);
                    i.putExtra("two",6);
                    startActivity(i);
                }
            });

        }
        else if(im==7){
            iv.setImageResource(R.drawable.iop);

            cd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(BigActivity.this,MainActivity.class);
                    i.putExtra("two",7);
                    startActivity(i);
                }
            });

        }
        else if (im==8){
            iv.setImageResource(R.drawable.poi);

            cd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(BigActivity.this,MainActivity.class);
                    i.putExtra("two",8);
                    startActivity(i);
                }
            });

        }
    }

    public void chk(View view)
    {

        int radioId=radioGroup.getCheckedRadioButtonId();

            radioButton=findViewById(radioId);
            Toast.makeText(BigActivity.this,"You have Selected " +radioButton.getText()+"size",Toast.LENGTH_LONG).show();


    }

}
