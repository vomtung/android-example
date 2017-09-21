package com.example.vmtung.example;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.vmtung.example.AutoCompleteActivity.COUNTRIES;
import static com.example.vmtung.example.AutoCompleteActivity.flagSetting;

/**
 * Created by vmtung on 21/09/2017.
 */

public class AutocompleteAdapter extends ArrayAdapter<String> {

    private LayoutInflater inflater;
    private Context context;

    public AutocompleteAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull String[] objects) {
        super(context, resource, textViewResourceId, objects);
        inflater = ((Activity)context).getLayoutInflater();
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final String rowItem = getItem(position);

        View rowview = inflater.inflate(R.layout.adapter_autocomplete_example, null, true);

        TextView nationNameTextView = (TextView) rowview.findViewById(R.id.nationNameTextView);
        ImageView flagImageView = (ImageView) rowview.findViewById(R.id.flagImageView);
        nationNameTextView.setText(rowItem);
        flagSetting(rowItem, flagImageView);
        //ImageView imageView = (ImageView) rowview.findViewById(R.id.icon);
        //imageView.setImageResource(rowItem.getImageId());

        rowview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((AutoCompleteActivity)context).onItemChoice(rowItem);
            }
        });

        return rowview;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        String rowItem = getItem(position);

        View rowview = inflater.inflate(R.layout.adapter_autocomplete_example, null, true);

        TextView nationNameTextView = (TextView) rowview.findViewById(R.id.nationNameTextView);
        ImageView flagImageView = (ImageView) rowview.findViewById(R.id.flagImageView);
        nationNameTextView.setText(rowItem);
        flagSetting(rowItem, flagImageView);

        //ImageView imageView = (ImageView) rowview.findViewById(R.id.icon);
        //imageView.setImageResource(rowItem.getImageId());

        return rowview;
    }

}
