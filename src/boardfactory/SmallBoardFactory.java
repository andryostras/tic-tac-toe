package boardfactory;

import board.Board;
import board.SmallBoard;

/**
 * @author idumchykov
 * @since 11/29/18
 */
public class SmallBoardFactory implements BoardFactory {
    @Override
    public Board create() {
        return new SmallBoard();
    }
}
