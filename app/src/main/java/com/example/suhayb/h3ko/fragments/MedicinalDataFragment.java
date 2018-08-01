package com.example.suhayb.h3ko.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.suhayb.h3ko.R;
import com.example.suhayb.h3ko.Utils.Constants;

public class MedicinalDataFragment extends Fragment {

    TextView conditions;
    TextView treatment;
    TextView medication;
    TextView symptoms;
    TextView heartBeat;

    SharedPreferences mPreferences;

    public MedicinalDataFragment() {
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
        View view = inflater.inflate(R.layout.fragment_medicinal_data, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        conditions = view.findViewById(R.id.conditions);
        treatment = view.findViewById(R.id.current_treatments);;
        medication = view.findViewById(R.id.current_medication);;
        symptoms = view.findViewById(R.id.symp);;
        heartBeat = view.findViewById(R.id.heartBeat);

        mPreferences = getContext().getApplicationContext().getSharedPreferences(Constants.PREF_FILE, Context.MODE_PRIVATE);

        conditions.setText(mPreferences.getString(Constants.vorerkrankungen, ""));
        treatment.setText(mPreferences.getString(Constants.aktuelle_behandlungen, ""));
        medication.setText(mPreferences.getString(Constants.aktuelle_mediaktion, ""));
        symptoms.setText(mPreferences.getString(Constants.aktuelle_vergangene_symptomen, ""));
        heartBeat.setText(mPreferences.getString(Constants.herztoene, ""));
    }
}
