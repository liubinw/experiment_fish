package com.amazon.experimentfish;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
//import android.widget.ScrollView;
import android.widget.TextView;
import android.content.Context;
//import android.os.PowerManager;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private final boolean DEBUG = true;
    private final String TAG = "experiment_fish";
    private TextView textViewDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // coding starts here
        Context context = this;

        // Find the button and text view references
        Button buttonClick = findViewById(R.id.button_click);
        Button buttonClean = findViewById(R.id.button_clean);
        textViewDisplay = findViewById(R.id.textView_display);

        PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
        //boolean hasPowerStatsHal = powerManager.isPowerStatsSupported();

        // PowerManager powerManager = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        //PowerManager.PowerStats powerStats = powerManager.getPowerStats();

        //double powerUsage = powerStats.totalPowerMaUs / 1000000.0;
        //System.out.println("System Power Usage: " + powerUsage + " W");

        // Set the click listener for the button
        buttonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "button clicked");
                displayMessageInScrollView("You clicked the button");
            }
        });

        buttonClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "button clean");
                textViewDisplay.setText("");
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void displayMessageInScrollView(String message) {
        // Create a new TextView and set the message
        textViewDisplay.setText(textViewDisplay.getText() + "\nYou clicked the button");
    }
}