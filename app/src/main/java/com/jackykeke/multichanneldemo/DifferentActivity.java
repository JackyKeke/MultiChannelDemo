package com.jackykeke.multichanneldemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DifferentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_different);

        findViewById(R.id.image).setOnClickListener(v -> {
            Toast.makeText(this,"这是"+findViewById(R.id.image).getTag(),Toast.LENGTH_SHORT).show();
        });
    }
}