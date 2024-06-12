package com.example.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.Item.ListItem;
import com.example.adapter.ListAdapter;
import com.example.myapplication.R;
import com.example.myapplication.databinding.ActionlibraryBinding;

import java.util.ArrayList;
import java.util.List;

public class ActionLibraryFragment extends Fragment {
    private String[] data = {"全部运动", "胸部", "手臂", "背部", "腿部", "臀部"};
    private List<ListItem> itemList = new ArrayList<>();
    private List<ListItem> filteredItemList = new ArrayList<>();
    private ActionlibraryBinding binding;
    private ListAdapter listAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = ActionlibraryBinding.inflate(inflater, container, false);

        // Set up ArrayAdapter for the first ListView
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(requireContext(), R.layout.list_layout1, data);
        binding.alLv.setAdapter(arrayAdapter);

        // Populate itemList with sample data
        populateItemList();

        // Set up custom ListAdapter for the second ListView
        listAdapter = new ListAdapter(requireContext(), R.layout.list_layout2, filteredItemList);
        binding.alLv2.setAdapter(listAdapter);

        // Set up item click listener for the first ListView
        binding.alLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedCategory = data[position];
                filterItemList(selectedCategory);
            }
        });

        // Show all items initially
        filterItemList("全部运动");

        return binding.getRoot();
    }

    private void populateItemList() {
        // Add your items to itemList here
        itemList.add(new ListItem(R.drawable.nemo_background, "Item 1", "胸部"));
        itemList.add(new ListItem(R.drawable.nemo_background, "Item 2", "手臂"));
        itemList.add(new ListItem(R.drawable.nemo_background, "Item 3", "背部"));
        itemList.add(new ListItem(R.drawable.nemo_background, "Item 4", "腿部"));
        itemList.add(new ListItem(R.drawable.nemo_background, "Item 5", "臀部"));
        itemList.add(new ListItem(R.drawable.nemo_background, "Item 6", "胸部"));
        itemList.add(new ListItem(R.drawable.nemo_background, "Item 6", "胸部"));
        itemList.add(new ListItem(R.drawable.nemo_background, "Item 6", "胸部"));
        itemList.add(new ListItem(R.drawable.nemo_background, "Item 6", "胸部"));
        itemList.add(new ListItem(R.drawable.nemo_background, "Item 6", "胸部"));
        itemList.add(new ListItem(R.drawable.nemo_background, "Item 6", "胸部"));
        // Add more items as needed
    }

    private void filterItemList(String category) {
        filteredItemList.clear();
        if (category.equals("全部运动")) {
            filteredItemList.addAll(itemList);
        } else {
            for (ListItem item : itemList) {
                if (item.getDescription().equals(category)) {
                    filteredItemList.add(item);
                }
            }
        }
        listAdapter.notifyDataSetChanged();
    }
}
