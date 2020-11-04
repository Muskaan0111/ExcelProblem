package com.example.excelprob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.excelprob.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
         ActivityMainBinding b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        b.buttonByColumn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openByColumnActivity();
            }
        });

        b.buttonByRange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openByRangeActivity();
            }
        });




    }

    private void openByRangeActivity() {

        Intent intent = new Intent(this, ByRange.class);
        startActivity(intent);



    }

    private void openByColumnActivity() {
        Intent intent = new Intent(this, ByColumn.class);
        startActivity(intent);
    }
}