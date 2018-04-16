package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by adavi on 15.04.2018.
 */
public class Bullet {
    Texture  texture;
    Vector2 position;
    float speed;
    boolean active;

    public Bullet() {

        position = new Vector2(0,0);
        speed = 10.0f;
        active = false;
    }
    public void activate(float x, float y){
        position.set(x,y);
        active = true;
    }
    public void deactivate(){
        active = false;
    }
    public void update(){
        position.x +=speed;
        if (position.x > 1280){
            deactivate();
        }
    }
}
