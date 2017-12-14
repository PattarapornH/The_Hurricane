package com.mygdx.game;

import com.badlogic.gdx.Gdx;

import java.util.Random;

public class World {
    //private float count;
    private float totalTime = 60;
    private float deltaTime ;
    private int sec;
    private int randItem;
    private int randX;
    Random random = new Random();

    public void World() {

    }

    public void Timer(){
        deltaTime = Gdx.graphics.getDeltaTime();
        totalTime -= deltaTime;
        sec = (int)(totalTime % 60);
        System.out.println(sec);
    }

    public int RandomItem(){
        if(sec - (int)(totalTime%60) > 1){
            randItem = random.nextInt(2);
        }
        return randItem;
    }
    public int RandomXPosition(){
        if(sec - (int)(totalTime%60) > 1){
            randX = random.nextInt(2);
        }
        return randX;
    }
}
