package com.example.davidsrn.lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    private TextView mytextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        mytextview=findViewById(R.id.textView4);
        Intent intent = getIntent();
        String myString = intent.getStringExtra("message");
        mytextview.setText(myString);
    }
}
