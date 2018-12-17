package board;

import java.util.List;

/**
 * @author idumchykov
 * @since 11/29/18
 */
public abstract class AbstractBoard implements Board {

    protected List<Cell> cells;
    protected List<Cell> coordinateFormatCells;

    protected abstract void initializeBoard();

    public AbstractBoard() {
        initializeBoard();
    }
}