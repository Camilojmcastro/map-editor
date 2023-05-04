

import java.util.Arrays;

public class Grid {

    // Constants for cell size and padding
    public static final int CELL_SIZE = 10;
    public static final int PADDING = 10;

    // Instance variables
    private Cell[][] cells;
    private int cols;
    private int rows;

    // Constructor
    public Grid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        initCells();
    }

    // Helper method to initialize the cells array
    private void initCells() {
        cells = new Cell[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // Create a new Cell object at this position in the array
                cells[row][col] = new Cell(row, col);
            }
        }
    }
    // Method to paint or clear a cell
    public void paintCell(int row, int col) {
        Cell p = cells[row][col];
        if (p.isPainted()) {
            p.clear(); // Clear the cell if it's already painted

            return;
        }
        p.paint();  // Paint the cell if it's not already painted
    }

    // Methods to convert between column/row positions and x/y positions on the screen
    public static int colToX(int col) {
        return col * CELL_SIZE + PADDING;
    }

    public static int rowToY(int row) {
        return row * CELL_SIZE + PADDING;
    }


    // Getters for number of columns and rows
    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    // Method to populate the grid from a string
    public void fromString(String gridString) {
        if (gridString == null) {
            return;
        }
        String[] lines = gridString.split("\n");
        for (int row = 0; row < lines.length; row++) {
            String[] line = lines[row].split("");
            for (int col = 0; col < line.length; col++) {
                // If the character in the string is '1', paint the corresponding cell
                if (line[col].equals("1")) {
                    cells[row][col].paint();
                    // Otherwise, clear the corresponding cell
                } else {
                    cells[row][col].clear();
                }
            }
        }
    }

    // Method to convert the grid to a string
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for (Cell[] innerArray:cells){
            for(Cell cell : innerArray){
                builder.append(cell.toString()); // Append the string representation of each cell
            }
            builder.append("\n"); // Add a newline after each row
        }
        return builder.toString();
    }
}
