/*
 * Copyright (c) 2018.
 * Gilang Ramadhan (gilang@imastudio.co.id)
 */

package com.android_mastery.architecturecomponent.database.base;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.android_mastery.architecturecomponent.database.dao.DaoHistory;
import com.android_mastery.architecturecomponent.database.model.ModelHistory;

@Database(entities = {ModelHistory.class}, version = 1)
public abstract class DatabaseApp extends RoomDatabase {
    private static volatile DatabaseApp INSTANCE;

    public static DatabaseApp getDatabase(Context context){
        if (INSTANCE == null){
            synchronized (DatabaseApp.class){
                if (INSTANCE==null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), DatabaseApp.class, "history_db").build();
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance(){
        INSTANCE = null;
    }

    public abstract DaoHistory getDaoHistory();
}
