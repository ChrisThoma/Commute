package com.christhoma.commuted;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageSwitcher;
import android.widget.SeekBar;

public class ProgressActivity extends AppCompatActivity {

    private static final String TAG = "ProgressActivity";
    ImageSwitcher imageSwitcher;
    SeekBar seekBar;
    int seekbarPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        imageSwitcher = findViewById(R.id.image_switcher);
        seekBar = findViewById(R.id.seek_bar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (i != seekbarPosition + 1) {
                    seekBar.setProgress(seekbarPosition);
                } else {
                    seekbarPosition = i;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
