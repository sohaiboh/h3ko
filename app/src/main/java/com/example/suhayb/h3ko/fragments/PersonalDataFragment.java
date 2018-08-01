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

public class PersonalDataFragment extends Fragment {

    TextView firstName;
    TextView lastName;
    TextView sex;
    TextView weight;
    TextView height;
    TextView dob;
    TextView streetName;
    TextView postalCode;
    TextView city;

    SharedPreferences mPreferences;

    public PersonalDataFragment() {
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
        View view = inflater.inflate(R.layout.fragment_personal_data, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        firstName = view.findViewById(R.id.firstName);
        lastName = view.findViewById(R.id.lastName);
        sex = view.findViewById(R.id.sex);
        weight = view.findViewById(R.id.weight);
        height = view.findViewById(R.id.height);
        dob = view.findViewById(R.id.dob);
        streetName = view.findViewById(R.id.streetName);
        postalCode = view.findViewById(R.id.postalCode);
        city = view.findViewById(R.id.city);

        mPreferences = getContext().getApplicationContext().getSharedPreferences(Constants.PREF_FILE, Context.MODE_PRIVATE);
        firstName.setText(mPreferences.getString(Constants.name,""));
//        lastName.setText(mPreferences.getString(Constants.name,""));
        sex.setText(mPreferences.getString(Constants.geschlecht,""));
        weight.setText(mPreferences.getString(Constants.gewicht,""));
        height.setText(mPreferences.getString(Constants.groesse,""));
        dob.setText(mPreferences.getString(Constants.name,""));

//        streetName.setText(mPreferences.getString(Constants.name,""));
//        postalCode.setText(mPreferences.getString(Constants.name,""));
//        city.setText(mPreferences.getString(Constants.name,""));
    }
}
