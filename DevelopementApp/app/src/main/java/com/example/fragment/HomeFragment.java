package com.example.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.Activity.BodyData;
import com.example.Activity.CookBook;
import com.example.Activity.SportPlan;
import com.example.myapplication.R;
import com.example.myapplication.databinding.HomeBinding;

import org.jetbrains.annotations.Nullable;

import javax.security.auth.callback.Callback;

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
        binding.foodIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        binding.bodydataIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BodyData.class);
                getActivity().startActivity(intent);
            }
        });
        binding.sportplanIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SportPlan.class);
                getActivity().startActivity(intent);
            }
        });


    }


}
