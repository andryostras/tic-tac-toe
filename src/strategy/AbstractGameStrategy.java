package strategy;

import board.Board;

import java.util.List;

/**
 * @author idumchykov
 * @since 11/29/18
 */
public abstract class AbstractGameStrategy implements GameStrategy {

    protected Board board;
    protected List<List<Integer>> winCoordinates;

    static final String X_SYMBOL = "X";
    static final String O_SYMBOL = "0";
    static final String WIN_SYMBOL = "■";
    static final int WRONG_COORDINATE = -1;

    @Override
    public void setBoard(Board board) {
        this.board = board;
    }

    public AbstractGameStrategy() {
        initializeWinCoordinates();
    }

    protected abstract void initializeWinCoordinates();

}
