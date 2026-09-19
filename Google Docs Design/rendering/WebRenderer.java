package rendering;

import elements.ImageElement;
import elements.TableElement;
import elements.TextElement;

public class WebRenderer implements Renderer {
    @Override
    public void renderText(TextElement element) {
        System.out.println("Text endered->" + element.getText());
    }

    @Override
    public void renderImage(ImageElement element) {
        System.out.println("image rendered");
    }

    @Override
    public void renderTable(TableElement element) {
        System.out.println("table rendered");
    }
}
