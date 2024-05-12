package Decorator;

public class AspectExtension extends Aspect {
    public AspectExtension(FileAttributes component) {
        super(component);
    }

    @Override
    public String prettyPrint() {
        return super.prettyPrint() + "Extensión: ." + getExtension() + "\n";
    }
}