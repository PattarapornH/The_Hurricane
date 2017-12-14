package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameScreen extends ScreenAdapter{
    public SpriteBatch batch;
    private TheHurricane TheHurricane;
    private Texture drop;
    private Texture umbrella;
    private Texture light;
    private Texture bg;
    private int xUmb;
    private int yDrop;
    private int yLight;
    private  int speed;
    private int rand1;
    private int rand2;
    private List<Texture> fuckpatt;
    Random random = new Random();

    public GameScreen(TheHurricane TheHurricane) {
        this.TheHurricane = TheHurricane;
        umbrella = new Texture("umbrella.png");
        drop = new Texture("drop.png");
        light = new Texture("lightning.png");
        fuckpatt = new ArrayList<Texture>();
        fuckpatt.add(drop);
        fuckpatt.add(light);
        bg = new Texture("bg.png");
        xUmb = 100;
        yDrop = 700;
        yLight = 700;
        speed = 5;
        rand1 = random.nextInt(2);
        rand2 = random.nextInt(2);

    }

    public void render (float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        update(delta);
        SpriteBatch batch = TheHurricane.batch;
        batch.begin();
        batch.draw(bg,0,0);
        batch.draw(umbrella, xUmb, 0);
        batch.draw(fuckpatt.get(rand1), 125, yDrop);
        batch.draw(fuckpatt.get(rand2),270,yLight);
        batch.end();
    }

    private void update(float delta) {

//        System.out.print(rand);
  //      System.out.print("\n");
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            xUmb = 100;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            xUmb = 250;
        }
        yDrop -= speed;
        yLight -= speed;
        if(yDrop == -100){
            rand1 = random.nextInt(2);
            rand2 = random.nextInt(2);
            yDrop = 700;
        }
        if(yLight == -100) {
            yLight = 700;
        }
    }
}
