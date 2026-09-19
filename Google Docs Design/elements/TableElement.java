package elements;

import rendering.Renderer;

public class TableElement extends DocumentElement {
    private int rows;
    private int cols;

    public TableElement(String id, int rows, int cols) {
        super(id);
        this.rows = rows;
        this.cols = cols;
    }

    @Override
    public void render(Renderer render) {
        render.renderTable(this);
    }

    public int getRows() {
        return this.rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return this.cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }
}