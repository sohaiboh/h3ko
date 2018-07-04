package com.example.suhayb.h3ko.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.suhayb.h3ko.R;
import com.example.suhayb.h3ko.Utils.UtilsHelper;


public class ThreeFragment extends Fragment {

    EditText cardNo;
    Button searchPatient;

    public ThreeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        cardNo = view.findViewById(R.id.EdTxtCardNo);
        searchPatient = view.findViewById(R.id.btnSearchPatient);


        searchPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "TEST", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
