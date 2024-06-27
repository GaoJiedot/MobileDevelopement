package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Item.ListItem;
import com.example.adapter.ListAdapter;
import com.example.myapplication.Action;
import com.example.myapplication.R;
import com.example.myapplication.databinding.ActionlibraryBinding;

import java.util.ArrayList;
import java.util.List;

public class ActionLibrary extends AppCompatActivity implements ListAdapter.OnListItemClickListener {
    private String[] data = {"全部运动", "胸部", "手臂", "背部", "腿部", "臀部"};
    private List<ListItem> itemList = new ArrayList<>();
    private List<ListItem> filteredItemList = new ArrayList<>();
    private ActionlibraryBinding binding;
    private ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActionlibraryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.list_layout1, data);
        binding.alLv.setAdapter(arrayAdapter);

        populateItemList();

        listAdapter = new ListAdapter(this, R.layout.list_layout2, filteredItemList, this);
        binding.alLv2.setAdapter(listAdapter);

        binding.alLv.setOnItemClickListener((parent, view, position, id) -> {
            String selectedCategory = data[position];
            filterItemList(selectedCategory);
        });

        // Show all items initially
        filterItemList("全部运动");

        binding.alBackIv.setOnClickListener(v -> finish());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
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
        Intent intent = new Intent(this, Action.class);
        intent.putExtra("itemName", item.getName());
        startActivity(intent);
    }
}