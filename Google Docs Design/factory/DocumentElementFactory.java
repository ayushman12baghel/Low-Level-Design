package factory;

import java.util.UUID;

import elements.DocumentElement;
import elements.ImageElement;
import elements.TableElement;
import elements.TextElement;

public class DocumentElementFactory {
    public static DocumentElement createText(String text) {
        return new TextElement(UUID.randomUUID().toString(), text);
    }

    public static DocumentElement createImage(String imageUrl, String caption) {
        return new ImageElement(UUID.randomUUID().toString(), imageUrl, caption);
    }

    public static DocumentElement createTable(int rows, int cols) {
        return new TableElement(UUID.randomUUID().toString(), rows, cols);
    }
}
