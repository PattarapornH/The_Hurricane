package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.Random;

public class World {
    public float totalTime = 20;
    private float deltaTime;
    public int sec;
    private int score = 0;
    private int xUmb;

    int [] xFallPos = new int[4];
    int [] yFallPos = new int[4];
    Texture[] itemsFall = new Texture[4];

    private Texture drop;
    private Texture light;

    Random random = new Random();
    WorldRenderer worldRenderer;
    TheHurricane theHurricane;

    public void World(WorldRenderer worldRenderer) {
        this.theHurricane = new TheHurricane();
        this.worldRenderer = new WorldRenderer(this.theHurricane,this);
        drop = new Texture("drop.png");
        light = new Texture("lightning.png");
    }


    public void Timer() {
        deltaTime = Gdx.graphics.getDeltaTime();
        sec = (int) (totalTime % 60);
        totalTime -= deltaTime;
        //return sec;
    }

    public int random(int rand) {
        rand = random.nextInt(2);
        return rand;
    }

}