package com.example.suhayb.h3ko.asyncTasks;


import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.example.suhayb.h3ko.Utils.ApiHandler;
import com.example.suhayb.h3ko.Utils.Constants;

import org.json.JSONObject;

public class GetPatientByCardIdTask {
    private Dialog loadingDialog;
    private Context context;
    private JSONObject json;
    private OnGetIdTaskCompleted listener;

    public GetPatientByCardIdTask(Context context, JSONObject json, OnGetIdTaskCompleted listener){
        this.context = context;
        this.json = json;
        this.listener = listener;
    }

    public void getPatientByCardId(){
        class AddPatientByCardIdTask extends AsyncTask<Void,String,String>{

            @Override
            protected void onPreExecute() {
                loadingDialog = ProgressDialog.show(context,"Retrieving information","Please wait...",true);
                super.onPreExecute();
            }

            @Override
            protected String doInBackground(Void... voids) {
                String url = Constants.GET_PATIENT_BY_CARD_ID + Constants.CARD_ID;
                String urlResponse = ApiHandler.run(url,"POST",json,context);
                return urlResponse;
            }

            @Override
            protected void onPostExecute(String s) {
                if (loadingDialog != null && loadingDialog.isShowing()) {
                    loadingDialog.dismiss();
                }
                listener.onTaskCompleted(s);
            }
        }
        AddPatientByCardIdTask task = new AddPatientByCardIdTask();
        task.execute();

    }
}
