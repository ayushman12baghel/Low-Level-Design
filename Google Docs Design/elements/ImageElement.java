package elements;

import rendering.Renderer;

public class ImageElement extends DocumentElement {
    private String imageUrl;
    private String caption;

    public ImageElement(String id, String imageUrl, String caption) {
        super(id);
        this.imageUrl = imageUrl;
        this.caption = caption;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getCaption() {
        return this.caption;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    @Override
    public void render(Renderer render) {
        render.renderImage(this);
    }
}