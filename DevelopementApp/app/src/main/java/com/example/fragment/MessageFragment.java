package com.example.fragment;

import static android.app.Activity.RESULT_OK;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.Item.ListItem3;
import com.example.adapter.ListAdapter;
import com.example.adapter.ListAdapter3;
import com.example.myapplication.R;
import com.example.myapplication.Share;
import com.example.myapplication.databinding.MessageBinding;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MessageFragment extends Fragment {
    private MessageBinding binding;
    private List<ListItem3> itemList = new ArrayList<>();
    private ListAdapter3 listAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = MessageBinding.inflate(inflater, container, false);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        listAdapter= new ListAdapter3(requireContext(), R.layout.list_layout3, itemList);
        binding.recyclerView.setAdapter(listAdapter);
        itemList.add(new ListItem3(R.drawable.nemo_background,"1","1",R.drawable.nemo_background));
        binding.msgAddIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Share.class));
            }
        });
        return binding.getRoot();
    }
}
