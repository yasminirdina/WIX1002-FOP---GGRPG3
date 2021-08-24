/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ggrpg3.hannah;

import ggrpg3.GetEverything;
import ggrpg3.gfx.Assets;
import java.awt.Graphics;

/**
 *
 * @author fifa
 */
public class Enemy extends Creature {


    
    /*
    public static void main(String[] args) {

        Combat player = new Combat(100, 50, 1, "ali");
        Combat Chicken = new Combat(150, 25, 1, "jahat");
        Combat.battle(player, Chicken);
    }
    */

    public Enemy(GetEverything everything, float x, float y) {
        super(everything, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        boundary.x = 16;
        boundary.y = 16;
        boundary.width = 32;
        boundary.height = 50;
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
                g.drawImage(Assets.enemyMove, (int) x, (int) y, width, height, null);

    }

}
