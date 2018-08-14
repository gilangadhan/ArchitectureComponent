/*
 * Copyright (c) 2018.
 * Gilang Ramadhan (gilang@imastudio.co.id)
 */

package com.android_mastery.architecturecomponent.view.read;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.android_mastery.architecturecomponent.database.base.DatabaseApp;
import com.android_mastery.architecturecomponent.database.model.ModelHistory;

public class MainViewModel extends AndroidViewModel {
    private final LiveData<PagedList<ModelHistory>> itemList;

    private DatabaseApp databaseApp;

    public MainViewModel(@NonNull Application application) {
        super(application);

        databaseApp = DatabaseApp.getDatabase(this.getApplication());
        itemList = new LivePagedListBuilder<>(databaseApp.getDaoHistory().getAllHistory(),
                new PagedList.Config.Builder()
                        .setPageSize(1)
                        .setPrefetchDistance(1)
                        .setEnablePlaceholders(true)
                        .build())
                .setInitialLoadKey(0)
                .build();
    }

    public LiveData<PagedList<ModelHistory>> getAllHistory() {
        return itemList;
    }

    public void deleteHistory(ModelHistory modelHistory) {
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

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
