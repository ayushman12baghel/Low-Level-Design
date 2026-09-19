package persistence;

import core.Document;

public interface Persistence {
    void save(Document document);

    Document load(String id);
}
