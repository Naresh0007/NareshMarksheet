package com.naresh.marks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button button;
    EditText tname, android, iot, web;
    TextView result;
    String status = "";
    int i = 1;
    DecimalFormat decimalFormat = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        tname = findViewById(R.id.tname);
        android = findViewById(R.id.android);
        iot = findViewById(R.id.iot);
        web = findViewById(R.id.web);
        result = findViewById(R.id.result);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View x) {
        if (x.getId() == R.id.button) {
            double androidmarks = 0, iotmarks = 0, webmarks = 0;

            if ((TextUtils.isEmpty(tname.getText().toString()))) {
                tname.setError("Please enter name");
                return;
            } else if ((TextUtils.isEmpty(android.getText().toString()))) {
                tname.setError("Please enter Android marks");
                return;
            } else if ((TextUtils.isEmpty(iot.getText().toString()))) {
                tname.setError("Please enter IOT marks");
                return;
            } else if ((TextUtils.isEmpty(web.getText().toString()))) {
                tname.setError("Please enter Web marks");
                return;
            } else {
                androidmarks = Double.parseDouble(android.getText().toString());
                iotmarks = Double.parseDouble(iot.getText().toString());
                webmarks = Double.parseDouble(web.getText().toString());
            }
            if((androidmarks <=100) && (androidmarks >=0)){
                if((iotmarks<=100) && (iotmarks>=0)){
                    if((webmarks<=100) && (webmarks>=0)){
                        result.append((i + ") " + " Name: " + tname.getText().toString()) +
                                " | Android: " + (decimalFormat.format(Double.parseDouble(android.getText().toString()))) +
                                " | IOT: " + (decimalFormat.format(Double.parseDouble(iot.getText().toString()))) +
                                " | web: " + (decimalFormat.format(Double.parseDouble(web.getText().toString()))) +
                                " | percentage " + percentage() + " | " + status + "\n");
                        Clear();
                        i++;
                    } else {
                        web.setError("Please enter marks of WEB 0 to 100");
                    }

                } else {
                    iot.setError("Please enter marks of IOT 0 to 100");

                }
            } else {
                android.setError("Please enter marks of Android 0 to 100");

            }
                    }
                }

    public String percentage() {

        double androidmarks = 0, iotmarks = 0, webmarks = 0, percent = 0;
        androidmarks = Double.parseDouble(decimalFormat.format(Double.parseDouble(android.getText().toString())));
        iotmarks = Double.parseDouble(decimalFormat.format(Double.parseDouble(iot.getText().toString())));
        webmarks = Double.parseDouble(decimalFormat.format(Double.parseDouble(web.getText().toString())));


        percent = (androidmarks + iotmarks + webmarks) / 3;
        if ((androidmarks >= 40) && (iotmarks >= 40) && (webmarks >= 40)) {
            status = "Pass";
        } else {
            status = "fail";
        }

        return decimalFormat.format(percent);
    }

    public void Clear() {
        tname.setText("");
        android.setText("");
        iot.setText("");
        web.setText("");
    }
}



