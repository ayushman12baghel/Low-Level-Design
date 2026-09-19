package commands;

import elements.DocumentElement;
import core.Document;

public class AddElementCommand implements Command {
    private Document document;
    private DocumentElement element;

    public AddElementCommand(Document document, DocumentElement element) {
        this.document = document;
        this.element = element;
    }

    @Override
    public void execute() {
        document.addElement(element);
        System.out.println("Element added to document");
    }

    @Override
    public void undo() {
        document.removeElement(element);
        System.out.println("Element removed from document");
    }
}
