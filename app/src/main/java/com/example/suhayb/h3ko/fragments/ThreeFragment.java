package com.example.suhayb.h3ko.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.suhayb.h3ko.PatientTabActivity;
import com.example.suhayb.h3ko.R;
import com.example.suhayb.h3ko.Utils.Constants;
import com.example.suhayb.h3ko.Utils.UtilsHelper;
import com.example.suhayb.h3ko.model.Patientendaten;
import com.stanfy.gsonxml.GsonXml;
import com.stanfy.gsonxml.GsonXmlBuilder;
import com.stanfy.gsonxml.XmlParserCreator;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.util.HashMap;
import java.util.Map;


public class ThreeFragment extends Fragment {

    EditText cardNo;
    Button searchPatient;
    RequestQueue queue;
    SharedPreferences mPreferences;
    SharedPreferences.Editor editor;

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
        mPreferences = getContext().getApplicationContext().getSharedPreferences(Constants.PREF_FILE, Context.MODE_PRIVATE);


        searchPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                queue = Volley.newRequestQueue(getContext().getApplicationContext());
                stringXml();
            }
        });
    }

    private void stringXml() {
        String url = Constants.GET_PATIENT_BY_CARD_ID + Constants.CARD_ID;
        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        xmlParser(response);

                        Intent tabActivity = new Intent(getContext(),PatientTabActivity.class);
                        startActivity(tabActivity);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(),error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put(Constants.CARD_ID_KEY,cardNo.getText().toString());
                return params;
            }
        };
        queue.add(request);
    }

    private void xmlParser(String response) {
        XmlParserCreator parserCreator = new XmlParserCreator() {
            @Override
            public XmlPullParser createParser() {
                try {
                    return XmlPullParserFactory.newInstance().newPullParser();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };

        GsonXml gsonXml = new GsonXmlBuilder()
                .setXmlParserCreator(parserCreator)
                .setSameNameLists(true)
                .setPrimitiveArrays(true)
                .create();

        Patientendaten patientendaten = gsonXml.fromXml(response,Patientendaten.class);

        editor = mPreferences.edit();

        //    Personendaten
        editor.putString(Constants.name, patientendaten.dokumentation.get(0).getName());
        editor.putString(Constants.gewicht, patientendaten.dokumentation.get(0).getGewicht());
        editor.putString(Constants.groesse, patientendaten.dokumentation.get(0).getGroesse());
        editor.putString(Constants.geschlecht, patientendaten.dokumentation.get(0).getGeschlecht());

        editor.putString(Constants.vorerkrankungen, patientendaten.dokumentation.get(1).getVorerkrankungen());
        editor.putString(Constants.aktuelle_behandlungen, patientendaten.dokumentation.get(1).getAktuelle_behandlungen());
        editor.putString(Constants.aktuelle_mediaktion, patientendaten.dokumentation.get(1).getAktuelle_mediaktion());
        editor.putString(Constants.aktuelle_vergangene_symptomen, patientendaten.dokumentation.get(1).getAktuelle_vergangene_symptomen());
        editor.putString(Constants.andere, patientendaten.dokumentation.get(1).getAndere());

        editor.putString(Constants.roentgentbilder, patientendaten.dokumentation.get(2).getRoentgentbilder());
        editor.putString(Constants.mrt_bilder, patientendaten.dokumentation.get(2).getMrt_bilder());
        editor.putString(Constants.ultrashall, patientendaten.dokumentation.get(2).getUltrashall());

        editor.putString(Constants.herztoene, patientendaten.dokumentation.get(3).getHerztoene());

        editor.apply();

    }
}
