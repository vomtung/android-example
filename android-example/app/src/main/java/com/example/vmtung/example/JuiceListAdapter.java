package com.example.vmtung.example;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vmtung on 21/08/2017.
 */

public class JuiceListAdapter extends ArrayAdapter<ItemJuiceListExampleObject>
{

    public JuiceListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<ItemJuiceListExampleObject> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.layout_juice_list_item_example, parent, false);

        ItemJuiceListExampleObject item = (ItemJuiceListExampleObject)this.getItem(position);

        TextView nameTextView = (TextView)rowView.findViewById(R.id.nameTextView);
        nameTextView.setText(item.getName());

        return rowView;
    }
}
