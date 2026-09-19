package commands;

import elements.DocumentElement;
import core.Document;

public class DeleteElementCommand implements Command {
    private Document document;
    private DocumentElement element;

    public DeleteElementCommand(Document document, DocumentElement element) {
        this.document = document;
        this.element = element;
    }

    @Override
    public void execute() {
        int index = this.document.getElements().indexOf(element);
        if (index != -1) {
            document.getElements().remove(element);
        }
        System.out.println("element deleted from document");
    }

    @Override
    public void undo() {
        int index = this.document.getElements().indexOf(element);
        if (index != -1) {
            document.getElements().add(index, element);
        }

        System.out.println("element added back to document");
    }
}
