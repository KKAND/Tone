package com.example.mks.tone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main5Activity extends AppCompatActivity {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        Button button = (Button)findViewById(R.id.button);
        ButtonListener buttonListener = new ButtonListener();
        button.setOnClickListener(buttonListener);
    }


    class ButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            finish();
        }
    }
}
