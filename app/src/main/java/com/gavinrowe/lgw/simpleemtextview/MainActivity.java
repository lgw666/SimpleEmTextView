package com.gavinrowe.lgw.simpleemtextview;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.annotation.ColorInt;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gavinrowe.lgw.library.SimpleEmTextView;

public class MainActivity extends AppCompatActivity {
    private SimpleEmTextView mEmTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEmTv = (SimpleEmTextView) findViewById(R.id.em_tv);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                setBgTv("文字", 30, ContextCompat.getColor(MainActivity.this, R.color.colorAccent), Typeface.ITALIC);
            }
        }, 1500);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                setBgTv("颜色", 28, Color.BLACK, Typeface.BOLD);
            }
        }, 2500);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                setBgTv("大小", 30, 0xFFFF0000, Typeface.NORMAL);
            }
        }, 3500);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                setBgTv("by国哥", 40, Color.RED, Typeface.BOLD_ITALIC);
            }
        }, 4500);

    }

    private void setBgTv(String emText, int emTextSize, @ColorInt int emTextColor, int emTextStyle) {
        mEmTv.setEmText(emText);
        mEmTv.setEmTextSize(emTextSize);
        mEmTv.setEmTextColor(emTextColor);
        mEmTv.setEmTextStyle(emTextStyle);
    }
}
