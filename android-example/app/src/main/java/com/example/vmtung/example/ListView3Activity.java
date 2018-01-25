package com.example.vmtung.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListView3Activity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view3);
        String[]mTestArray = getResources().getStringArray(R.array.array_juices);
        MultipleItemAdapter adapterSingle = new MultipleItemAdapter(ListView3Activity.this, android.R.layout.simple_list_item_single_choice, mTestArray);
        ListView nationSingleListView = findViewById(R.id.listItem);
        nationSingleListView.setAdapter(adapterSingle);
    }
}
