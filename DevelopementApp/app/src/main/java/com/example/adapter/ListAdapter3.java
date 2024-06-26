package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Item.ListItem3;
import com.example.myapplication.R;

import java.util.List;

public class ListAdapter3 extends RecyclerView.Adapter<ListAdapter3.ViewHolder> {

    private Context context;
    private int resource;
    private List<ListItem3> items;

    public ListAdapter3(Context context, int resource, List<ListItem3> items) {
        this.context = context;
        this.resource = resource;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(resource, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListItem3 item = items.get(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageAvatar;
        ImageView imageShare;
        TextView  name;
        TextView title;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageAvatar = itemView.findViewById(R.id.imageAvatar);
            imageShare =itemView.findViewById(R.id.imageShare);
            name=itemView.findViewById(R.id.name);
            title=itemView.findViewById(R.id.title);
        }
    }
}
