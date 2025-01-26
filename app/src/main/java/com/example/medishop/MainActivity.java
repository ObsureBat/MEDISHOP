package com.example.medishop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(view -> {
            Toast.makeText(this, "Moving To Register Page", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent( this, MainActivity2.class);
            startActivity(intent);
        });
    }
}