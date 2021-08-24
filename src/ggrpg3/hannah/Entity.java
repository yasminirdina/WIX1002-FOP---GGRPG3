
package ggrpg3.hannah;

import ggrpg3.Game;
import ggrpg3.GetEverything;
import java.awt.Graphics;
import java.awt.Rectangle;


public abstract class Entity {
    protected GetEverything everything;
    protected float x,y;
    protected int width,height;
    protected Rectangle boundary;
    
    public Entity (GetEverything everything, float x,float y,int width, int height){
        this.everything = everything;
        this.x = x; //position
        this.y = y; //position
        this.width= width;
        this.height = height;
        
        boundary = new Rectangle(0, 0, width, height);
    }
    public abstract void tick ();
    
    public abstract void render (Graphics g);

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
