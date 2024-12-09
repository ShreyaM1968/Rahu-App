package com.example.rahuapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private boolean isDescriptionVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textViewRahuKaal = findViewById(R.id.textViewRahuKaal);
        TextView textViewDescription = findViewById(R.id.textViewDescription);
        Button buttonToggleDescription = findViewById(R.id.buttonToggleDescription);

        // Get current day of the week
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        // Define Rahu Kaal timings for each day
        Map<Integer, String> rahuKaalTimings = new HashMap<>();
        rahuKaalTimings.put(Calendar.MONDAY, "7:30 AM to 9:00 AM");
        rahuKaalTimings.put(Calendar.TUESDAY, "3:00 PM to 4:30 PM");
        rahuKaalTimings.put(Calendar.WEDNESDAY, "12:00 PM to 1:30 PM");
        rahuKaalTimings.put(Calendar.THURSDAY, "1:30 PM to 3:00 PM");
        rahuKaalTimings.put(Calendar.FRIDAY, "10:30 AM to 12:00 PM");
        rahuKaalTimings.put(Calendar.SATURDAY, "9:00 AM to 10:30 AM");
        rahuKaalTimings.put(Calendar.SUNDAY, "4:30 PM to 6:00 PM");

        // Get Rahu Kaal timing for the current day
        String rahuKaal = rahuKaalTimings.get(dayOfWeek);
        textViewRahuKaal.setText("Rahu Kaal: " + rahuKaal);

        // Set up the button to toggle the description visibility
        buttonToggleDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDescriptionVisible) {
                    textViewDescription.setVisibility(View.GONE);
                    buttonToggleDescription.setText("Show Description");
                } else {
                    textViewDescription.setVisibility(View.VISIBLE);
                    buttonToggleDescription.setText("Hide Description");
                }
                isDescriptionVisible = !isDescriptionVisible;
            }
        });
    }
}
