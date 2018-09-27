package com.example.peterphchen.raw_asset_dataparsing;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView1 = findViewById(R.id.textView1);
        TextView textView2 = findViewById(R.id.textView2);
        AssetManager assetManager = getAssets();
        String line;
        StringBuilder sb = new StringBuilder();
        try {
            InputStream  inputStream = assetManager.open("test.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            while((line=br.readLine()) != null){
                sb.append(line);
            }
        }catch (IOException e){
            Log.e(TAG, "onCreate: "+e.getMessage() );
        }
        textView1.setText(sb.toString());


        StringBuilder sb2 = new StringBuilder();
        try {
            InputStream  inputStream = getResources().openRawResource(R.raw.raw);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            while((line=br.readLine()) != null){
                sb2.append(line);
            }
        }catch (IOException e){
            Log.e(TAG, "onCreate: "+e.getMessage() );
        }
        textView2.setText(sb2);
    }
}
