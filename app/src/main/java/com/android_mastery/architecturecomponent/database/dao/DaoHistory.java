/*
 * Copyright (c) 2018.
 * Gilang Ramadhan (gilang@imastudio.co.id)
 */

package com.android_mastery.architecturecomponent.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.android_mastery.architecturecomponent.database.model.ModelHistory;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface DaoHistory {

    //get all data
    @Query("select * from history order by id_history desc")
    LiveData<List<ModelHistory>> getAllHistory();

    //get data from id_history
    @Query("select * from history where id_history = :id_history")
    ModelHistory getHistory(String id_history);

    //insert data
    @Insert(onConflict = REPLACE)
    void addHistory(ModelHistory modelHistory);

    //delete data
    @Delete
    void deleteHistory(ModelHistory modelHistory);
}
