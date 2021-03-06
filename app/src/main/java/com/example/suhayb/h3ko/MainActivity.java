package com.example.suhayb.h3ko;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.suhayb.h3ko.Utils.UtilsHelper;
import com.example.suhayb.h3ko.asyncTasks.GetPatientByCardIdTask;
import com.example.suhayb.h3ko.asyncTasks.OnGetIdTaskCompleted;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    EditText email;
    EditText password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(email.getText().toString().isEmpty()){
                    UtilsHelper.showAlert(MainActivity.this,getString(R.string.err_title),getString(R.string.email_msg));
                    return;
                }else if(password.getText().toString().isEmpty()){
                    UtilsHelper.showAlert(MainActivity.this,getString(R.string.err_title),getString(R.string.password_msg));
                    return;
                }

                Intent tabActivity = new Intent(MainActivity.this,TabActivity.class);
                startActivity(tabActivity);
            }
        });
    }

    private void findViews() {
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.loginBtn);
    }
}
