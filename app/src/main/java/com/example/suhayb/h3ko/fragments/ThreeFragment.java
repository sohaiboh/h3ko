package com.example.suhayb.h3ko.fragments;

import android.app.Activity;
import android.content.Context;
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
        String url = "http://dowser-medi-app.com.w00ffa2d.kasserver.com/index.php?getPatientByCardId=1";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getActivity(),response,Toast.LENGTH_LONG).show();

                        xmlParser(response);
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
                params.put("card_id","AX34K75");
                return params;
            }
        };
        queue.add(stringRequest);
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
//
//        //    Generelle Dokumentaiton
//        public static final String vorerkrankungen = "vorerkrankungen";
//        public static final String aktuelle_behandlungen = "aktuelle_behandlungen";
//        public static final String aktuelle_mediaktion = "aktuelle_mediaktion";
//        public static final String aktuelle_vergangene_symptomen = "aktuelle_vergangene_symptomen";
//        public static final String andere = "andere";
//
//        //    visuelle Dokumentaiton
//        public static final String roentgentbilder = "roentgentbilder";
//        public static final String mrt_bilder = "mrt_bilder";
//        public static final String ultrashall = "ultrashall";
//
//        //    akustische Dokumentaiton
//        public static final String herztoene = "herztoene";


        //    Personendaten
        editor.putString(Constants.name, patientendaten.dokumentation.get(0).getName());
        editor.putString(Constants.gewicht, patientendaten.dokumentation.get(0).getGewicht());
        editor.putString(Constants.groesse, patientendaten.dokumentation.get(0).getGroesse());
        editor.putString(Constants.geschlecht, patientendaten.dokumentation.get(0).getGeschlecht());

        editor.apply();
    }
}
