package board;

import java.util.List;

/**
 * @author idumchykov
 * @since 11/29/18
 */
public interface Board extends Drawable {

    void drawCoordinateFormat();

    void setSymbol(String symbol, int coordinate, boolean force);

    void setSymbol(String symbol, List<Integer> coordinates);

    boolean consists(String symbol, List<Integer> coordinates);
}
