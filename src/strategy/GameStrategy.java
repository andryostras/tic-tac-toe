package strategy;

import board.Board;

import java.util.List;

/**
 * @author idumchykov
 * @since 11/29/18
 */
public interface GameStrategy {

    void setBoard(Board board);

    void play();

    List<Integer> getWinCoordinatesBySymbol(String symbol);
}
