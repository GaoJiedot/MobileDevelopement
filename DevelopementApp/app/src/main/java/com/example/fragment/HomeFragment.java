package com.example.fragment;

import android.media.MediaMetadata;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.R;
import com.example.myapplication.databinding.HomeBinding;

import org.jetbrains.annotations.Nullable;

public class HomeFragment extends Fragment {
    private HomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = HomeBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);





        binding.foodIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        binding.lbIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        binding.bodydataIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        binding.sportplanIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        binding.homeHomeIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 在 HomeFragment 所属的 Activity 中启动 SettingFragment
                HomeFragment homeFragment = new HomeFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.home_fg, homeFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        binding.homeMyIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 在 HomeFragment 所属的 Activity 中启动 SettingFragment
                SettingFragment settingFragment = new SettingFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.home_fg, settingFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        binding.homeMsgIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MessageFragment messageFragment = new MessageFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.home_fg, messageFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        binding.homeAlIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActionLibraryFragment actionLibraryFragment = new ActionLibraryFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.home_fg, actionLibraryFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });


    }


}
