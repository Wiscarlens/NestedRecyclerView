package com.example.nestedrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ParentAdapter extends RecyclerView.Adapter<ParentAdapter.ViewHolder> {
    List<ParentModel> parentModelList;
    Context context;

    public ParentAdapter(List<ParentModel> parentModelList, Context context) {
        this.parentModelList = parentModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public ParentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.parent_rv_layout, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParentAdapter.ViewHolder holder, int position) {
        holder.TV_parent_title.setText(parentModelList.get(position).Title);

        ChildAdapter childAdapter = new ChildAdapter(parentModelList.get(position).childModels, context);
        holder.rv_child.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.rv_child.setAdapter(childAdapter);
        childAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return parentModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       RecyclerView rv_child;
       TextView TV_parent_title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rv_child = itemView.findViewById(R.id.rv_child);
            TV_parent_title = itemView.findViewById(R.id.tv_parent_title);

        }
    }
}
