import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;

public class Cursor {
    private Ellipse representation;  // Represents the cursor as an ellipse
    private Grid grid;  // The grid that the cursor belongs to
    private boolean painting;  // Indicates if the cursor is currently painting a cell or not
    private int col;  // The cursor's current column position
    private int row;  // The cursor's current row position

    /**
     * Constructs a new cursor at the specified column and row position on the given grid.
     *
     * @param col the initial column position
     * @param row the initial row position
     * @param grid the grid that the cursor belongs to
     */

    public Cursor(int col, int row, Grid grid) {
        representation = new Ellipse(Grid.colToX(col), Grid.rowToY(row), Grid.CELL_SIZE, Grid.CELL_SIZE);
        representation.setColor(Color.BLUE);
        representation.fill();
        this.grid = grid;
        this.col = col;
        this.row = row;
        painting = false;
    }

    // Method to move the cursor one cell up on the grid, if not already at the top of the grid
    public void goUp() {
        if (row == 0) {
            return;
        }
        row--; // Decrement the current row position
        representation.translate(0, -Grid.CELL_SIZE); // Move the graphical representation of the cursor up one cell size
    }

    // Method to move the cursor one cell down on the grid, if not already at the bottom of the grid
    public void goDown() {
        if (row == grid.getRows() - 1) {
            return;
        }
        row++; // Increment the current row position
        representation.translate(0, Grid.CELL_SIZE);
    }

    // Method to move the cursor one cell right on the grid, if not already at the rightmost column of the grid
    public void goRight() {
        if (col == grid.getCols() - 1) {
            return;
        }
        col++;
        representation.translate(Grid.CELL_SIZE, 0);
    }

    // Method to move the cursor one cell left on the grid, if not already at the leftmost column of the grid
    public void goLeft() {
        if (col == 0) {
            return;
        }
        col--;
        representation.translate(-Grid.CELL_SIZE, 0);
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    /**
     * Determines whether the cursor is painting or not
     *
     * @return true if the cursor is painting, false otherwise
     */
    public boolean isPainting() {
        return painting;
    }

    /**
     * Sets the painting status of the cursor
     *
     * @param painting the new painting status
     */
    public void setPainting(boolean painting) {
        this.painting = painting;
    }
}

