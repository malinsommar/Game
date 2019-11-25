package Gametest.Davidtest.hubworld.hub;

import Gametest.Davidtest.hubworld.hub.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class InputHandler implements KeyListener {

    public InputHandler(Game game) {
        game.addKeyListener(this); //calls the InputHandler whenever a key is pressed
    }

    public class Key {
        private int numTimesPressed = 0; //total times inputs pressed
        public boolean pressed = false; //sets default value of "pressed" to false

        public int getNumTimesPressed() {
            return numTimesPressed;
        }
        public boolean isPressed() {
            return pressed; //create a "isPressed" method that will be called as an object in game
        }

        public void toggle(boolean isPressed) {
            pressed = isPressed;
            if (isPressed) numTimesPressed++;
        }
    }

    public List<Key> keys = new ArrayList<Key>();
    //Register all the key-objects
    public Key up = new Key();
    public Key down = new Key();
    public Key left = new Key();
    public Key right = new Key();


    @Override
    public void keyPressed(KeyEvent e) {
        //change the keyPressed method to true when a key is pressed
        toggleKey(e.getKeyCode(), true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //change the keyPressed method to false when a key is not pressed
        toggleKey(e.getKeyCode(), false);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void toggleKey(int keyCode, boolean isPressed) {
        //assign the key-objects with a key
        if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) {
            up.toggle((isPressed));
        }
        if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN) {
            down.toggle((isPressed));
        }
        if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT) {
            left.toggle((isPressed));
        }
        if (keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT) {
            right.toggle((isPressed));
        }
    }
}

