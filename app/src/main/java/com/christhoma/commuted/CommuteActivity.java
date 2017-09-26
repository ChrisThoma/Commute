package com.christhoma.commuted;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class CommuteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commute);

        final int time = (int) (Math.random() * (120 - 60)) + 60;

        Button startButton = findViewById(R.id.start_button);
        startButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, ProgressActivity.class);
            intent.putExtra(ProgressActivity.TIME_EXTRA_KEY, time);
            startActivity(intent);
        });

        TextView etaText = findViewById(R.id.eta_text);
        etaText.setText(getString(R.string.eta_string, time));
    }
}
