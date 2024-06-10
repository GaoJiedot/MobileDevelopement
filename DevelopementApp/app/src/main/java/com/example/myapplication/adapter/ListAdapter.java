package com.example.myapplication.adapter
        ;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.Item.ListItem;
import com.example.myapplication.R;

import java.util.List;

public class ListAdapter extends ArrayAdapter<ListItem> {
    private int resourceId;

    public ListAdapter(@NonNull Context context, int resource, @NonNull List<ListItem> objects) {
        super(context, resource, objects);
        this.resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ListItem listItem = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        ImageView imageView = view.findViewById(R.id.item_image);
        TextView textView = view.findViewById(R.id.item_text);
        TextView textView2 = view.findViewById(R.id.item_text2);

        if (listItem != null) {
            imageView.setImageResource(listItem.getImageResId());
            textView.setText(listItem.getName());
            textView2.setText(listItem.getDescription());
        }

        return view;
    }
}
