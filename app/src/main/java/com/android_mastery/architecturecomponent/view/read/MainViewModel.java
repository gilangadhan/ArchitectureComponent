/*
 * Copyright (c) 2018.
 * Gilang Ramadhan (gilang@imastudio.co.id)
 */

package com.android_mastery.architecturecomponent.view.read;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.android_mastery.architecturecomponent.database.base.DatabaseApp;
import com.android_mastery.architecturecomponent.database.model.ModelHistory;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private final LiveData<List<ModelHistory>> itemList;

    private DatabaseApp databaseApp;
    public MainViewModel(@NonNull Application application) {
        super(application);

        databaseApp = DatabaseApp.getDatabase(this.getApplication());
        itemList = databaseApp.getDaoHistory().getAllHistory();
    }

    public LiveData<List<ModelHistory>> getAllHistory(){
        return itemList;
    }

    public void deleteHistory(ModelHistory modelHistory){
        new deletAsynTask(databaseApp).execute(modelHistory);
    }

    private class deletAsynTask extends AsyncTask<ModelHistory, Void, Void> {
        private DatabaseApp database;

        deletAsynTask(DatabaseApp databaseApp) {
            this.database = databaseApp;
        }

        @Override
        protected Void doInBackground(ModelHistory... modelHistories) {
            database.getDaoHistory().deleteHistory(modelHistories[0]);
            return null;
        }
    }
}
