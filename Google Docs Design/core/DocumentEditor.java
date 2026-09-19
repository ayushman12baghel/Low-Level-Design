package core;

import rendering.Renderer;

import commands.AddElementCommand;
import commands.CommandManager;
import elements.DocumentElement;
import factory.DocumentElementFactory;
import persistence.Persistence;

public class DocumentEditor {
    private Document document;
    private CommandManager commandManager;
    private Persistence persistence;
    private Renderer renderer;

    public DocumentEditor(Document document, CommandManager commandManager, Persistence persistence,
            Renderer renderer) {
        this.document = document;
        this.commandManager = commandManager;
        this.persistence = persistence;
        this.renderer = renderer;
    }

    public void addText(String text) {
        DocumentElement textElement = DocumentElementFactory.createText(text);
        commandManager.executeCommand(new AddElementCommand(document, textElement));
    }

    public void addImage(String url) {
        DocumentElement imageElement = DocumentElementFactory.createImage(url, "Default Caption");
        commandManager.executeCommand(new AddElementCommand(document, imageElement));
    }

    public void addTable(int rows, int cols) {
        DocumentElement tableElement = DocumentElementFactory.createTable(rows, cols);
        commandManager.executeCommand(new AddElementCommand(document, tableElement));
    }

    public void undo() {
        commandManager.undo();
        System.out.println("Undo performed");
    }

    public void redo() {
        commandManager.redo();
        System.out.println("Redo performed");
    }

    public void render() {
        document.render(renderer);
    }

    public void save() {
        persistence.save(document);
    }
}
