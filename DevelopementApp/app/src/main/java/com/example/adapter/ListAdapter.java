package com.example.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.Item.ListItem;
import com.example.myapplication.R;

import java.util.List;

public class ListAdapter extends ArrayAdapter<ListItem> {
    private int resource;

    public ListAdapter(@NonNull Context context, int resource, @NonNull List<ListItem> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
        ListItem item = getItem(position);

        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(resource, parent, false);
            holder = new ViewHolder();
            holder.name = convertView.findViewById(R.id.item_text);
            holder.description = convertView.findViewById(R.id.item_text2);
            holder.imageResId = convertView.findViewById(R.id.item_image);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.name.setText(item.getName());
        holder.description.setText(item.getDescription());
        holder.imageResId.setImageResource(item.getImageResId());

        return convertView;
    }

    private static class ViewHolder {
        TextView name;
        TextView description;
        ImageView imageResId;
    }
}
