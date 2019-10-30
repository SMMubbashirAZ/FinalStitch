package com.example.finalstitch.ui.Orders.FemaleOrder;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finalstitch.MainActivity;
import com.example.finalstitch.R;

public class ForOrderFFragment extends Fragment {

    Context c;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_for_order_f, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       /* Intent i = new Intent(view.getContext(), MainActivity.class);
        startActivity(i);*/
       c=view.getContext();
        ShowDialog(c);
    }
    public void ShowDialog(Context activity){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.nodialoge);


       final EditText ed= dialog.findViewById(R.id.edt_no);

       final String s = ed.getText().toString();
       Button dialogButton1 = (Button) dialog.findViewById(R.id.btn_no);
        dialogButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (s == "")
                {
                    Toast.makeText(c,"Enter Something",Toast.LENGTH_LONG).show();
                }
                else {
                    startActivity(new Intent(c, MainActivity.class));

                }

            }
        });
/*
        Button dialogButton2 = (Button) dialog.findViewById(R.id.female);
        dialogButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SelectionActivity.this, FemaleActivity.class));
            }
        });*/

        dialog.show();

    }

}
