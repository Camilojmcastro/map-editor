import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Painter implements KeyboardHandler {
    private Cursor cursor;
    private Grid grid;

    private Boolean hasPainted;
    public Painter(Cursor cursor, Grid grid) {
        this.cursor = cursor;
        this.grid = grid;
        this.hasPainted = false;
    }

    /**
     * Handles key presses.
     * @param keyboardEvent the event of the pressed key
     */

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_Q:
                System.exit(0);  // Exit program
                break;
            case KeyboardEvent.KEY_SPACE:
                if (hasPainted==false){
                    cursor.setPainting(true); // Start painting
                    grid.paintCell(cursor.getRow(), cursor.getCol()); // Paint cell
                    hasPainted = true;
                }
                break;
            case KeyboardEvent.KEY_UP:
                cursor.goUp(); // Move cursor up
                if(cursor.isPainting()){ // If painting, paint cell
                    grid.paintCell(cursor.getRow(), cursor.getCol());
                }
                break;
            case KeyboardEvent.KEY_LEFT:
                cursor.goLeft(); // Move cursor left
                if(cursor.isPainting()){ // If painting, paint cell
                    grid.paintCell(cursor.getRow(), cursor.getCol());
                }
                break;
            case KeyboardEvent.KEY_RIGHT:
                cursor.goRight(); // Move cursor right
                if(cursor.isPainting()){ // If painting, paint cell
                    grid.paintCell(cursor.getRow(), cursor.getCol());
                }
                break;
            case KeyboardEvent.KEY_DOWN:
                cursor.goDown(); // Move cursor down
                if(cursor.isPainting()){ // If painting, paint cell
                    grid.paintCell(cursor.getRow(), cursor.getCol());
                }
                break;
        }
        }

    /**
     * Handles key releases.
     * @param keyboardEvent the event of the released key
     */

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE:
                cursor.setPainting(false); // Stop painting
                hasPainted = false;
                break;
            case KeyboardEvent.KEY_S:
                FileManager.write(grid.toString()); // Save grid state
                break;
            case KeyboardEvent.KEY_L:
                grid.fromString(FileManager.read()); // Load grid state
                break;

        }

        }

    }

