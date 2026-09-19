package rendering;

import elements.TextElement;
import elements.ImageElement;
import elements.TableElement;

public interface Renderer{
    void renderText(TextElement element);
    void renderImage(ImageElement element);
    void renderTable(TableElement element);
}