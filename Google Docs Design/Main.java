import commands.CommandManager;
import core.Document;
import core.DocumentEditor;
import persistence.FilePersistence;
import rendering.WebRenderer;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Google Docs Application...\n");

        Document doc = new Document("doc-1", "My First Document");
        CommandManager cmdManager = new CommandManager();
        WebRenderer renderer = new WebRenderer();
        FilePersistence persistence = new FilePersistence();

        DocumentEditor editor = new DocumentEditor(doc, cmdManager, persistence, renderer);

        editor.addText("Hello World!");
        editor.addImage("https://example.com/image.png");
        editor.addTable(2, 2);

        System.out.println("\n--- Current Document ---");
        editor.render();

        System.out.println("\n--- Undoing last action ---");
        editor.undo();
        editor.render(); // Table should be gone

        System.out.println("\n--- Redoing last action ---");
        editor.redo();
        editor.render(); // Table should be back

        System.out.println("\n--- Saving Document ---");
        editor.save();
    }
}
