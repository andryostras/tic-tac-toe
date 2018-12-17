package strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Arrays.asList;

/**
 * @author idumchykov
 * @since 11/29/18
 */
public class With2ndPlayerGameStrategy extends AbstractGameStrategy {

    private Scanner scanner;

    public With2ndPlayerGameStrategy() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void play() {
        while (true) {

            int coordinate = getNextCoordinate();
            String symbol = getNextSymbol();

            board.setSymbol(symbol, coordinate, false);

            List<Integer> winCoordinates = getWinCoordinatesBySymbol(symbol);
            if (winCoordinates != null) {
                System.out.println(symbol + " won this game!!!");
                board.setSymbol(WIN_SYMBOL, winCoordinates);
                board.draw();
                break;
            }

            board.draw();
        }
    }

    @Override
    public List<Integer> getWinCoordinatesBySymbol(String symbol) {
        for (List<Integer> winCoordinateCombination : winCoordinates) {
            if (board.consists(symbol, winCoordinateCombination)) {
                return winCoordinateCombination;
            }
        }
        return null;
    }

    @Override
    public void initializeWinCoordinates() {
        winCoordinates = new ArrayList<>(
                asList(asList(0, 1, 2),
                        asList(3, 4, 5),
                        asList(6, 7, 8),
                        asList(0, 3, 6),
                        asList(1, 4, 7),
                        asList(2, 5, 8),
                        asList(0, 4, 8),
                        asList(2, 4, 6)));
    }

    private int getNextCoordinate() {
        System.out.println("Please enter coordinate in format: ");
        board.drawCoordinateFormat();

        if (scanner.hasNext()) {
            return scanner.nextInt();
        }

        return WRONG_COORDINATE;
    }

    private String getNextSymbol() {
        System.out.println("Please enter symbol in format: ");
        System.out.println(X_SYMBOL + " or " + O_SYMBOL);

        if (scanner.hasNext()) {
            String symbol = scanner.next();
            if (!symbol.equals(X_SYMBOL) && !symbol.equals(O_SYMBOL)) {
                throw new IllegalArgumentException("Wrong input symbol");
            }
            return symbol;
        }

        return null;
    }
}
