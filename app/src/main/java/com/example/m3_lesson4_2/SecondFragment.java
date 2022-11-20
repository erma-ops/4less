package com.example.m3_lesson4_2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class SecondFragment extends Fragment {

    TextView tvBigName, tvBigCapitalName;
    ImageView bigFlag;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvBigName = view.findViewById(R.id.tv_big_name);
        tvBigCapitalName = view.findViewById(R.id.tv_big_capital_name);
        bigFlag = view.findViewById(R.id.imv_big_flag);

        if (getArguments() != null) {
            tvBigName.setText(getArguments().getString(MainFragment.NAME_KEY));
            tvBigCapitalName.setText(getArguments().getString(MainFragment.CAPITAL_NAME_KEY));
            Glide.with(bigFlag).load(getArguments().getString(MainFragment.FLAG_KEY)).into(bigFlag);
        }
    }
}