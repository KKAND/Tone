package com.example.mks.tone;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    private Button button;
    private TextView tv31;
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Button button = (Button) findViewById(R.id.button31);
        ButtonListener buttonListener = new ButtonListener();
        button.setOnClickListener(buttonListener);
        tv31 = (TextView) findViewById(R.id.tv31);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        //对应用进行动态赋值，Android6.0以后，需要进行动态赋值，才能完全给予应用权限
        if (Build.VERSION.SDK_INT >= 23)  {
            int checkPermission = ContextCompat.checkSelfPermission(Main3Activity.this, Manifest.permission.ACCESS_COARSE_LOCATION);
            if (checkPermission != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(Main3Activity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
                ActivityCompat.requestPermissions(Main3Activity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                Log.d("应用权限", "弹出提示");
            }
        }

        final Location location = locationManager.getLastKnownLocation(locationManager.GPS_PROVIDER);

        //更新位置信息
        updateView(location);
        //参数：locationManager.requestLocationUpdates(provider,time,距离，监听器);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 8, new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

                updateView(location);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {
                //当检测到位置信息时候更新
                updateView(location);
            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        });

    }


    //返回按钮的监听器
    class ButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            finish();
        }
    }
    //updateView更新位置信息
    public void updateView(Location newLocation){

        if (newLocation != null){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("实时的位置信息：\n");
            stringBuilder.append("经度：");
            stringBuilder.append(newLocation.getLongitude());
            stringBuilder.append("\n纬度:");
            stringBuilder.append(newLocation.getLatitude());
            stringBuilder.append(newLocation.getLongitude());
            stringBuilder.append("\n海拔:");
            stringBuilder.append(newLocation.getAltitude());
            stringBuilder.append(newLocation.getLongitude());
            stringBuilder.append("\n方向:");
            stringBuilder.append(newLocation.getBearing());
            stringBuilder.append(newLocation.getLongitude());
            stringBuilder.append("\n速度:");
            stringBuilder.append(newLocation.getSpeed());
            stringBuilder.append(newLocation.getLongitude());
            stringBuilder.append("\n精度:");
            stringBuilder.append(newLocation.getAccuracy());
            stringBuilder.append(newLocation.getLongitude());
            stringBuilder.append("\n时间:");
            stringBuilder.append(newLocation.getTime());

            tv31.setText(stringBuilder.toString());

        }
    }

}


