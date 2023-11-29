package listener;
import java.awt.event.*;

import main.*;
    
public class GameKeyboardListener implements KeyListener{
    GameFrame game;

    public GameKeyboardListener(GameFrame game){
        this.game=game;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode()== KeyEvent.VK_UP){
            System.out.println("yeah");
            game.switchSection("Menu");
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            game.switchSection("Play");
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            game.switchSection("Settings");
        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }
    
}
