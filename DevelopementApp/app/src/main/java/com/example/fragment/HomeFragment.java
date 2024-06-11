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

import org.jetbrains.annotations.Nullable;

public class HomeFragment extends Fragment {
    private ImageView food_Iv;
    private ImageView lB_iv;
    private ImageView bodyData_iv;
    private ImageView sportPlan_iv;
    private ImageView home_My_iv;
    private ImageView home_Msg_iv;
    private ImageView home_Al_iv;
    private ImageView home_Home_iv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.home, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        food_Iv=view.findViewById(R.id.food_iv);
        lB_iv=view.findViewById(R.id.lb_iv);
        bodyData_iv=view.findViewById(R.id.bodydata_iv);
        sportPlan_iv=view.findViewById(R.id.sportplan_iv);

        home_My_iv=view.findViewById(R.id.home_my_iv);
        home_Msg_iv=view.findViewById(R.id.home_msg_iv);
        home_Al_iv=view.findViewById(R.id.home_al_iv);
        home_Home_iv=view.findViewById(R.id.home_home_iv);




        food_Iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        lB_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        bodyData_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        sportPlan_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        home_Home_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 在 HomeFragment 所属的 Activity 中启动 SettingFragment
                HomeFragment homeFragment = new HomeFragment();
                FragmentTransaction transaction =getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.home_fg, homeFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        home_My_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 在 HomeFragment 所属的 Activity 中启动 SettingFragment
                SettingFragment settingFragment = new SettingFragment();
                FragmentTransaction transaction =getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.home_fg, settingFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        home_Msg_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MessageFragment messageFragment = new MessageFragment();
                FragmentTransaction transaction=getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.home_fg,messageFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        home_Al_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActionLibraryFragment actionLibraryFragment = new ActionLibraryFragment();
                FragmentTransaction transaction=getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.home_fg,actionLibraryFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });



    }


}
