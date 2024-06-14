package com.example.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.databinding.SettingBinding;

public class SettingFragment extends Fragment {
    private SettingBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = SettingBinding.inflate(getLayoutInflater());

      binding.jksj.setOnClickListener(v -> navigateToFragment(new BodyDataFragment()));
      binding.stsjSet.setOnClickListener(v -> navigateToFragment(new BodyDataFragment()));

        return binding.getRoot();
    }

    private void navigateToFragment(Fragment fragment) {
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fg, fragment)
                .addToBackStack(null)
                .commit();

    }
}
