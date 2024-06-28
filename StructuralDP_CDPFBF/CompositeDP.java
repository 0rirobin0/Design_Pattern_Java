package StructuralDP_CDPFBF;

import java.util.ArrayList;
import java.util.List;

interface Component {
    void showDetails();
}

class File implements Component {
    private String name;
    private double size;

    public File(String name, double size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void showDetails() {
        System.out.println("File: " + name + " (" + size + " MB)");
    }
}

class Directory implements Component {
    private String name;
    private List<Component> components = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void addComponent(Component component) {
        components.add(component);
    }

    public void removeComponent(Component component) {
        components.remove(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Directory: " + name);
        for (Component component : components) {
            component.showDetails();
        }
    }
}

public class CompositeDP {
    public static void main(String[] args) {
        // Create files
        Component file1 = new File("file1.txt", 10);
        Component file2 = new File("file2.txt", 20);
        Component file3 = new File("file3.txt", 30);

        // Create directories
        Directory dir1 = new Directory("dir1");
        Directory dir2 = new Directory("dir2");

        // Add files to directories
        dir1.addComponent(file1);
        dir1.addComponent(file2);

        dir2.addComponent(file3);
        dir2.addComponent(dir1); // Nested directory

        // Display details
        dir2.showDetails();
    }
}