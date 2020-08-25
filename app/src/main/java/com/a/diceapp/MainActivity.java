package com.a.diceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> imageList = new ArrayList<Integer>();

    ImageView iv_dice_image1, iv_dice_image2;
    Button btn_roll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addImageToList();
        initViews();
        setListener();
    }

    private void initViews(){
        iv_dice_image1 = findViewById(R.id.iv_dice_image1);
        iv_dice_image2 = findViewById(R.id.iv_dice_image2);
        btn_roll = findViewById(R.id.btn_roll);
    }

    private void setListener(){
        btn_roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollDices();
            }
        });
    }

    private void rollDices(){
        try {
            iv_dice_image1.setImageResource(imageList.get(getRandomInt()));
            iv_dice_image2.setImageResource(imageList.get(getRandomInt()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private int getRandomInt(){
        return ThreadLocalRandom.current().nextInt(0,5);
    }

    private void addImageToList(){
        imageList.add(R.drawable.dice1);
        imageList.add(R.drawable.dice2);
        imageList.add(R.drawable.dice3);
        imageList.add(R.drawable.dice4);
        imageList.add(R.drawable.dice5);
        imageList.add(R.drawable.dice6);
    }
}