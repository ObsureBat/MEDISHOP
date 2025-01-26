package com.example.medishop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class MainActivity3 extends AppCompatActivity {
    private TextView name,age,bg,pn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        bg = findViewById(R.id.BG);
        pn = findViewById(R.id.editTextTextPersonName5);

        // Retrieve user details from intent
        Intent intent = getIntent();
        String fname = intent.getStringExtra("username");
        String fage = intent.getStringExtra("age");
        String fbg = intent.getStringExtra("Blood Group");
        String fpn = intent.getStringExtra("Phone Number");

        // Display user details
        name.setText( fname);
        age.setText(fage);
        bg.setText(fbg);
        pn.setText(fpn);

        HashMap<String,String> map = new HashMap<>();
        EditText inpBox = findViewById(R.id.inpBox);

        JSONObject data = loadJSONObjectFromRaw(this,R.raw.data);

        try {
            JSONArray all = data.getJSONArray("data");
            for(int i = 0;i<all.length();i++){
                JSONObject item = all.getJSONObject(i);
                map.put(item.getString("symptoms"),item.getString("Medicine"));
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        TextView result = findViewById(R.id.result);


        findViewById(R.id.search).setOnClickListener(view -> {
            result.setText(map.get(inpBox.getText().toString()));
        });

    }

    public JSONObject loadJSONObjectFromRaw(Context context, int resourceId) {
        JSONObject jsonObject = null;
        try {
            InputStream inputStream = context.getResources().openRawResource(resourceId);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            String jsonString = new String(buffer, "UTF-8");
            jsonObject = new JSONObject(jsonString);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

}