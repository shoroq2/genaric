package com.example.travelplanning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the buttons by their IDs
        Button loginButton = findViewById(R.id.bt1);
        Button travelPlanning1Button = findViewById(R.id.bt2);
        Button travelPlanning2Button = findViewById(R.id.bt3);

        // Set click listener for the Login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the LoginActivity when the Login button is clicked
                Intent intent = new Intent(MainActivity.this, login.class);
                startActivity(intent);
            }
        });

        // Set click listener for the Travel Planning 1 button
        travelPlanning1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the TravelPlanning1Activity when the button is clicked
                Intent intent = new Intent(MainActivity.this, Travel.class);
                startActivity(intent);
            }
        });

        // Set click listener for the Travel Planning 2 button
        travelPlanning2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the TravelPlanning2Activity when the button is clicked
                Intent intent = new Intent(MainActivity.this, Travel2.class);
                startActivity(intent);
            }
        });
    }
}