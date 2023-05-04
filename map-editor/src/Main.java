public class Main {
    public static void main(String[] args) {

        // Create a new Grid object with a size of 80x60
        Grid g = new Grid(80, 60);

        // Create a new Cursor object starting at the top left corner of the grid
        Cursor cursor = new Cursor(0, 0, g);

        // Create a new Painter object with the Cursor and Grid objects as arguments
        Painter doIt = new Painter(cursor, g);

        // Initialize the keyboard events using the KeyboardManager class and pass the Painter object as the handler
        KeyboardManager.initKeyEvents(doIt);

    }
}