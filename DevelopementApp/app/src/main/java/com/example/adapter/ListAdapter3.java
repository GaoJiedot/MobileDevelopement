package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Item.ListItem3;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter3 extends RecyclerView.Adapter<ListAdapter3.ViewHolder> implements Filterable {
    private Context context;
    private int resource;
    private List<ListItem3> originalItems;
    private List<ListItem3> filteredItems;
    private OnItemLongClickListener onItemLongClickListener;

    public ListAdapter3(Context context, int resource, List<ListItem3> items) {
        this.context = context;
        this.resource = resource;
        this.originalItems = new ArrayList<>(items);
        this.filteredItems = new ArrayList<>(items);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(resource, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListItem3 item = filteredItems.get(position);
        holder.imageAvatar.setImageResource(item.getImageAvatar());
        holder.imageShare.setImageResource(item.getImageShare());
        holder.name.setText(item.getName());
        holder.title.setText(item.getTitle());

        holder.itemView.setOnLongClickListener(v -> {
            if (onItemLongClickListener != null) {
                return onItemLongClickListener.onItemLongClick(v, position);
            }
            return false;
        });
    }

    @Override
    public int getItemCount() {
        return filteredItems.size();
    }

    public void addItem(ListItem3 item) {
        originalItems.add(0, item);
        filteredItems.add(0, item);
        notifyItemInserted(0);
    }

    public void removeItem(int position) {
        ListItem3 removedItem = filteredItems.remove(position);
        originalItems.remove(removedItem);
        notifyItemRemoved(position);
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                List<ListItem3> filteredList = new ArrayList<>();
                if (constraint == null || constraint.length() == 0) {
                    filteredList.addAll(originalItems);
                } else {
                    String filterPattern = constraint.toString().toLowerCase().trim();
                    for (ListItem3 item : originalItems) {
                        if (item.getName().toLowerCase().contains(filterPattern) ||
                                item.getTitle().toLowerCase().contains(filterPattern)) {
                            filteredList.add(item);
                        }
                    }
                }
                FilterResults results = new FilterResults();
                results.values = filteredList;
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filteredItems.clear();
                filteredItems.addAll((List<ListItem3>) results.values);
                notifyDataSetChanged();
            }
        };
    }

    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        this.onItemLongClickListener = listener;
    }

    public interface OnItemLongClickListener {
        boolean onItemLongClick(View view, int position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageAvatar;
        ImageView imageShare;
        TextView name;
        TextView title;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageAvatar = itemView.findViewById(R.id.imageAvatar);
            imageShare = itemView.findViewById(R.id.imageShare);
            name = itemView.findViewById(R.id.name);
            title = itemView.findViewById(R.id.title);
        }
    }
}