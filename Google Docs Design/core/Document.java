package core;

import java.util.ArrayList;
import java.util.List;
import elements.DocumentElement;
import rendering.Renderer;

public class Document {
    private String id;
    private List<DocumentElement> elements;
    private String title;

    public Document(String id, String title) {
        this.id = id;
        this.title = title;
        elements = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void addElement(DocumentElement element) {
        elements.add(element);
    }

    public void removeElement(DocumentElement element) {
        elements.remove(element);
    }

    public List<DocumentElement> getElements() {
        return elements;
    }

    public void render(Renderer render) {
        System.out.println("Rendering Document  " + title);
        for (DocumentElement el : elements) {
            el.render(render);
        }
    }
}
