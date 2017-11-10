package com.example.vmtung.example;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collection;

/**
 * Created by vmtung on 24/10/2017.
 */

public class HideItemSpinnerAdapter extends ArrayAdapter<CountryDto> {

    private LayoutInflater inflater;

    public HideItemSpinnerAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
        inflater = ((Activity)context).getLayoutInflater();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        CountryDto rowItem = getItem(position);
        View rowview = inflater.inflate(R.layout.spinner_country_complex_adapter_layout, null, true);

        ImageView flagImageView = (ImageView) rowview.findViewById(R.id.flagImageView);
        TextView countryNameTextView = (TextView) rowview.findViewById(R.id.countryNameTextView);
        TextView countryCodeTextView = (TextView) rowview.findViewById(R.id.countryCodeTextView);

        flagImageView.setImageDrawable(this.getContext().getResources().getDrawable(R.drawable.ic_america_flag));
        countryNameTextView.setText(rowItem.getName());
        countryCodeTextView.setText(rowItem.getCode());

        return rowview;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent)
    {
        if(position ==0 ||position ==1)
        {
            View viewIteam = new View(this.getContext());
            viewIteam.setVisibility(View.GONE);
            return viewIteam;
        }
        CountryDto rowItem = getItem(position);
        View rowview = inflater.inflate(R.layout.spinner_country_complex_adapter_layout, null, true);

        ImageView flagImageView = (ImageView) rowview.findViewById(R.id.flagImageView);
        TextView countryNameTextView = (TextView) rowview.findViewById(R.id.countryNameTextView);
        TextView countryCodeTextView = (TextView) rowview.findViewById(R.id.countryCodeTextView);

        flagImageView.setImageDrawable(rowItem.getFlagDrawable());
        countryNameTextView.setText(rowItem.getName());
        countryCodeTextView.setText(rowItem.getCode());

        return rowview;
    }

    @Override
    public void addAll(@NonNull Collection<? extends CountryDto> collection) {
        super.addAll(collection);
    }
}
