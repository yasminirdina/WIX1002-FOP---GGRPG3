package ggrpg3.hannah;

import ggrpg3.Game;
import ggrpg3.GetEverything;
import ggrpg3.gfx.Assets;
import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Player extends Creature {

    public Player(GetEverything everything, float x, float y) {
        super(everything, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

        //customizable to fit the player that we have
        //used for collision. consider this like a "hitbox"
        //it has to be considerably smaller than the size of neighboring tiles
        //.....it took us 6 hours to figure ^ out
        boundary.x = 16;
        boundary.y = 16;
        boundary.width = 32;
        boundary.height = 50;
    }

    @Override
    public void tick() {
        xMove = 0;
        yMove = 0;
        int counterY = 0;
        int counterN = 0;

        if (everything.getKeyManager().up) {
            yMove += 3;
        }
        if (everything.getKeyManager().down) {
            yMove -= 3;
        }
        if (everything.getKeyManager().left) {
            xMove += 3;
        }
        if (everything.getKeyManager().right) {
            xMove -= 3;
        }
        if (everything.getKeyManager().yes){
            counterY++;
        }
        if (everything.getKeyManager().no) {
            counterN++;
        }
        
        try {
            move();
        } catch (InterruptedException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.playerMove, (int) x, (int) y, width, height, null);
        //g.setColor(Color.red);
        //g.fillRect((int) x,(int) y, boundary.width, boundary.height);
        
    }

}
