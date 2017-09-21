package com.example.vmtung.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AutoCompleteActivity extends AppCompatActivity {

    private AutoCompleteTextView textView;
    private LinearLayout nationListLinearLayout;

    public static final String[] COUNTRIES = new String[] {
            "America",
            "Russia",
            "Austria",
            "Portugal",
            "Turkey",
            "Japan",
            "France",
            "European",
            "Autralia",
            "United Kingdom",
            "Germany",
            "England",
            "China",
            "Vietnam",


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete);

        AutocompleteAdapter adapter = new AutocompleteAdapter(
                this,
                R.layout.adapter_autocomplete_example,
                R.id.nationNameTextView,
                COUNTRIES);
        textView = (AutoCompleteTextView) findViewById(R.id.countries_list);
        nationListLinearLayout = (LinearLayout) findViewById(R.id.nationListLinearLayout);
        textView.setAdapter(adapter);
    }

    public void onItemChoice(String nation)
    {
        final View rootView = getLayoutInflater().inflate(R.layout.layout_nation_list, null);
        final TextView nationTextView = (TextView) rootView.findViewById(R.id.nationTextView);
        final ImageView flagImageView = (ImageView) rootView.findViewById(R.id.flagImageView);
        final ImageView removeImageView = (ImageView) rootView.findViewById(R.id.removeImageView);

        removeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nationListLinearLayout.removeView(rootView);
            }
        });

        nationTextView.setText(nation);
        flagSetting(nation, flagImageView);
        nationListLinearLayout.addView(rootView);
    }

    public static void flagSetting(String nation, ImageView flag)
    {
        if(nation.equals(COUNTRIES[0]))
        {
            flag.setImageResource(R.drawable.ic_america_flag);
        }
        else if(nation.equals(COUNTRIES[1]))
        {
            flag.setImageResource(R.drawable.ic_russia_flag);
        }
        else if(nation.equals(COUNTRIES[2]))
        {
            flag.setImageResource(R.drawable.ic_austria_flag);
        }
        else if(nation.equals(COUNTRIES[3]))
        {
            flag.setImageResource(R.drawable.ic_portugal_flag);
        }
        else if(nation.equals(COUNTRIES[4]))
        {
            flag.setImageResource(R.drawable.ic_turkey_flag);
        }
        else if(nation.equals(COUNTRIES[5]))
        {
            flag.setImageResource(R.drawable.ic_japan_flag);
        }
        else if(nation.equals(COUNTRIES[6]))
        {
            flag.setImageResource(R.drawable.ic_france_flag);
        }
        else if(nation.equals(COUNTRIES[7]))
        {
            flag.setImageResource(R.drawable.ic_european_flag);
        }
        else if(nation.equals(COUNTRIES[8]))
        {
            flag.setImageResource(R.drawable.ic_australia_flag);
        }
        else if(nation.equals(COUNTRIES[9]))
        {
            flag.setImageResource(R.drawable.ic_united_kingdom_flag);
        }
        else if(nation.equals(COUNTRIES[10]))
        {
            flag.setImageResource(R.drawable.ic_germany_flag);
        }
        else if(nation.equals(COUNTRIES[11]))
        {
            flag.setImageResource(R.drawable.ic_england_flag);
        }
        else if(nation.equals(COUNTRIES[12]))
        {
            flag.setImageResource(R.drawable.ic_china_flag);
        }
        else if(nation.equals(COUNTRIES[13]))
        {
            flag.setImageResource(R.drawable.ic_vietnam_flag);
        }
    }
}
