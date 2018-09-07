package com.example.davidsrn.exam;

import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;



public class Player1 extends AppCompatActivity {

    private Button buttonMgr1;
    private Button buttonMgr2;
    private Button buttonMgr3;
    private Button buttonMgr4;

    private Random myRandom = new Random();
    private int p2_result;
    private int p1_result;

    public int p1_wins=0;
    public int p2_wins=0;
    String myInput="1";


    private TextView p2;
    private TextView p1;
    private TextView res;
    private TextView board;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player1);

        buttonMgr1=findViewById(R.id.button);
        buttonMgr2=findViewById(R.id.button2);
        buttonMgr3=findViewById(R.id.button3);
        buttonMgr4=findViewById(R.id.button4);

        buttonMgr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1=new Intent(Player1.this, Player1.class);
//                intent1.putExtra("input", "1");
//                startActivity(intent1);
                get_results(1);
            }
        });
        buttonMgr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent2=new Intent(Player1.this, Player1.class);
//                intent2.putExtra("input", "2");
//                startActivity(intent2);
                get_results(2);


            }
        });
        buttonMgr3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent3=new Intent(Player1.this, Player1.class);
//                intent3.putExtra("input", "3");
//                startActivity(intent3);
                get_results(3);


            }
        });

        buttonMgr4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent2=new Intent(Player1.this, Player1.class);
//                intent2.putExtra("input", "2");
//                startActivity(intent2);
                reset();


            }
        });

        p2 = findViewById(R.id.textView2);
        p1 = findViewById(R.id.textView3);
        res = findViewById(R.id.textView4);
        board = findViewById(R.id.textView5);





    }
    public void get_results(int p1_result){
        p2_result = myRandom.nextInt(3) + 1;

        if(p2_result==1){
            p2.setText("P2= ROCK");
        }else if(p2_result==2){
            p2.setText("P2= PAPER");
        }else{
            p2.setText("P2= SCISSORS");
        }
        Intent intent = getIntent();
//        String myInput = intent.getStringExtra("input");


        if(p1_result==1){
            p1.setText("P1= ROCK");
        }else if(p1_result==2){
            p1.setText("P1= PAPER");
        }else{
            p1.setText("P1= SCISSORS");
        }


        if(p1_result == p2_result){
            res.setText("DRAW");
        } else if ((p1_result == 1 && p2_result == 3) ||
                (p1_result == 2 && p2_result == 1) ||
                (p1_result == 3 && p2_result==2)){
            res.setText("P1 WINS");
            p1_wins+=1;
            Toast.makeText(Player1.this,
                    "P1 WINS!!!!!!!!!!!!!!!!!", Toast.LENGTH_LONG).show();
            long pattern[]={900, 800, 900, 800, 900}; // or you can just set a duration also in ms
            Vibrator vibrator = (Vibrator)getSystemService(Player1.VIBRATOR_SERVICE);
            vibrator.vibrate(pattern, -1);

        } else {
            res.setText("P2 WINS");
            p2_wins+=1;
            Toast.makeText(Player1.this,
                    "P2 WINS!!!!!!!!!!!!!!!!!", Toast.LENGTH_LONG).show();
        }

        board.setText("P1 wins: "+p1_wins +" P2 wins: "+ p2_wins);
    }

    public void reset(){
        p1_wins = 0;
        p2_wins = 0;
        board.setText("P1 wins: "+p1_wins +" P2 wins: "+ p2_wins);

    }
}

