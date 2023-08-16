package com.example.nestedrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ViewHolder> {
    List<ChildModel> childModelList;
    Context context;

    public ChildAdapter(List<ChildModel> childModelList, Context context) {
        this.childModelList = childModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public ChildAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.child_rv_layout, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildAdapter.ViewHolder holder, int position) {
        holder.iv_child_image.setImageResource(childModelList.get(position).image);

    }

    @Override
    public int getItemCount() {
        return childModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_child_image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            iv_child_image = itemView.findViewById(R.id.iv_child_item);
        }
    }
}
