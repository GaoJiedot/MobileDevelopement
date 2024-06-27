package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import java.util.Locale;

public class Run extends AppCompatActivity {

    private Button startButton, pauseButton, endButton;
    private TextView timeTextView;
    private long startTime = 0L;
    private long timeInMilliseconds = 0L;
    private long timeSwapBuff = 0L;
    private long updatedTime = 0L;
    private Handler handler = new Handler();
    private boolean isPaused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.run);

        startButton = findViewById(R.id.start);
        pauseButton = findViewById(R.id.pause);
        endButton = findViewById(R.id.end);
        timeTextView = findViewById(R.id.time_tv); // 确保在布局中添加这个 TextView

        startButton.setOnClickListener(v -> startTimer());
        pauseButton.setOnClickListener(v -> pauseTimer());
        endButton.setOnClickListener(v -> endTimer());

        // 初始状态
        pauseButton.setVisibility(View.INVISIBLE);
        endButton.setVisibility(View.INVISIBLE);
    }

    private void startTimer() {
        if (!isPaused) {
            startTime = SystemClock.uptimeMillis();
        } else {
            startTime = SystemClock.uptimeMillis() - timeInMilliseconds;
            isPaused = false;
        }
        handler.postDelayed(updateTimerThread, 0);

        startButton.setVisibility(View.INVISIBLE);
        pauseButton.setVisibility(View.VISIBLE);
        endButton.setVisibility(View.VISIBLE);
    }

    private void pauseTimer() {
        timeSwapBuff += timeInMilliseconds;
        handler.removeCallbacks(updateTimerThread);
        isPaused = true;

        startButton.setVisibility(View.VISIBLE);
        pauseButton.setVisibility(View.INVISIBLE);
        endButton.setVisibility(View.INVISIBLE);
    }

    private void endTimer() {
        handler.removeCallbacks(updateTimerThread);
        // 跳转到 SportPlanFragment
        Intent intent = new Intent(Run.this, SportPlan.class);
        intent.putExtra("totalTime", updatedTime); // 可以传递总时间到 SportPlanFragment
        startActivity(intent);
        finish(); // 结束当前 Activity
    }

    private Runnable updateTimerThread = new Runnable() {
        public void run() {
            timeInMilliseconds = SystemClock.uptimeMillis() - startTime;
            updatedTime = timeSwapBuff + timeInMilliseconds;

            int secs = (int) (updatedTime / 1000);
            int mins = secs / 60;
            secs = secs % 60;
            int milliseconds = (int) (updatedTime % 1000);

            timeTextView.setText(String.format(Locale.getDefault(),
                    "%02d:%02d:%03d", mins, secs, milliseconds));

            handler.postDelayed(this, 0);
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(updateTimerThread);
    }
}