package com.example.suhayb.h3ko.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.suhayb.h3ko.MainActivity;
import com.example.suhayb.h3ko.PatientTabActivity;
import com.example.suhayb.h3ko.R;
import com.example.suhayb.h3ko.TabActivity;
import com.example.suhayb.h3ko.Utils.UtilsHelper;


public class TwoFragment extends Fragment {

    Button searchPatient;

    public TwoFragment() {
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
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        searchPatient = view.findViewById(R.id.btnSearchPatient);

        searchPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                TODO: Call service here!

                if(!UtilsHelper.isNetworkAvailable(getContext())){
//                  TODO: Place when you have hook up with web service call error
                    UtilsHelper.showAlert(getContext(),getString(R.string.error_finding_patient_title),getString(R.string.error_finding_patient_msg));
                }else {
                    Intent tabActivity = new Intent(getContext(),PatientTabActivity.class);
                    startActivity(tabActivity);
                }


            }
        });
    }

}
