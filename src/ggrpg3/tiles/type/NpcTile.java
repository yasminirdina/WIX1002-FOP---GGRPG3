/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ggrpg3.tiles.type;

import ggrpg3.gfx.Assets;
import ggrpg3.tiles.Tile;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 *
 * @author fifa
 */
public class NpcTile extends Tile {

    public NpcTile(int id) {
        super(Assets.npc, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
    
    @Override
    public boolean isNPC() {
        return true;
    }
    
    
}
