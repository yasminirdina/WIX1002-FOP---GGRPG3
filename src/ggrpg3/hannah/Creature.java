package ggrpg3.hannah;

import ggrpg3.Game;
import ggrpg3.GetEverything;
import ggrpg3.gfx.Sound;
import ggrpg3.tiles.Tile;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public abstract class Creature extends Entity {

    public static final int DEFAULT_HEALTH = 10;
    public static final float DEFAULT_SPEED = 1.0f; //3.0f  (boleh adjust nanti) 
    public static final int DEFAULT_CREATURE_WIDTH = 64,
            DEFAULT_CREATURE_HEIGHT = 64;

    protected int health = 100;
    protected float speed;
    protected float xMove, yMove;

    // for combat system usage
    private Combat you = new Combat(health, 50, 1, "ali");
    private Combat chicken = new Combat(150, 25, 1, "jahat");
    private WisePanda panda = new WisePanda();


    public Creature(GetEverything everything, float x, float y, int width, int height) {
        super(everything, x, y, width, height);
        health = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;

    }

    // measuring how many tiles you passed through
    // x-axis, or width
    public void moveX() throws InterruptedException {
        // moving right
        // using (int)(variables) because, float conversion to int
        if (xMove > 0) {
            int tx = (int) (x + xMove + boundary.x + boundary.width) / Tile.TILEWIDTH;
            // position + movement + size player 64 + size player 64 / tilewidth 64

            if (!collisionWithTile(tx, (int) (y + boundary.y) / Tile.TILEHEIGHT)
                    && !collisionWithTile(tx, (int) (y + boundary.y + boundary.height) / Tile.TILEHEIGHT)) {
                x += xMove;
            }

            if (interactionWithNPC(tx, (int) (y + boundary.y) / Tile.TILEWIDTH)
                    && interactionWithNPC(tx, (int) (y + boundary.y + boundary.width) / Tile.TILEWIDTH)) {
                WisePanda.display();
                panda.dialogue1();
            }

            if (interactionWithEnemy(tx, (int) (y + boundary.y) / Tile.TILEWIDTH)
                    && interactionWithEnemy(tx, (int) (y + boundary.y + boundary.width) / Tile.TILEWIDTH)) {
                Combat.battle(you, chicken);
                everything.getWorld();

            }

        } else if (xMove < 0) {//Moving left
            int tx = (int) (x + xMove + boundary.x) / Tile.TILEWIDTH;

            if (!collisionWithTile(tx, (int) (y + boundary.y) / Tile.TILEHEIGHT)
                    && !collisionWithTile(tx, (int) (y + boundary.y + boundary.height) / Tile.TILEHEIGHT)) {
                x += xMove;
            }

            if (interactionWithNPC(tx, (int) (y + boundary.y) / Tile.TILEWIDTH)
                    && interactionWithNPC(tx, (int) (y + boundary.y + boundary.width) / Tile.TILEWIDTH)) {
                WisePanda.display();
                panda.dialogue1();
            }

            if (interactionWithEnemy(tx, (int) (y + boundary.y) / Tile.TILEWIDTH)
                    && interactionWithEnemy(tx, (int) (y + boundary.y + boundary.width) / Tile.TILEWIDTH)) {
                Combat.battle(you, chicken);
                everything.getWorld();
            }

        }
    }

// measuring how many tiles you passed through (y-axis)
    public void moveY() throws InterruptedException {

        if (yMove < 0) {//Up
            int ty = (int) (y + yMove + boundary.y) / Tile.TILEHEIGHT;

            if (!collisionWithTile((int) (x + boundary.x) / Tile.TILEWIDTH, ty)
                    && !collisionWithTile((int) (x + boundary.x + boundary.width) / Tile.TILEWIDTH, ty)) {
                y += yMove;
            }

            if (interactionWithNPC((int) (x + boundary.x) / Tile.TILEWIDTH, ty)
                    && interactionWithNPC((int) (x + boundary.x + boundary.width) / Tile.TILEWIDTH, ty)) {
                WisePanda.display();
                panda.dialogue1();
            }

            if (interactionWithEnemy((int) (x + boundary.x) / Tile.TILEWIDTH, ty)
                    && interactionWithEnemy((int) (x + boundary.x + boundary.width) / Tile.TILEWIDTH, ty)) {
                Combat.battle(you, chicken);
                everything.getWorld();
            }

        } else if (yMove > 0) {//Down
            int ty = (int) (y + yMove + boundary.y + boundary.height) / Tile.TILEHEIGHT;

            if (!collisionWithTile((int) (x + boundary.x) / Tile.TILEWIDTH, ty)
                    && !collisionWithTile((int) (x + boundary.x + boundary.width) / Tile.TILEWIDTH, ty)) {
                y += yMove;
            }

            if (interactionWithNPC((int) (x + boundary.x) / Tile.TILEWIDTH, ty)
                    && interactionWithNPC((int) (x + boundary.x + boundary.width) / Tile.TILEWIDTH, ty)) {
                WisePanda.display();
                panda.dialogue1();
            }

            if (interactionWithEnemy((int) (x + boundary.x) / Tile.TILEWIDTH, ty)
                    && interactionWithEnemy((int) (x + boundary.x + boundary.width) / Tile.TILEWIDTH, ty)) {
                Combat.battle(you, chicken);

                everything.getWorld();
            }

        }
    }

    // merge of moveX and moveY method
    public void move() throws InterruptedException {
        moveX();
        moveY();
    }

    protected boolean interactionWithEnemy(int x, int y) {
        return everything.getWorld().getTile(x, y).isEnemy();
    }

    protected boolean interactionWithNPC(int x, int y) {
        return everything.getWorld().getTile(x, y).isNPC();
    }

    protected boolean collisionWithTile(int x, int y) {
        return everything.getWorld().getTile(x, y).isSolid();
        // access world --> tile --> solid or not
    }

    // getters and setters (health, speed)
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

}
