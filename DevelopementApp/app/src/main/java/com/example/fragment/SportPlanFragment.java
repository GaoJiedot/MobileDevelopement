package com.example.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.databinding.SportPlanBinding;

public class SportPlanFragment extends Fragment {

    private SportPlanBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=SportPlanBinding.inflate(getLayoutInflater());
        View view= binding.getRoot();
        binding.spBackIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity()!=null){
                    getActivity().getSupportFragmentManager().popBackStack();
                }
            }
        });
        return view;
    }public void onDestroyView() {
        super.onDestroyView();
        // 防止内存泄漏
        binding = null;
    }
}