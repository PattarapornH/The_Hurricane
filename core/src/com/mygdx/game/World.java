package com.mygdx.game;

import com.badlogic.gdx.Gdx;

import java.util.Random;

public class World {
    private float count = 0;
    private float totalTime = 60;
    private float deltaTime;
    private int sec;
    private int randItem;
    private int randX;

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
        rand = random.nextInt(2);
        return rand;
    }
}