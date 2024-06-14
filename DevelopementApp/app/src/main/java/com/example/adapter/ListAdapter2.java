package com.example.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;

import com.example.Item.ListItem;
import com.example.Item.ListItem2;
import com.example.myapplication.R;

import java.util.List;

public class ListAdapter2 extends ArrayAdapter<ListItem2> {
    private int resource;

    public ListAdapter2(@NonNull Context context, int resource, @NonNull List<ListItem2> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
        ListItem2 item = getItem(position);

        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(resource, parent, false);
            holder = new ViewHolder();
            holder.name = convertView.findViewById(R.id.item_text);
            holder.description = convertView.findViewById(R.id.item_text2);
            holder.imageReId = convertView.findViewById(R.id.item_image);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.name.setText(item.getName());
        holder.description.setText(item.getDescription());
        holder.imageReId.setImageResource(item.getImageReId());

        return convertView;
    }

    private static class ViewHolder {
        TextView name;
        TextView description;
        ImageView imageReId;
    }
}
