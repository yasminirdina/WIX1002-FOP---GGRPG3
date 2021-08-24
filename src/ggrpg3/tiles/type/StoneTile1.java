/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ggrpg3.tiles.type;

import ggrpg3.gfx.Assets;
import ggrpg3.tiles.Tile;
import java.awt.image.BufferedImage;

/**
 *
 * @author fifa
 */
public class StoneTile1 extends Tile {

    public StoneTile1(int id) {
        super(Assets.stone1, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }

}
