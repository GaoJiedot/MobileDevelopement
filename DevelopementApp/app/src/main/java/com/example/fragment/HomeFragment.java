package com.example.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.Item.ListItem2;
import com.example.adapter.ListAdapter2;
import com.example.myapplication.Action;

import com.example.myapplication.R;
import com.example.myapplication.databinding.HomeBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeFragment extends Fragment {
    private HomeBinding binding;
    private List<ListItem2> itemList = new ArrayList<>();
    private ListAdapter2 listAdapter;
    private EditText inputEditText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = HomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        inputEditText = binding.editText3;

        view.findViewById(R.id.searchBtn).setOnClickListener(v -> {
            String inputText = inputEditText.getText().toString().trim();

            if (inputText.isEmpty()) {
                Toast.makeText(getActivity(), "请输入内容", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!Arrays.asList("俯卧撑","蜘蛛俯卧撑","扩胸","钻石俯卧撑","蛙泳划臂","俯身Y字伸展","深蹲","交替侧弓步","臀桥","小燕飞").contains(inputText)) {
                Toast.makeText(getActivity(), "没有匹配的页面", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(getActivity(), Action.class);

            intent.putExtra("inputText", inputText);
            startActivity(intent);

        });

        populateItemList2();
        listAdapter = new ListAdapter2(requireContext(), R.layout.list_layout2, itemList);
        binding.homeList.setAdapter(listAdapter);


        binding.lbIv.setOnClickListener(v -> navigateToFragment(new ActionLibraryFragment()));
        binding.foodIv.setOnClickListener(v -> navigateToFragment(new CookBookFragment()));
        binding.bodydataIv.setOnClickListener(v -> navigateToFragment(new BodyDataFragment()));
        binding.sportplanIv.setOnClickListener(v -> navigateToFragment(new SportPlanFragment()));
    }

    private void navigateToFragment(Fragment fragment) {
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fg, fragment)
                .addToBackStack(null)
                .commit();
    }

    private void populateItemList2() {
        itemList.add(new ListItem2(R.drawable.nemo_background, "腹肌撕裂2022", "斯帕奇健身官方课"));
        itemList.add(new ListItem2(R.drawable.nemo_background, "手臂撕裂者", "斯帕奇健身官方课"));
        itemList.add(new ListItem2(R.drawable.nemo_background, "帕梅拉15分钟快乐舞", "跳的很轻松，汗也很"));
        itemList.add(new ListItem2(R.drawable.nemo_background, "帕梅拉10分钟挥汗舞蹈", "帕梅拉"));
        itemList.add(new ListItem2(R.drawable.nemo_background, "帕梅拉10分钟挥汗舞蹈", "帕梅拉"));
        itemList.add(new ListItem2(R.drawable.nemo_background, "帕梅拉10分钟挥汗舞蹈", "帕梅拉"));
        itemList.add(new ListItem2(R.drawable.nemo_background, "帕梅拉10分钟挥汗舞蹈", "帕梅拉"));


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
