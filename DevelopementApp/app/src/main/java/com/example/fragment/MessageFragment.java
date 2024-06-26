package com.example.fragment;

import static android.app.Activity.RESULT_OK;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.Item.ListItem3;
import com.example.adapter.ListAdapter3;
import com.example.myapplication.R;
import com.example.myapplication.Share;
import com.example.myapplication.databinding.MessageBinding;
import com.example.service.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MessageFragment extends Fragment {
    private static final int REQUEST_NEW_POST = 1;
    private MessageBinding binding;
    private List<ListItem3> itemList = new ArrayList<>();
    private ListAdapter3 listAdapter;
    private ApiService apiService;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://your-api-base-url/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = MessageBinding.inflate(inflater, container, false);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        listAdapter = new ListAdapter3(requireContext(), R.layout.list_layout3, itemList);
        binding.recyclerView.setAdapter(listAdapter);

        binding.msgAddIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Share.class);
                startActivityForResult(intent, REQUEST_NEW_POST);  // 修改这里
            }
        });

        // 设置长按删除监听器
        listAdapter.setOnItemLongClickListener((view, position) -> {
            new AlertDialog.Builder(requireContext())
                    .setTitle("删除帖子")
                    .setMessage("确定要删除这条帖子吗？")
                    .setPositiveButton("确定", (dialog, which) -> {
                        listAdapter.removeItem(position);
                    })
                    .setNegativeButton("取消", null)
                    .show();
            return true;
        });

        return binding.getRoot();
    }

    // 处理新帖子的返回结果
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_NEW_POST && resultCode == RESULT_OK && data != null) {
            ListItem3 newPost = data.getParcelableExtra("newPost");
            if (newPost != null) {
                listAdapter.addItem(newPost);  // 使用适配器的 addItem 方法
                binding.recyclerView.scrollToPosition(0);
            }
        }
    }
}