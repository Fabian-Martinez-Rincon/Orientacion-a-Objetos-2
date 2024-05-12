package Decorator;

public class AspectSize extends Aspect {
    public AspectSize(FileAttributes component) {
        super(component);
    }

    @Override
    public String prettyPrint() {
        return super.prettyPrint() + "Tamaño: " + getSize() + " MB\n";
    }
}