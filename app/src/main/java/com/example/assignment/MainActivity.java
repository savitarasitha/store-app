package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SessionManager sessionManager;
    Spinner spinner;
    Button btnSetValue;
    TextView textView , tvString;
    String[] booleanList = {"Select Boolean Value", "True", "False"};
    String booleanValue = "Select Boolean Value";
    ArrayAdapter ad;
    EditText myString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sessionManager = new SessionManager(this);

        spinner = findViewById(R.id.spinner_boolean);
        btnSetValue = findViewById(R.id.btn_set_value);
        textView = findViewById(R.id.tv_my_boolean_value);
        tvString = findViewById(R.id.tv_my_string_value);
        myString = findViewById(R.id.et_String_value);
        ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, booleanList);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(ad);
        textView.setText(sessionManager.getBoolean().toString());
        tvString.setText(sessionManager.getString());

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                booleanValue = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        btnSetValue.setOnClickListener(v -> {
            if (booleanValue.equals("Select Boolean Value")) {
                Toast.makeText(this, "Please Select Value", Toast.LENGTH_SHORT).show();
            }else if (myString.getText().toString().equals("")){
                Toast.makeText(this, "Please Enter Value", Toast.LENGTH_SHORT).show();
            } else {
                if (booleanValue.equals("True")) {
                    sessionManager.setBoolean(true);
                    textView.setText(sessionManager.getBoolean().toString());
                    Toast.makeText(this, sessionManager.getBoolean()+"", Toast.LENGTH_SHORT).show();
                } else if (booleanValue.equals("False")) {
                    sessionManager.setBoolean(false);
                    textView.setText(sessionManager.getBoolean().toString());
                    Toast.makeText(this, sessionManager.getBoolean()+"", Toast.LENGTH_SHORT).show();
                }
                sessionManager.setString(myString.getText().toString());
                tvString.setText(sessionManager.getString());
            }
        });


    }
}