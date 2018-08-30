package com.example.davidsrn.lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private Button buttonMgr1;
    private Button buttonMgr2;
    private Button buttonMgr3;
    private EditText editTextMgr;
    private TextView txtViewMgr;
    private String message;

@Override
protected void onCreate(Bundle savedInstanceState) {


    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    buttonMgr1=findViewById(R.id.button4);
    buttonMgr2=findViewById(R.id.button5);
    buttonMgr3=findViewById(R.id.button6);
    editTextMgr=findViewById(R.id.editText2);
    txtViewMgr = findViewById(R.id.textView3);

    buttonMgr1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intentC1=new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intentC1);
        }
    });

    buttonMgr2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            message=editTextMgr.getText().toString();

            Intent intentC2=new Intent(MainActivity.this, Main3Activity.class);
            intentC2.putExtra("message", message);
            startActivity(intentC2);
        }
    });

    buttonMgr3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            txtViewMgr.setText("U CHANGED ME (O//w//O)");
        }
    });
    }
}