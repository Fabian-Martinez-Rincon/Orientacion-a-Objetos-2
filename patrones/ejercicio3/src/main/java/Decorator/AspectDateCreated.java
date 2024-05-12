package Decorator;

public class AspectDateCreated extends Aspect {
    public AspectDateCreated(FileAttributes component) {
        super(component);
    }
    
    public String prettyPrint() {
        return super.prettyPrint() + "Creado: " + getDateCreated() + "\n";
    }
}