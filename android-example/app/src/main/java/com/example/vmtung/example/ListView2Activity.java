package com.example.vmtung.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListView2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view2);
        String[]mTestArray = getResources().getStringArray(R.array.array_juices);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(ListView2Activity.this, android.R.layout.simple_list_item_single_choice, mTestArray);
        ListView nationListView = findViewById(R.id.nationListView);
        nationListView.setAdapter(adapter);
    }
}
