package elements;

import rendering.Renderer;

public class TextElement extends DocumentElement {
    private String text;
    private String style;

    public TextElement(String id, String text) {
        super(id);
        this.text = text;
        this.style = "default";
    }

    @Override
    public void render(Renderer render) {
        render.renderText(this);
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getStyle() {
        return this.style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}