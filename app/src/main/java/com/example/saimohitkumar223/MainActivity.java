package com.example.saimohitkumar223;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listView_223;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit_223();
    }

    private void submit_223() {
        listView_223 = findViewById(R.id.list_view_223);
        listView_223.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String violation = listView_223.getItemAtPosition(i).toString();
                Intent toChallanActivity = new Intent(MainActivity.this, ChallanActivity.class);
                toChallanActivity.putExtra("challan_type", violation);
                startActivity(toChallanActivity);
            }
        });
    }
}