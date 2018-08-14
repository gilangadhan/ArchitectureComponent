/*
 * Copyright (c) 2018.
 * Gilang Ramadhan (gilang@imastudio.co.id)
 */

package com.android_mastery.architecturecomponent.view.read;

import android.arch.paging.PagedListAdapter;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android_mastery.architecturecomponent.R;
import com.android_mastery.architecturecomponent.database.model.ModelHistory;

import java.util.List;

public class MainAdapter extends PagedListAdapter<ModelHistory, MainAdapter.HistoryViewHolder> {

    private View.OnLongClickListener longClickListener;

    public MainAdapter(View.OnLongClickListener longClickListener) {
        super(ModelHistory.DIFF_CALLBACK);
        this.longClickListener = longClickListener;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HistoryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        ModelHistory modelHistory = getItem(position);
        if (modelHistory != null) {
            holder.tanggal.setText(modelHistory.getTanggal_history());
            holder.alamat.setText(modelHistory.getAlamat_history());
            holder.itemView.setTag(modelHistory);
            holder.itemView.setOnLongClickListener(longClickListener);
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
