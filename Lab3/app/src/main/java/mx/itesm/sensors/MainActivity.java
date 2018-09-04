package mx.itesm.sensors;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();
        Button vibButton =findViewById(R.id.button_to_vib);
        vibButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentC1=new Intent(MainActivity.this, VibrationScreen.class);
                startActivity(intentC1);
            }
        });

        Button closeUpButton =findViewById(R.id.button_to_close_up);
        closeUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentC1=new Intent(MainActivity.this, CloseUp.class);
                startActivity(intentC1);
            }
        });


    }
}

