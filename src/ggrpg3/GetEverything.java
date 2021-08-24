/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ggrpg3;

import ggrpg3.gfx.GameCamera;
import ggrpg3.worlds.MapsBasic;
import ggrpg3.worlds.World;

/**
 *
 * @author fifa
 */
public class GetEverything {

    private Game game;
    private World world;
    private MapsBasic mapsbasic;

    public GetEverything(Game game) {
        this.game = game;
    }

    public KeyManager getKeyManager() {
        return game.getKeyManager();
    }

    public int getWidth() {
        return game.getWidth();
    }

    public int getHeight() {
        return game.getHeight();
    }

    public GameCamera getGameCamera() {
        return game.getGameCamera();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
    
    public MapsBasic getMapsBasic() {
        return mapsbasic;
    }

}
