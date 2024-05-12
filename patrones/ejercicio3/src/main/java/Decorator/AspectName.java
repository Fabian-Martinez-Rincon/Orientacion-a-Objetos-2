package Decorator;

public class AspectName extends Aspect {
    public AspectName(FileAttributes component) {
        super(component);
    }

    @Override
    public String prettyPrint() {
        return super.prettyPrint() + "Nombre: " + this.getName();
    }
}