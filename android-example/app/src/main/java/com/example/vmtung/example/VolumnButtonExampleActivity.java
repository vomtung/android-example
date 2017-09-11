package com.example.vmtung.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class VolumnButtonExampleActivity extends AppCompatActivity {

    private EditText consoleEditText;
    private Button clearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumn_button_example);
        consoleEditText = (EditText)findViewById(R.id.consoleEditText);
        clearButton = (Button)findViewById(R.id.clearButton);

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consoleEditText.getText().clear();
            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                consoleEditText.append("KeyEvent.KEYCODE_VOLUME_DOWN" + "\n");
                return true;
            case KeyEvent.KEYCODE_VOLUME_UP:
                consoleEditText.append("KeyEvent.KEYCODE_VOLUME_UP" + "\n");
                return true;
            case KeyEvent.KEYCODE_D:
                consoleEditText.append("KeyEvent.KEYCODE_D" + "\n");
                return true;
            case KeyEvent.KEYCODE_F:
                consoleEditText.append("KeyEvent.KEYCODE_F" + "\n");
                return true;
            case KeyEvent.KEYCODE_J:
                consoleEditText.append("KeyEvent.KEYCODE_J" + "\n");
                return true;
            case KeyEvent.KEYCODE_K:
                consoleEditText.append("KeyEvent.KEYCODE_K" + "\n");
                return true;
            default:
                return true;
        }
    }
}

