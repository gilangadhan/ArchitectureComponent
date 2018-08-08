/*
 * Copyright (c) 2018.
 * Gilang Ramadhan (gilang@imastudio.co.id)
 */

package com.android_mastery.architecturecomponent.view.create;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android_mastery.architecturecomponent.R;
import com.android_mastery.architecturecomponent.view.create.ui.create.CreateFragment;

public class CreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, CreateFragment.newInstance())
                    .commitNow();
        }
    }
}
