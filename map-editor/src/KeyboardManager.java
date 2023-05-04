import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardManager {
    /**
     * Initializes the keyboard events for the given KeyboardHandler
     * @param handler the KeyboardHandler that will handle the keyboard events
     */
    public static void initKeyEvents(KeyboardHandler handler) {
        // Create a new keyboard instance and add the given handler to it
        Keyboard kb = new Keyboard(handler);

        // Add KeyboardEvents for each key in the Key enum
        for (Key k : Key.values()) {
            KeyboardEvent event = new KeyboardEvent();
            event.setKeyboardEventType(k.type);
            event.setKey(k.keyNum);
            kb.addEventListener(event);
        }
    }

    /**
     * Enum to represent the different types of keyboard events
     */
    private enum Key {
        LEFT_PRESSED(KeyboardEvent.KEY_LEFT, KeyboardEventType.KEY_PRESSED),
        RIGTH_PRESSED(KeyboardEvent.KEY_RIGHT, KeyboardEventType.KEY_PRESSED),
        DOWN_PRESSED(KeyboardEvent.KEY_DOWN, KeyboardEventType.KEY_PRESSED),
        UP_PRESSED(KeyboardEvent.KEY_UP, KeyboardEventType.KEY_PRESSED),
        S_PRESSED(KeyboardEvent.KEY_S, KeyboardEventType.KEY_PRESSED),
        Q_PRESS(KeyboardEvent.KEY_Q, KeyboardEventType.KEY_PRESSED),
        SPACE_PRESSED(KeyboardEvent.KEY_SPACE, KeyboardEventType.KEY_PRESSED),
        SPACE_RELEASE(KeyboardEvent.KEY_SPACE, KeyboardEventType.KEY_RELEASED);

        // Key code and KeyboardEventType for each Key enum value
        public final int keyNum;
        public final KeyboardEventType type;

        /**
         * Constructor for Key enum values
         * @param keyNum the key code for the keyboard key
         * @param type the KeyboardEventType for the key event
         */
        Key(int keyNum, KeyboardEventType type) {
            this.keyNum = keyNum;
            this.type = type;
        }
    }
}
