package com.example.mks.tone;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main2Activity extends AppCompatActivity {
    private Button button;
    private TextView tv_time;
    private static final int msgKey1 = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button button = (Button)findViewById(R.id.button);
        ButtonListener buttonListener = new ButtonListener();
        button.setOnClickListener(buttonListener);

        tv_time = (TextView) findViewById(R.id.text21);
        new TimeThread().start();
    }

class ButtonListener implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        finish();
    }
}
public class TimeThread extends  Thread{
        @Override
        public void run() {
            super.run();
            do{
                try {
                    Thread.sleep(1000);
                    Message msg = new Message();
                    msg.what = msgKey1;
                    mHandler.sendMessage(msg);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }while (true);
        }
    }
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case msgKey1:
                    long time = System.currentTimeMillis();
                    Date date = new Date(time);
                    SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 EEE");
                    tv_time.setText(format.format(date));
                    break;
                default:
                    break;
            }
        }
    };
}



