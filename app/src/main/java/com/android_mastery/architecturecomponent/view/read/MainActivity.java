/*
 * Copyright (c) 2018.
 * Gilang Ramadhan (gilang@imastudio.co.id)
 */

package com.android_mastery.architecturecomponent.view.read;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android_mastery.architecturecomponent.R;
import com.android_mastery.architecturecomponent.database.model.ModelHistory;
import com.android_mastery.architecturecomponent.view.create.CreateActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {
    private MainAdapter mainAdapter;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        findViewById(R.id.btn_create).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CreateActivity.class));
            }
        });

        mainAdapter = new MainAdapter(this);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mainAdapter);

        mainViewModel.getAllHistory().observe(MainActivity.this, new Observer<List<ModelHistory>>() {
            @Override
            public void onChanged(@Nullable List<ModelHistory> modelHistories) {
                mainAdapter.addHistory(modelHistories);
            }
        });
    }

    @Override
    public boolean onLongClick(View view) {
        ModelHistory model = (ModelHistory) view.getTag();
        mainViewModel.deleteHistory(model);
        return false;
    }
}
