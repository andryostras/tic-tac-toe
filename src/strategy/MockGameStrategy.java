package strategy;

import java.util.List;

/**
 * @author idumchykov
 * @since 11/29/18
 */
public class MockGameStrategy extends AbstractGameStrategy {

    @Override
    public void play() {
        board.draw();
    }

    @Override
    public List<Integer> getWinCoordinatesBySymbol(String symbol) {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public void initializeWinCoordinates() {

    }

}
