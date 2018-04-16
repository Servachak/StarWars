package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by adavi on 15.04.2018.
 */
public class Asteroid {
    Texture texture;
    Vector2 position;
    float speed;
    Rectangle hitBox;

    public Asteroid() {
        texture = new Texture("meteorito.jpg");
        position = new Vector2(
                MathUtils.random(1280,2560),
                MathUtils.random(0,720));
        hitBox = new Rectangle(position.x,position.y, 64,64);
        speed = MathUtils.random(3.0f,5.0f);
    }
    public void render(SpriteBatch batch){
        batch.draw(texture,position.x,position.y);
    }
    public void update(){
        position.x -= speed;
        if (position.x < -100){
            recreate();
        }
        hitBox.setPosition(position);
    }

    public void recreate() {
        position.x = MathUtils.random(1280,2560);
        position.y = MathUtils.random(0,720);
        speed = MathUtils.random(3.0f,6.0f);

    }
}
