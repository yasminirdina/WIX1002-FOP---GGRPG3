
package ggrpg3;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyManager implements KeyListener {
    
    private boolean [] keys;
    public boolean up,down, left, right, yes, no;
    public KeyManager(){
        keys = new boolean [256];
    }
    public void tick (){
        up = keys [KeyEvent.VK_W];
        down = keys [KeyEvent.VK_S];
        left = keys [KeyEvent.VK_A];
        right = keys [KeyEvent.VK_D];
        yes = keys[KeyEvent.VK_Y];
        no = keys[KeyEvent.VK_N];
    }   
    @Override
    public void keyTyped(KeyEvent e) {
        keys [e.getKeyCode()]= true;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys [e.getKeyCode()]= false;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys [e.getKeyCode()]= true;
    }
    
    
}

