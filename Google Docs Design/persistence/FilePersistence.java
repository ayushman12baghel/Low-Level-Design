package persistence;

import core.Document;

public class FilePersistence implements Persistence {
    @Override
    public void save(Document document) {
        System.out.println("Saving document in local file system");
    }

    @Override
    public Document load(String id) {
        System.out.println("Loading document from local file system");
        return new Document("1", "default");
    }
}
