package com.example.vmtung.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class SpinnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        final Spinner juiceSpinner = (Spinner)findViewById(R.id.juiceSpinner);
        final Spinner countrySpinner = new Spinner(this, Spinner.MODE_DIALOG);
        final Button countrySpinnerButton =(Button)findViewById(R.id.countrySpinnerButton);
        final Spinner complexCountrySpinner =(Spinner)findViewById(R.id.complexCountrySpinner);
        final Spinner hideItemSpinner =(Spinner)findViewById(R.id.hideItemSpinner);
        final Spinner differentItemViewSpinner =(Spinner)findViewById(R.id.differentItemViewSpinner);
        LinearLayout countryContainerLinearLayout = (LinearLayout)findViewById(R.id.countryContainerLinearLayout);

        final ArrayAdapter locationSpinnerAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.array_juices,
                android.R.layout.simple_spinner_dropdown_item
                );
        final ArrayAdapter countrySpinnerAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.array_countries,
                android.R.layout.simple_spinner_dropdown_item
                );

        juiceSpinner.setAdapter(locationSpinnerAdapter);
        countrySpinner.setAdapter(countrySpinnerAdapter);

        countrySpinnerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countrySpinner.performClick();
            }
        });

        juiceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String label  = (String)locationSpinnerAdapter.getItem(i);
                Log.d("==DEBUG==","fruice:"+label);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String label  = (String)locationSpinnerAdapter.getItem(i);
                Log.d("==DEBUG==","country:"+label);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        countryContainerLinearLayout.addView(countrySpinner);

        /**
         * Country complex Spinner
         */
        List<CountryDto> complexCountryDto = new ArrayList<CountryDto>();

        CountryDto america = new CountryDto(0L, "America", "us", this.getResources().getDrawable(R.drawable.ic_america_flag));
        CountryDto china = new CountryDto(1L, "China", "cn", this.getResources().getDrawable(R.drawable.ic_china_flag));
        CountryDto japan = new CountryDto(2L, "Japan", "jp", this.getResources().getDrawable(R.drawable.ic_japan_flag));
        CountryDto russia = new CountryDto(3L, "Russia", "rs", this.getResources().getDrawable(R.drawable.ic_russia_flag));
        CountryDto england = new CountryDto(4L, "England", "en", this.getResources().getDrawable(R.drawable.ic_england_flag));

        complexCountryDto.add(america);
        complexCountryDto.add(china);
        complexCountryDto.add(japan);
        complexCountryDto.add(russia);
        complexCountryDto.add(england);

        ComplexSpinnerAdapter complexSpinerAdapter = new ComplexSpinnerAdapter(SpinnerActivity.this, R.layout.spinner_country_complex_adapter_layout);
        complexSpinerAdapter.addAll(complexCountryDto);
        complexCountrySpinner.setAdapter(complexSpinerAdapter);

        /**
         * Hide item Spinner
         */
        List<CountryDto> hideItemDto = new ArrayList<CountryDto>();

        CountryDto america2 = new CountryDto(0L, "America", "us", this.getResources().getDrawable(R.drawable.ic_america_flag));
        CountryDto china2 = new CountryDto(1L, "China", "cn", this.getResources().getDrawable(R.drawable.ic_china_flag));
        CountryDto japan2 = new CountryDto(2L, "Japan", "jp", this.getResources().getDrawable(R.drawable.ic_japan_flag));
        CountryDto russia2 = new CountryDto(3L, "Russia", "rs", this.getResources().getDrawable(R.drawable.ic_russia_flag));
        CountryDto england2 = new CountryDto(4L, "England", "en", this.getResources().getDrawable(R.drawable.ic_england_flag));

        hideItemDto.add(america2);
        hideItemDto.add(china2);
        hideItemDto.add(japan2);
        hideItemDto.add(russia2);
        hideItemDto.add(england2);

        HideItemSpinnerAdapter hideItemSpinerAdapter = new HideItemSpinnerAdapter(SpinnerActivity.this, R.layout.spinner_country_complex_adapter_layout);
        hideItemSpinerAdapter.addAll(hideItemDto);
        hideItemSpinner.setAdapter(hideItemSpinerAdapter);

        /**
         * Different Item View Spinner
         */
        List<CountryDto> differentItemViewDto = new ArrayList<CountryDto>();

        CountryDto america3 = new CountryDto(0L, "America", "us", this.getResources().getDrawable(R.drawable.ic_america_flag));
        CountryDto china3 = new CountryDto(1L, "China", "cn", this.getResources().getDrawable(R.drawable.ic_china_flag));
        CountryDto japan3 = new CountryDto(2L, "Japan", "jp", this.getResources().getDrawable(R.drawable.ic_japan_flag));
        CountryDto russia3 = new CountryDto(3L, "Russia", "rs", this.getResources().getDrawable(R.drawable.ic_russia_flag));
        CountryDto england3 = new CountryDto(4L, "England", "en", this.getResources().getDrawable(R.drawable.ic_england_flag));

        differentItemViewDto.add(america3);
        differentItemViewDto.add(china3);
        differentItemViewDto.add(japan3);
        differentItemViewDto.add(russia3);
        differentItemViewDto.add(england3);

        DifferentItemViewSpinnerAdapter differentItemViewSpinnerAdapter = new DifferentItemViewSpinnerAdapter(SpinnerActivity.this, R.layout.spinner_country_complex_adapter_layout);
        differentItemViewSpinnerAdapter.addAll(differentItemViewDto);
        differentItemViewSpinner.setAdapter(differentItemViewSpinnerAdapter);
    }
}
