package com.example.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.Item.ListItem;
import com.example.adapter.ListAdapter;
import com.example.myapplication.Action;
import com.example.myapplication.R;
import com.example.myapplication.databinding.ActionlibraryBinding;

import java.util.ArrayList;
import java.util.List;

public class ActionLibraryFragment extends Fragment implements ListAdapter.OnListItemClickListener {
    private String[] data = {"全部运动", "胸部", "手臂", "背部", "腿部", "臀部"};
    private List<ListItem> itemList = new ArrayList<>();
    private List<ListItem> filteredItemList = new ArrayList<>();
    private ActionlibraryBinding binding;
    private ListAdapter listAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = ActionlibraryBinding.inflate(inflater, container, false);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(requireContext(), R.layout.list_layout1, data);
        binding.alLv.setAdapter(arrayAdapter);

        populateItemList();

        listAdapter = new ListAdapter(requireContext(), R.layout.list_layout2, filteredItemList, this);
        binding.alLv2.setAdapter(listAdapter);

        binding.alLv.setOnItemClickListener((parent, view, position, id) -> {
            String selectedCategory = data[position];
            filterItemList(selectedCategory);
        });

        // Show all items initially
        filterItemList("全部运动");

        View view = binding.getRoot();
        binding.alBackIv.setOnClickListener(v -> {
            if (getActivity() != null) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Prevent memory leaks
        binding = null;
    }

    private void populateItemList() {
        // Add your items to itemList here
        itemList.add(new ListItem(R.drawable.nemo_background, "俯卧撑", "肱三头肌·胸肌中下束", "手臂"));
        itemList.add(new ListItem(R.drawable.nemo_background, "扩胸", "肱三头肌·胸肌中下束", "胸部"));
        itemList.add(new ListItem(R.drawable.nemo_background, "蜘蛛俯卧撑", "肱三头肌·胸肌中下束", "胸部"));
        itemList.add(new ListItem(R.drawable.nemo_background, "钻石俯卧撑", "肱三头肌·胸肌中下束", "手臂"));
        itemList.add(new ListItem(R.drawable.nemo_background, "蛙泳划臂", "斜方肌中下束·背阔肌", "背部"));
        itemList.add(new ListItem(R.drawable.nemo_background, "俯身Y字伸展", "肩后束·斜方肌上束", "背部"));
        itemList.add(new ListItem(R.drawable.nemo_background, "深蹲", "腿部股四头肌·臀大肌", "腿部"));
        itemList.add(new ListItem(R.drawable.nemo_background, "交替侧弓步", "股四头肌·臀大肌", "腿部"));
        itemList.add(new ListItem(R.drawable.nemo_background, "臀桥", "臀大肌·臀中肌", "臀部"));
        itemList.add(new ListItem(R.drawable.nemo_background, "小燕飞", "竖脊肌·臀大肌", "臀部"));

        // Add more items as needed
    }

    private void filterItemList(String category) {
        filteredItemList.clear();
        if (category.equals("全部运动")) {
            filteredItemList.addAll(itemList);
        } else {
            for (ListItem item : itemList) {
                if (item.getKind().equals(category)) {
                    filteredItemList.add(item);
                }
            }
        }

        listAdapter.notifyDataSetChanged();
    }

    @Override
    public void onListItemClick(ListItem item) {
        Intent intent = new Intent(getActivity(), Action.class);
        intent.putExtra("itemName", item.getName());
        startActivity(intent);
    }
}
