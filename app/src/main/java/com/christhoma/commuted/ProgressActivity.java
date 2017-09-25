package com.christhoma.commuted;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.List;

public class ProgressActivity extends AppCompatActivity {

    private static final String TAG = "ProgressActivity";
    ImageSwitcher imageSwitcher;
    SeekBar seekBar;
    int seekbarPosition = 0;
    List<ImageView> images = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        imageSwitcher = findViewById(R.id.image_switcher);
        imageSwitcher.setFactory(() -> new ImageView(this));
        seekBar = findViewById(R.id.seek_bar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int position, boolean b) {
                if (position != seekbarPosition + 1) {
                    seekBar.setProgress(seekbarPosition);
                } else {
                    seekbarPosition = position;
                    setImage(position);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        setImage(0);
    }

    private void setImage(int position) {
        switch (position) {
            case 0:
                imageSwitcher.setImageDrawable(getDrawable(R.drawable.img_1));
                break;
            case 1:
                imageSwitcher.setImageDrawable(getDrawable(R.drawable.img_2));
                break;
            case 2:
                imageSwitcher.setImageDrawable(getDrawable(R.drawable.img_3));
                break;
            case 3:
                imageSwitcher.setImageDrawable(getDrawable(R.drawable.img_4));
                break;
            case 4:
                imageSwitcher.setImageDrawable(getDrawable(R.drawable.img_5));
                break;
            case 5:
                imageSwitcher.setImageDrawable(getDrawable(R.drawable.img_6));
                break;
            case 6:
                imageSwitcher.setImageDrawable(getDrawable(R.drawable.img_7));
                break;
            case 7:
                imageSwitcher.setImageDrawable(getDrawable(R.drawable.img_8));
                break;
            case 8:
                imageSwitcher.setImageDrawable(getDrawable(R.drawable.img_9));
                break;
            default:
        }
    }
}
