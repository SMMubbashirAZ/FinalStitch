package com.example.finalstitch.ui.Mdesigns;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.finalstitch.R;

public class MaledesignsFragment extends Fragment {

    private MaledesignsViewModel mViewModel;
    private Button fk,fm,ff;
    private LinearLayout lf,lm,lk;

    public static MaledesignsFragment newInstance() {
        return new MaledesignsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.maledesigns_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fk=view.findViewById(R.id.mkd);
        fm=view.findViewById(R.id.mmn);
        ff=view.findViewById(R.id.mwmn);
        lf=view.findViewById(R.id.mfemalelayout);
        lm=view.findViewById(R.id.mmanlayout);
        lk=view.findViewById(R.id.mkidlayout);

        fk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lk.setVisibility(View.VISIBLE);
                lm.setVisibility(View.GONE);
                lf.setVisibility(View.GONE);
            }
        });

        fm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lm.setVisibility(View.VISIBLE);
                lk.setVisibility(View.GONE);
                lf.setVisibility(View.GONE);
            }
        });

        ff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lf.setVisibility(View.VISIBLE);
                lm.setVisibility(View.GONE);
                lk.setVisibility(View.GONE);
            }
        });

    }
}
