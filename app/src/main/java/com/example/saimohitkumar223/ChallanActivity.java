package com.example.saimohitkumar223;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class ChallanActivity extends AppCompatActivity {
    TextInputLayout textInputLayoutMobile223;
    TextInputLayout textInputLayoutFineAmount223;
    Button btnSubmit;
    TextView tvFineType;
    String fineType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challan);
        fineType = getIntent().getStringExtra("challan_type");

        textInputLayoutMobile223 = findViewById(R.id.mobile);
        textInputLayoutFineAmount223 = findViewById(R.id.fine_amount);
        btnSubmit = findViewById(R.id.btn_submit);
        tvFineType = findViewById(R.id.tv_violation);

        tvFineType.setText(getString(R.string.violation_type, fineType));
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mobile = textInputLayoutMobile223.getEditText().getText().toString();
                String fineAmount = textInputLayoutFineAmount223.getEditText().getText().toString();

                if (!mobile.matches("\\d{10}")) {
                    textInputLayoutMobile223.setErrorEnabled(true);
                    textInputLayoutMobile223.setError(getString(R.string.invalid_mobile));
                    return;
                }
                textInputLayoutMobile223.setErrorEnabled(false);

                if (!fineAmount.matches("\\d+")) {
                    textInputLayoutFineAmount223.setErrorEnabled(true);
                    textInputLayoutFineAmount223.setError(getString(R.string.invalid_fine));
                    return;
                }
                textInputLayoutFineAmount223.setErrorEnabled(false);

                Intent toDetailsActivity = new Intent(ChallanActivity.this, ResultActivity.class);
                toDetailsActivity.putExtra("challan_type", fineType);
                toDetailsActivity.putExtra("mobile", mobile);
                toDetailsActivity.putExtra("fine", fineAmount);
                startActivity(toDetailsActivity);
            }
        });

    }
}