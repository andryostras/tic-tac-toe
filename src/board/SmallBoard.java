package board;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author idumchykov
 * @since 11/29/18
 */
public class SmallBoard extends AbstractBoard {

    @Override
    protected void initializeBoard() {

        cells = new ArrayList<>(
                asList(new Cell("_", "|"),
                        new Cell("_", "|"),
                        new Cell("_", ""),

                        new Cell("_", "|"),
                        new Cell("_", "|"),
                        new Cell("_", ""),

                        new Cell(" ", "|"),
                        new Cell(" ", "|"),
                        new Cell(" ", "")));

        coordinateFormatCells = new ArrayList<>(
                asList(new Cell("0", "|"),
                        new Cell("1", "|"),
                        new Cell("2", ""),

                        new Cell("3", "|"),
                        new Cell("4", "|"),
                        new Cell("5", ""),

                        new Cell("6", "|"),
                        new Cell("7", "|"),
                        new Cell("8", "")));
    }

    @Override
    public void draw() {
        drawBoard(cells);
    }

    @Override
    public void drawCoordinateFormat() {
        drawBoard(coordinateFormatCells);
    }

    private void drawBoard(List<Cell> cellList) {
        for (Drawable cell : cellList) {
            cell.draw();
        }
    }

    @Override
    public void setSymbol(String symbol, int coordinate, boolean force) {

        if (coordinate > cells.size() - 1) {
            throw new IllegalArgumentException("Coordinate is bigger then board size");
        }

        if (coordinate < 0) {
            throw new IllegalArgumentException("Coordinate can not be negative");
        }

        Cell cell = cells.get(coordinate);
        if (!force) {
            String value = cell.getValue();
            if (!value.equals("_") && !value.equals(" ")) {
                throw new IllegalArgumentException("This cell is already occupied");
            }
        }

        cell.setValue(symbol);
    }

    @Override
    public void setSymbol(String symbol, List<Integer> coordinates) {
        for (Integer coordinate : coordinates) {
            setSymbol(symbol, coordinate, true);
        }
    }

    @Override
    public boolean consists(String symbol, List<Integer> coordinates) {

        for (Integer coordinate : coordinates) {
            if (!cells.get(coordinate).getValue().equals(symbol)) {
                return false;
            }
        }

        return true;
    }
}
