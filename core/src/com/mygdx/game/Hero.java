package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by adavi on 15.04.2018.
 */
public class Hero {
    Texture texture;
    Vector2 position;
    float speed;
    int fireCounter;

    public Hero() {
        texture = new Texture("roket.png");
        position = new Vector2(100,250);
        speed = 10.0f;
        fireCounter = 0;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }

    public void checkKeys(){
        if (Gdx.input.isKeyPressed(Input.Keys.S)){
            position.y -=speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)){
            position.y +=speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)){
            position.x -=speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)){
            position.x +=speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.ALT_RIGHT)){
            fireCounter++;

        if (fireCounter >= 6) {
            fireCounter = 0;
            fire();
        }
        }
    }

    public void update(){

        checkKeys();

        if (position.x < -20){
            position.x = 1200;
        }
        if (position.x > 1300){
            position.x = 0;
        }
        if (position.y > 740){
            position.y = 0;
        }
        if (position.y < -10){
            position.y = 720;
        }
        if (Gdx.input.isTouched()){
            if (Gdx.input.getX() < position.x + 32) {
                position.x -= speed;
            }
            if (Gdx.input.getX() > position.x + 32){
                position.x += speed;
            }
        }
    }
    public void fire(){

        for (int i = 0; i < MyGdxGame.bullets.length; i++) {
            if (!MyGdxGame.bullets[i].active){
                MyGdxGame.bullets[i].activate(position.x +  100,
                        position.y + 20);
                break;
            }
        }
    }
}
