package persistence;

import core.Document;

public class CloudPersistence implements Persistence {
    @Override
    public void save(Document document) {
        System.out.println("Saving document to cloud storage");
    }

    @Override
    public Document load(String id) {
        System.out.println("Loading document from cloud storage");
        return new Document("1", "default");
    }
}
