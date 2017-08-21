package com.example.vmtung.example;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    JuiceListAdapter juiceListAdapter;
    ArrayList<ItemJuiceListExampleObject> itemJuiceListExampleObjects = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        final ListView juiceExampleListView =(ListView)findViewById(R.id.juiceExampleListView);
        final EditText logEditText =(EditText)findViewById(R.id.logEditText);

        itemJuiceListExampleObjects.add(new ItemJuiceListExampleObject("Banana"));
        itemJuiceListExampleObjects.add(new ItemJuiceListExampleObject("Mango"));
        itemJuiceListExampleObjects.add(new ItemJuiceListExampleObject("Coconut"));
        itemJuiceListExampleObjects.add(new ItemJuiceListExampleObject("Lemon"));
        itemJuiceListExampleObjects.add(new ItemJuiceListExampleObject("Orchart"));
        itemJuiceListExampleObjects.add(new ItemJuiceListExampleObject("Orange"));
        itemJuiceListExampleObjects.add(new ItemJuiceListExampleObject("Grape"));
        itemJuiceListExampleObjects.add(new ItemJuiceListExampleObject("Kiwi"));
        itemJuiceListExampleObjects.add(new ItemJuiceListExampleObject("Water melon"));
        itemJuiceListExampleObjects.add(new ItemJuiceListExampleObject("Carrot"));
        itemJuiceListExampleObjects.add(new ItemJuiceListExampleObject("Apple"));
        itemJuiceListExampleObjects.add(new ItemJuiceListExampleObject("Cherry"));
        itemJuiceListExampleObjects.add(new ItemJuiceListExampleObject("Guava"));
        itemJuiceListExampleObjects.add(new ItemJuiceListExampleObject("Pear"));
        itemJuiceListExampleObjects.add(new ItemJuiceListExampleObject("Pea"));
        itemJuiceListExampleObjects.add(new ItemJuiceListExampleObject("Strawberry"));

        juiceListAdapter = new JuiceListAdapter(this, R.layout.layout_juice_list_item_example, itemJuiceListExampleObjects);
        juiceExampleListView.setAdapter(juiceListAdapter);

        juiceExampleListView.setOnScrollListener(new AbsListView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                String result = logEditText.getText().toString();

                ItemJuiceListExampleObject firstVisibleItem = juiceListAdapter.getItem(i);

                result = "firstVisibleItem:"+firstVisibleItem.toString() +",index:"+i+"\n"
                        +"visibleItemCount:"+i1 +"\n"
                        +"totalItemCount:"+i2 +"\n"
                        +"is end(bottom) of list:"+((i+i1==i2)?"TRUE":"FALSE") +"\n";

                logEditText.setText(result);

            }
        });
    }

}
