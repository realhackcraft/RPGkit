package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * KeyHandler class implements KeyListener interface to handle user keyboard input.
 * It creates an array of boolean values, one for each possible key on the keyboard.
 * It provides methods to set a key value to true when it is pressed and to false when it is released.
 * Additionally, it provides the isKeyPressed method to check the current state of a particular key.
 */

public class KeyHandler implements KeyListener {
    /**
     * An array of boolean values representing the status of each key on the keyboard.
     * The array's index corresponds to the ASCII value of the respective key.
     * <p>
     * If a key is currently pressed down, the value at the corresponding index in this array is 'true'.
     * Otherwise, the value is 'false'.
     * <p>
     * The number of elements in this array is 263, allowing for the representation of all ASCII characters.
     *
     * @return a boolean array representing the status of each key on the keyboard
     */
    public boolean[] keys = new boolean[263];

    /**
     * Invoked when a key is typed.
     *
     * @param keyEvent the KeyEvent object that contains the information about the key typed
     */
    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    /**
     * Invoked when a physical key has been pressed down. This method sets the value of the corresponding
     * key code in the boolean array "keys" to true.
     *
     * @param keyEvent the KeyEvent object that contains the information about the key pressed
     * @see KeyEvent
     */
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        keys[keyEvent.getKeyCode()] = true;
    }

    /**
     * Invoked when a physical key has been released. This method sets the value of the corresponding
     * key code in the boolean array "keys" to false.
     *
     * @param keyEvent the KeyEvent object that contains the information about the key released
     * @see KeyEvent
     */
    @Override
    public void keyReleased(KeyEvent keyEvent) {
        keys[keyEvent.getKeyCode()] = false;
    }

    /**
     * Returns true if the given key code is currently pressed, false otherwise.
     *
     * @param keyCode an integer representing the key code of the desired key
     * @return a boolean value that is true if the key is currently pressed, false otherwise
     */
    public boolean isKeyPressed(int keyCode) {
        return keys[keyCode];
    }
}
