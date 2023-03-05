package com.example.vkclocks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar calendar = Calendar.getInstance();

        TextView dateText = findViewById(R.id.date);
        TextView timeText = findViewById(R.id.time);

        TextView dateText2 = findViewById(R.id.date2);
        TextView timeText2 = findViewById(R.id.time2);

        TextView dateText3 = findViewById(R.id.date3);
        TextView timeText3 = findViewById(R.id.time3);

        String date = String.valueOf(calendar.get(Calendar.DATE));
        String time = String.valueOf(calendar.get(Calendar.HOUR)) + ":" + String.valueOf(calendar.get(Calendar.MINUTE)) + ":" + String.valueOf(calendar.get(Calendar.SECOND));
        dateText.setText(date);
        timeText.setText(time);

        dateText2.setText(date);
        timeText2.setText(time);

        dateText3.setText(date);
        timeText3.setText(time);
    }

    public void changeActivity(Class<?> c) {
        startActivity(new Intent(this, c));
    }

}