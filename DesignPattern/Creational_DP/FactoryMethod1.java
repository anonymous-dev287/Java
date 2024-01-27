package DesignPattern;

import java.util.HashMap;
import java.util.Map;

/*With Open/Close Principle*/
// Product interface
interface Docs {
    void open();
    void save();
}

// Concrete Products
class PDFDocuments implements Docs {
    @Override
    public void open() {
        System.out.println("Opening PDF document");
    }

    @Override
    public void save() {
        System.out.println("Saving PDF document");
    }
}

class WordDocuments implements Docs {
    @Override
    public void open() {
        System.out.println("Opening Word document");
    }

    @Override
    public void save() {
        System.out.println("Saving Word document");
    }
}

class PlainTextDocuments implements Docs {
    @Override
    public void open() {
        System.out.println("Opening Plain Text document");
    }

    @Override
    public void save() {
        System.out.println("Saving Plain Text document");
    }
}

// Creator interface with Factory Method
interface DocumentCreators {
    Docs createDocument();
}

// Concrete Creator implementing the Factory Method dynamically
class DynamicDocumentCreator implements DocumentCreators {
    private Map<String, Docs> documentTypes = new HashMap<>();

    public DynamicDocumentCreator() {
        // Register document types
        documentTypes.put("pdf", new PDFDocuments());
        documentTypes.put("word", new WordDocuments());
        documentTypes.put("plaintext", new PlainTextDocuments());
    }

    @Override
    public Docs createDocument() {
        // Simulating dynamic document type creation based on some condition or input
        // In a real scenario, this could be determined dynamically based on user input or other factors.
        String documentType = "word"; // Replace this with the actual logic to determine document type dynamically
       
        return documentTypes.getOrDefault(documentType, null);
    }
}

// Client Code
public class FactoryMethod1 {
    public static void main(String[] args) {
        // Create a document using DynamicDocumentCreator
        DocumentCreators documentCreator = new DynamicDocumentCreator();
        Docs document = documentCreator.createDocument();

        if (document != null) {
            document.open();
            document.save();
        } else {
            System.out.println("Invalid document type specified.");
        }
    }
}
