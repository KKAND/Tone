package com.example.mks.tone;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button1, button2, button3, button4, button5, button6, button7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);

        ButtonListener3 buttonListener3 = new ButtonListener3();
        button3.setOnClickListener(buttonListener3);

        ButtonListener4 buttonListener4 = new ButtonListener4();
        button4.setOnClickListener(buttonListener4);

        ButtonListener5 buttonListener5 =new ButtonListener5();
        button5.setOnClickListener(buttonListener5);

        ButtonListener6 buttonListener6 = new ButtonListener6();
        button6.setOnClickListener(buttonListener6);
    }

class ButtonListener3 implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        //setClass()第一个参数是context类，activity是context的子类
        //第二个参数是一个class对象，在当前场景下应该传入需要启动的activity
        intent.setClass(MainActivity.this,Main2Activity.class);
        startActivity(intent);


    }
}
    class ButtonListener4 implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            //setClass()第一个参数是context类，activity是context的子类
            //第二个参数是一个class对象，在当前场景下应该传入需要启动的activity
            intent.setClass(MainActivity.this, Main3Activity.class);
            startActivity(intent);


        }
    }
    class ButtonListener5 implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            //setClass()第一个参数是context类，activity是context的子类
            //第二个参数是一个class对象，在当前场景下应该传入需要启动的activity
            intent.setClass(MainActivity.this,Main4Activity.class);
            startActivity(intent);


        }
    }
    class ButtonListener6 implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            //setClass()第一个参数是context类，activity是context的子类
            //第二个参数是一个class对象，在当前场景下应该传入需要启动的activity
            intent.setClass(MainActivity.this,Main5Activity.class);
            startActivity(intent);


        }
    }


}
