import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {
    // Instance variables
    private Rectangle representation;
    private boolean painted;

    // Constructor
    public Cell(int row, int col){
        representation = new Rectangle(Grid.colToX(col), Grid.rowToY(row), Grid.CELL_SIZE, Grid.CELL_SIZE);
        representation.setColor(Color.GRAY);
        representation.draw();
        painted = false;
    }

    // Method to check if the cell is painted
    public boolean isPainted() {
        return painted;
    }

    // Method to clear the cell
    public void clear(){
        representation.setColor(Color.GRAY);
        representation.draw();
        painted = false;
    }

    /**
     * Paints the cell black if it hasn't already been painted.
     */
    public void paint(){
        // set the color of the representation to black and fill it
        representation.setColor(Color.BLACK);
        representation.fill();
        // set painted to true to indicate the cell has been painted
        painted = true;
    }

    /**
     * Returns a string representation of the cell. If the cell has been painted, returns "1", otherwise returns "0".
     * @return a string representation of the cell
     */
     @Override
    public String toString(){
         // if the cell has been painted, return "1", otherwise return "0"
         return painted ? "1": "0";
     }
}
