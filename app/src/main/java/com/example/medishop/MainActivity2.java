package com.example.medishop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    private EditText ename,eage,ebg,epn;
    private Button signUpButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ename=findViewById(R.id.name);
        eage=findViewById(R.id.age);
        ebg=findViewById(R.id.BG);
       epn=findViewById(R.id.editTextTextPersonName5);
        signUpButton = findViewById(R.id.button2);

        signUpButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String name = ename.getText().toString();
                String age = eage.getText().toString();
                String bg = ebg.getText().toString();
                String pn = epn.getText().toString();

                // Create intent to start next activity
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);

                // Pass user details as extra data
                intent.putExtra("username", name);
                intent.putExtra("age", age);
                intent.putExtra("Blood Group", bg);
                intent.putExtra("Phone Number", pn);


                // Start next activity
                startActivity(intent);
            }
        });
    }
}