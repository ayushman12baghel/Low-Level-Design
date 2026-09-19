package persistence;

import core.Document;

public class DBPersistence implements Persistence {
    @Override
    public void save(Document document) {
        System.out.println("Saving document to database");
    }

    @Override
    public Document load(String id) {
        System.out.println("Loading document from database");
        return new Document("1", "default");
    }
}
