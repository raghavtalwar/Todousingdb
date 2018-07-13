package com.example.raghav.todousingdb;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder>{

    Context context;
    ArrayList<Task> taskArrayList;

    public TaskAdapter(Context context, ArrayList<Task> taskArrayList) {
        this.context = context;
        this.taskArrayList = taskArrayList;
    }

    @NonNull
    @Override
    public TaskAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(context);
        View inflatedView = li.inflate(R.layout.item_row,parent,false);
        ViewHolder vh= new ViewHolder(inflatedView);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.ViewHolder holder, int position) {
        Task t = taskArrayList.get(position);
        holder.tv1.setText(t.getNote());

    }

    @Override
    public int getItemCount() {
        return taskArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1=itemView.findViewById(R.id.Note);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    int j = getAdapterPosition();
                    Log.e("TAG","j: "+j);
                    taskArrayList.remove(j);
                    notifyDataSetChanged();
                    return true;
                }
            });

        }
    }
}
