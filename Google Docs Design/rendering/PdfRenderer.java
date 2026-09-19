package rendering;

import elements.ImageElement;
import elements.TableElement;
import elements.TextElement;

public class PdfRenderer implements Renderer {
    @Override
    public void renderText(TextElement element) {
        System.out.println("pdf->text rendered->" + element.getText());
    }

    @Override
    public void renderImage(ImageElement element) {
        System.out.println("pdf->image rendered");
    }

    @Override
    public void renderTable(TableElement element) {
        System.out.println("pdf->table rendered");
    }

}
