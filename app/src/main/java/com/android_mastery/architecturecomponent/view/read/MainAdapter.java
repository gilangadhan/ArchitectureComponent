/*
 * Copyright (c) 2018.
 * Gilang Ramadhan (gilang@imastudio.co.id)
 */

package com.android_mastery.architecturecomponent.view.read;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android_mastery.architecturecomponent.R;
import com.android_mastery.architecturecomponent.database.model.ModelHistory;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.HistoryViewHolder> {

    private List<ModelHistory> modelHistories;
    private View.OnLongClickListener longClickListener;

    public MainAdapter(View.OnLongClickListener longClickListener) {
        this.longClickListener = longClickListener;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HistoryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        ModelHistory modelHistory = modelHistories.get(position);
        holder.tanggal.setText(modelHistory.getTanggal_history());
        holder.alamat.setText(modelHistory.getAlamat_history());
        holder.itemView.setTag(modelHistory);
        holder.itemView.setOnLongClickListener(longClickListener);
    }

    public void addHistory(List<ModelHistory> models) {
        this.modelHistories = models;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (modelHistories != null) {
            return modelHistories.size();
        } else {
            return 0;
        }
    }

    class HistoryViewHolder extends RecyclerView.ViewHolder {
        TextView tanggal, alamat;

        HistoryViewHolder(View itemView) {
            super(itemView);
            tanggal = itemView.findViewById(R.id.txtTanggal);
            alamat = itemView.findViewById(R.id.txtAlamat);
        }
    }
}
