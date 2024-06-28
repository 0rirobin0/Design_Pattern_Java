package BehaviouralDP_CCMMSSO;

// The Memento Design Pattern allows you to save and restore an object's state without revealing its details,
//  useful for implementing undo operations or checkpoints in applications. 
//  It involves capturing the state in a memento object and restoring it when needed,
//  keeping objects independent and maintaining encapsulation

// Scenario==================================
// Imagine you’re building a text editor application, 
// and you want to implement an undo feature that allows users to revert changes made to a document.
//  The challenge is to store the state of the document at various points in time 
// and restore it when needed without exposing the internal implementation of the document.

import java.util.ArrayList;
import java.util.List;

// Originator
class Document {
    private String content;

    public Document(String content) {
        this.content = content;
    }

    public void write(String text) {
        this.content += text;
    }

    public String getContent() {
        return this.content;
    }

    public DocumentMemento createMemento() {
        return new DocumentMemento(this.content);
    }

    public void restoreFromMemento(DocumentMemento memento) {
        this.content = memento.getSavedContent();
    }
}

// Memento
class DocumentMemento {
    private String content;

    public DocumentMemento(String content) {
        this.content = content;
    }

    public String getSavedContent() {
        return this.content;
    }
}

// Caretaker
class History {
    private List<DocumentMemento> mementos;

    public History() {
        this.mementos = new ArrayList<>();
    }

    public void addMemento(DocumentMemento memento) {
        this.mementos.add(memento);
    }

    public DocumentMemento getMemento(int index) {
        return this.mementos.get(index);
    }
}

public class MementoDP {
    public static void main(String[] args) {
        Document document = new Document("Initial content\n");
        History history = new History();

        // Write some content
        document.write("Additional content\n");
        history.addMemento(document.createMemento());

        // Write more content
        document.write("More content\n");
        history.addMemento(document.createMemento());

        // Restore to previous state
        document.restoreFromMemento(history.getMemento(1));

        // Print document content
        System.out.println(document.getContent());
    }
}
