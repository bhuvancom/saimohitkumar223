package com.example.saimohitkumar223;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView violationType_223;
    TextView mobile_223;
    TextView fineAmount_223;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        violationType_223 = findViewById(R.id.violation);
        mobile_223 = findViewById(R.id.mobile);
        fineAmount_223 = findViewById(R.id.fine_amount);
        Intent intent = getIntent();
        violationType_223.setText(intent.getStringExtra("challan_type"));
        mobile_223.setText(intent.getStringExtra("mobile"));
        fineAmount_223.setText(intent.getStringExtra("fine"));
    }
}