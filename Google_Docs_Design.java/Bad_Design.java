import java.io.FileWriter;
import java.util.*;

class DocumentEditor {
    private List<String> documentElements;
    private String renderDocument;

    public DocumentEditor() {
        documentElements = new ArrayList<>();
        renderDocument = "";
    }

    public void addText(String text) {
        documentElements.add(text);
    }

    public void addImage(String imagePath) {
        documentElements.add(imagePath);
    }

    public String renderDocument() {
        if (renderDocument.isEmpty()) {
            StringBuilder result = new StringBuilder();
            for (String element : documentElements) {
                if (element.length() > 4 && (element.endsWith(".jpg") || element.endsWith(".png"))) {
                    result.append("[Image: ").append(element).append("]\n");
                } else {
                    result.append(element).append("\n");
                }
            }

            renderDocument = result.toString();
        }

        return renderDocument;
    }

    public void saveToFile() {
        try {
            FileWriter writer = new FileWriter("document.txt");
            writer.write(renderDocument());
            writer.close();
            System.out.println("Document saved");
        } catch (Exception e) {
            System.out.println("Error in saving");
        }
    }
}

public class Bad_Design {
    public static void main(String[] args) {
        DocumentEditor editor = new DocumentEditor();
        editor.addText("Hello, world!");
        editor.addImage("picture.jpg");
        editor.addText("This is a document editor.");

        System.out.println(editor.renderDocument());

        editor.saveToFile();
    }
}