import board.Board;
import boardfactory.BoardFactory;
import boardfactory.SmallBoardFactory;
import strategy.GameStrategy;
import strategy.With2ndPlayerGameStrategy;

/**
 * @author idumchykov
 * @since 11/29/18
 */
public class  Game {

    public static void main(String[] args) {

        BoardFactory boardFactory = new SmallBoardFactory();
        Board board = boardFactory.create();

        GameStrategy gameStrategy = new With2ndPlayerGameStrategy();
        gameStrategy.setBoard(board);

        gameStrategy.play();
    }
}
