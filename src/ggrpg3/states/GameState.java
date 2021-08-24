package ggrpg3.states;

import java.awt.Graphics;

import ggrpg3.Game;
import ggrpg3.GetEverything;
import static ggrpg3.gfx.Assets.npc;
import ggrpg3.gfx.Sound;
import ggrpg3.hannah.Combat;
import ggrpg3.hannah.Enemy;
import ggrpg3.hannah.NPC;
import ggrpg3.hannah.Player;
import ggrpg3.worlds.World;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class GameState extends State {

    private Enemy enemy;
    private Player player;
    private World world;
    private NPC npc;
    public Sound sound;

    public GameState(GetEverything everything) {
        super(everything);
        world = new World(everything, "");
        everything.setWorld(world);
        
        player = new Player(everything, 128, 128);
        enemy = new Enemy(everything, 512, 512);
        npc = new NPC(everything, 256, 320);
        sound = new Sound();
        try {
            sound.playMusic("RVPeekaboo8Bit.wav");
            
            
            
            // char[] c = maps.getSymbolList(); //array symbol yasmin
            // char[][] t = everything.getMapsBasic().getTiles();
            //everything.getMapsBasic().getSize()
            
            /*
            for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
            a = everything.getWorld().getEnemyPositionX(i, j); // get enemy x-coordinate
            b = everything.getWorld().getEnemyPositionY(i, j); // get enemy y-coordinate
            if (everything.getWorld().getTile(i, j).isEnemy() == true) {
            break;
            }
            }
            }
            */
        } catch (IOException ex) {
            Logger.getLogger(GameState.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(GameState.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(GameState.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @Override
    public void tick() {
        world.tick();
        player.tick();
        enemy.tick();
        npc.tick();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        player.render(g);
        enemy.render(g);
        npc.render(g);
    }



}
