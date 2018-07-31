package com.example.suhayb.h3ko.Utils;

import android.content.Context;
import android.util.Base64;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class ApiHandler {
    private ApiHandler(){}

    // handle API call and response
    public static String run(final String apiPath, final String method, final JSONObject data, final Context context) {
        String jsonResponse = null;
        boolean isConnected = UtilsHelper.isConnected(context);

        if (isConnected) {
            try {
                URL url = new URL(apiPath); // URL path

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(40000 /* milliseconds */);
                conn.setConnectTimeout(60000 /* milliseconds */);
                conn.setRequestMethod(method);
                conn.setDoInput(true);
                conn.setDoOutput(data != null);
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                conn.setRequestProperty("card_id","AX34K75");

                // set data if available and HTTP verb is 'POST'
                if (data != null && "POST".equalsIgnoreCase(method)) {
                    OutputStream os = conn.getOutputStream();
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, Constants.UTF_VERSION));

                    writer.write(data.toString());
                    writer.flush();

                    writer.close();
                    os.close();
                }

                int responseCode = conn.getResponseCode();
                if (responseCode == HttpsURLConnection.HTTP_OK) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                    StringBuilder sb = new StringBuilder("");
                    String line;

                    while ((line = in.readLine()) != null) {
                        sb.append(line);
//                        break;
                    }
                    in.close();
                    jsonResponse = sb.toString();
                } else {
                    Log.d("Error code from Server", String.valueOf(responseCode));
                }
            } catch (Exception e) {
                Log.e("Exception: ", e.getMessage(), e);
            }
            return jsonResponse;
        } else {
            return null;
        }
    }
}

