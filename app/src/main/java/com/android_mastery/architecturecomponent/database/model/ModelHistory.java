/*
 * Copyright (c) 2018.
 * Gilang Ramadhan (gilang@imastudio.co.id)
 */

package com.android_mastery.architecturecomponent.database.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.v7.util.DiffUtil;

@Entity(tableName = "history")
public class ModelHistory {
    public static DiffUtil.ItemCallback<ModelHistory> DIFF_CALLBACK = new DiffUtil.ItemCallback<ModelHistory>() {
        @Override
        public boolean areItemsTheSame(ModelHistory oldItem, ModelHistory newItem) {
            return oldItem.id_history == newItem.id_history;
        }

        @Override
        public boolean areContentsTheSame(ModelHistory oldItem, ModelHistory newItem) {
            return oldItem.equals(newItem);
        }
    };


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_history")
    int id_history;

    @ColumnInfo(name = "tanggal_history")
    String tanggal_history;

    @ColumnInfo(name = "alamat_history")
    String alamat_history;


    public ModelHistory(String tanggal_history, String alamat_history) {
        this.tanggal_history = tanggal_history;
        this.alamat_history = alamat_history;
    }

    public int getId_history() {
        return id_history;
    }

    public void setId_history(int id_history) {
        this.id_history = id_history;
    }

    public String getTanggal_history() {
        return tanggal_history;
    }

    public void setTanggal_history(String tanggal_history) {
        this.tanggal_history = tanggal_history;
    }

    public String getAlamat_history() {
        return alamat_history;
    }

    public void setAlamat_history(String alamat_history) {
        this.alamat_history = alamat_history;
    }
}
