package elements;

import rendering.Renderer;

public abstract class DocumentElement{
    String id;
    int position;

    public DocumentElement(String id){
        this.id=id;
    }

    public String getId(){
        return this.id;
    }

    public void setPosition(int position){
        this.position=position;
    }

    public int getPosition(){
        return this.position;
    }

    public abstract void render(Renderer render);
}