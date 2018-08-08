/*
 * Copyright (c) 2018.
 * Gilang Ramadhan (gilang@imastudio.co.id)
 */

package com.android_mastery.architecturecomponent.view.create.ui.create;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android_mastery.architecturecomponent.R;
import com.android_mastery.architecturecomponent.database.model.ModelHistory;

public class CreateFragment extends Fragment {

    private CreateViewModel mViewModel;

    public static CreateFragment newInstance() {
        return new CreateFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.create_fragment, container, false);
    }

    EditText alamat, tanggal;
    Button submit;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(CreateViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        alamat = view.findViewById(R.id.edtAlamat);
        tanggal = view.findViewById(R.id.edtTanggal);
        submit = view.findViewById(R.id.btnSubmit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (alamat.getText().toString().isEmpty() || tanggal.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "Masih Kosong", Toast.LENGTH_SHORT).show();
                } else {
                    mViewModel.createHistory(new ModelHistory(tanggal.getText().toString(), alamat.getText().toString()));
                    getActivity().finish();
                }
            }
        });
    }
}
