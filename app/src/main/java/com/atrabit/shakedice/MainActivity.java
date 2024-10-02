package com.atrabit.shakedice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView diceImage1 = findViewById(R.id.imgDice1);
        ImageView diceImage2 = findViewById(R.id.imgDice2);
        LinearLayout diceSurface = findViewById(R.id.dice_surface);

        int [] diceImages = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};

        Button btnRoll = findViewById(R.id.btnRoolTheDice);
        MediaPlayer mp = MediaPlayer.create(this, R.raw.rolling_dice);
        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                //Log.i("MyDiceApp", "btnRoll is tapped now");
                int imageWidth = diceImage1.getWidth();
                int imageHeight = diceImage1.getHeight();
                int diceField = diceSurface.getHeight();

                //Toast.makeText(MainActivity.this, "Height is "+ diceField + "", Toast.LENGTH_SHORT).show();

                Random rndObject = new Random();
                while (true) {
                    if (!mp.isPlaying()) break;

                }
                int myRandomNumber = rndObject.nextInt(6); // 0 ..6
                //Log.i("MyDiceApp", "myRandomNumber " + myRandomNumber + "");

                mp.start();

                YoYo.with(Techniques.Shake )
                        .duration(900)
                        .repeat(0)
                        .playOn(diceImage1);
                YoYo.with(Techniques.Shake)
                        .duration(900)
                        .repeat(0)
                        .playOn(diceImage2);

                diceImage1.setImageResource(diceImages[myRandomNumber]);
                diceImage1.setPivotX(imageWidth/2 + rndObject.nextInt(imageWidth/4));
                diceImage1.setPivotY(imageHeight/2 + rndObject.nextInt(imageHeight/4));
                diceImage1.setRotation(rndObject.nextInt(359));



                myRandomNumber = rndObject.nextInt(6);

                diceImage2.setImageResource(diceImages[myRandomNumber]);
                diceImage2.setPivotX(imageWidth/2 + rndObject.nextInt(imageWidth/4));
                diceImage2.setPivotY(imageHeight/2 + rndObject.nextInt(imageHeight/4));
                diceImage2.setRotation(rndObject.nextInt(359));




            }
        });

    }
}