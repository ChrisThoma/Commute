package com.christhoma.commuted;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import com.christhoma.commuted.widget.PicassoSwitcher;

public class ProgressActivity extends AppCompatActivity {

    private static final String TAG = "ProgressActivity";
    static final String TIME_EXTRA_KEY = "TIME_EXTRA_KEY";
    PicassoSwitcher imageSwitcher;
    SeekBar seekBar;
    ImageView trafficImage;
    int seekbarPosition = 0;
    int time = -1;
    int waitTime;
    boolean progressAllowed = true;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        trafficImage = findViewById(R.id.traffic_image);

        initializeImageSwitcher();
        initializeSeekbar();

        Intent intent = getIntent();
        if (intent != null) {
            time = intent.getIntExtra(TIME_EXTRA_KEY, -1);
            waitTime = 1000 * (time / seekBar.getMax());
        }
        if (time == -1) {
            finish();
            //something went wrong
        }

        initializeState();
    }

    private void initializeImageSwitcher() {
        imageSwitcher = findViewById(R.id.image_switcher);
        Animation animationIn = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        Animation animationOut = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
        imageSwitcher.setInAnimation(animationIn);
        imageSwitcher.setOutAnimation(animationOut);
        imageSwitcher.setFactory(() -> {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(
                    new ImageSwitcher.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT));
            return imageView;
        });
    }

    private void initializeSeekbar() {
        seekBar = findViewById(R.id.seek_bar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int position, boolean b) {
                if (!progressAllowed || position != seekbarPosition + 1) {
                    seekBar.setProgress(seekbarPosition);
                    attemptShowToast();
                } else {
                    seekbarPosition = position;
                    progressAllowed = false;
                    trafficImage.setImageResource(R.drawable.ic_wait);
                    setImage(position);
                    seekBar.postDelayed(() -> {
                        progressAllowed = true;
                        trafficImage.setImageResource(R.drawable.ic_continue);
                    }, waitTime);
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

    private void initializeState() {
        progressAllowed = false;
        seekBar.postDelayed(() -> {
            progressAllowed = true;
            trafficImage.setImageResource(R.drawable.ic_continue);
        }, waitTime);
        imageSwitcher.setImageResource(ImageProvider.getImageForBucket(1));
    }

    private void setImage(int position) {
        imageSwitcher.setImageResource(ImageProvider.getImageForBucket(position + 1));
    }

    private void attemptShowToast() {
        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(this, R.string.stuck_toast_text, Toast.LENGTH_SHORT);
        toast.show();
    }
}
