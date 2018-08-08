/*
 * Copyright (c) 2018.
 * Gilang Ramadhan (gilang@imastudio.co.id)
 */

package com.android_mastery.architecturecomponent.view.create.ui.create;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.android_mastery.architecturecomponent.database.base.DatabaseApp;
import com.android_mastery.architecturecomponent.database.model.ModelHistory;

public class CreateViewModel extends AndroidViewModel {
    private DatabaseApp databaseApp;

    public CreateViewModel(@NonNull Application application) {
        super(application);
        databaseApp = DatabaseApp.getDatabase(this.getApplication());
    }

    public void createHistory(ModelHistory modelHistory) {
        new createAsynTask(databaseApp).execute(modelHistory);
    }

    private class createAsynTask extends AsyncTask<ModelHistory, Void, Void> {
        private DatabaseApp database;

        createAsynTask(DatabaseApp databaseApp) {
            this.database = databaseApp;
        }

        @Override
        protected Void doInBackground(ModelHistory... modelHistories) {
            database.getDaoHistory().addHistory(modelHistories[0]);
            return null;
        }
    }
}
