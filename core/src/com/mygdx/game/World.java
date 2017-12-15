package com.mygdx.game;

import com.badlogic.gdx.Gdx;

import java.util.Random;

public class World {
    private float totalTime = 60;
    private float deltaTime;
    private int sec;
    private int count = 0;

    Random random = new Random();

    WorldRenderer worldRenderer;

    public void World() {
        //this.worldRenderer = new WorldRenderer();
    }

    public void Timer() {
        deltaTime = Gdx.graphics.getDeltaTime();
        sec = (int) (totalTime % 60);
        totalTime -= deltaTime;
    }

    public int random(int rand) {
        //if(sec - (int)totalTime >= 1) {
            rand = random.nextInt(2);
            //System.out.println("a");
        //}
        return rand;
    }
}