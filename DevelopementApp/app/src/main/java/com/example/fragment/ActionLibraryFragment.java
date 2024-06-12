package com.example.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActionlibraryBinding;

public class ActionLibraryFragment extends Fragment {
    private ActionlibraryBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       binding=ActionlibraryBinding.inflate(getLayoutInflater());
       return binding.getRoot();

    }
}
