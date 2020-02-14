package com.guptaamey.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    SharedPreferences.Editor editor = sharedPreferences.edit();

    TextView a;
    TextView b;
    TextView c;
    TextView d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a = findViewById(R.id.leftTop);
        b = findViewById(R.id.rightTop);
        c = findViewById(R.id.leftBottom);
        d = findViewById(R.id.rightBottom);

        int temp = 0;
        editor.putInt("leftTopCtr", temp);
        editor.putInt("rightTopCtr", temp);
        editor.putInt("leftBottomCtr", temp);
        editor.putInt("rightBottomCtr", temp);
        editor.apply();

        Listener x = new Listener();
        a.setOnClickListener(x);
        b.setOnClickListener(x);
        c.setOnClickListener(x);
        d.setOnClickListener(x);

    }
    private class Listener implements View.OnClickListener {

        TextView tv;

        @Override
        public void onClick(View v) {
            tv = (TextView) v;
            tv.setBackgroundColor(-65536);

            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    int ctr = sharedPreferences.getInt( tv., 0);
                    editor.remove();

                    tv.setText(ctr);
                    tv.setBackgroundColor(-16777216);

                }
            }, 500);
        }
    }

}

