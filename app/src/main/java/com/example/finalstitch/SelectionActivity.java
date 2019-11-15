package com.example.finalstitch;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class SelectionActivity extends AppCompatActivity {

    SharedPreferences settings;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        getSupportActionBar().hide();

        ShowDialog(SelectionActivity.this);
    }
    public void ShowDialog(Activity activity){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dailoge);


        settings = getSharedPreferences("Gender", MODE_PRIVATE);
        editor = settings.edit();
        Button dialogButton1 = (Button) dialog.findViewById(R.id.male);
        dialogButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.putString("m_le", "male");
                editor.commit();

                startActivity(new Intent(SelectionActivity.this, MaleActivity.class));

            }
        });

        Button dialogButton2 = (Button) dialog.findViewById(R.id.female);
        dialogButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.putString("f_male", "female");
                editor.commit();

                startActivity(new Intent(SelectionActivity.this, MaleActivity.class));
            }
        });

        dialog.show();

    }

}