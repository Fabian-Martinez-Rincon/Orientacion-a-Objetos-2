package Decorator;

public abstract class Aspect implements FileAttributes {
    protected FileAttributes component;

    public Aspect(FileAttributes component) {
        this.component = component;
    }

    public String prettyPrint() {
        return component.prettyPrint();
    }
}