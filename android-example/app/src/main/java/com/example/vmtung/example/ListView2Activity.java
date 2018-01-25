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
        ArrayAdapter<String>adapterSingle = new ArrayAdapter<String>(ListView2Activity.this, android.R.layout.simple_list_item_single_choice, mTestArray);
        ArrayAdapter<String>adapterMultiple = new ArrayAdapter<String>(ListView2Activity.this, android.R.layout.simple_list_item_multiple_choice, mTestArray);
        ListView nationSingleListView = findViewById(R.id.nationSingleListView);
        ListView nationMultipleChoiceListView = findViewById(R.id.nationMultipleChoiceListView);
        nationSingleListView.setAdapter(adapterSingle);
        nationMultipleChoiceListView.setAdapter(adapterMultiple);
    }
}
