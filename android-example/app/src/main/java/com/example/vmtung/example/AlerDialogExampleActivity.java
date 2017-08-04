package com.example.vmtung.example;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AlerDialogExampleActivity extends AppCompatActivity {

    private AlertDialog singleChoiceDialog;
    private AlertDialog multichoiceChoiceDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aler_dialog_example);

        Button multichoiceDialogButton = (Button)findViewById(R.id.multichoiceDialogButton);
        Button singleChoiceDialogButton = (Button)findViewById(R.id.singleChoiceDialogButton);
        final TextView resultTextView = (TextView)findViewById(R.id.resultTextView);

        AlertDialog.Builder singleChoicebuilder = new AlertDialog.Builder(this);
        // Set the dialog title
        singleChoicebuilder.setTitle(R.string.single_choice)
                // Specify the list array, the items to be selected by default (null for none),
                // and the listener through which to receive callbacks when items are selected
                .setSingleChoiceItems(R.array.array_countries, 0, new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String result = AlerDialogExampleActivity.this.getString(R.string.single_choice)+":"+singleChoiceDialog.getListView().getCheckedItemPosition()+"   ";
                        resultTextView.setText(result);
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });

        AlertDialog.Builder multichoiceChoicebuilder = new AlertDialog.Builder(this);
        // Set the dialog title
        multichoiceChoicebuilder.setTitle(R.string.multichoice)
                // Specify the list array, the items to be selected by default (null for none),
                // and the listener through which to receive callbacks when items are selected
                .setMultiChoiceItems(R.array.array_countries, null,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked)
                            {

                            }
                        })
                // Set the action buttons
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        String result =AlerDialogExampleActivity.this.getString(R.string.multichoice)+ multichoiceChoiceDialog.getListView().getCheckedItemPositions().toString()+"   ";
                        for (int i=0; i<multichoiceChoiceDialog.getListView().getCheckedItemPositions().size();i++)
                        {
                            result += multichoiceChoiceDialog.getListView().getCheckedItemPositions().keyAt(i)+",";
                        }
                        resultTextView.setText(result);
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });


        singleChoiceDialog = singleChoicebuilder.create();
        multichoiceChoiceDialog = multichoiceChoicebuilder.create();

        singleChoiceDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                singleChoiceDialog.show();
            }
        });

        multichoiceDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                multichoiceChoiceDialog.show();
            }
        });
    }
}
