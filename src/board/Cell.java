package board;

/**
 * @author idumchykov
 * @since 11/29/18
 */
public class Cell implements Drawable {

    private String value;
    private String separator;

    public Cell(String value, String separator) {
        this.value = value;
        this.separator = separator;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSeparator() {
        return separator;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    @Override
    public String toString() {
        return value + separator;
    }

    @Override
    public void draw() {
        String line = separator.isEmpty() ? toString() + "\n" : toString();
        System.out.print(line);
    }
}
