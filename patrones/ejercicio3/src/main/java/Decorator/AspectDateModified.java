package Decorator;

public class AspectDateModified extends Aspect {
    public AspectDateModified(FileAttributes component) {
        super(component);
    }
    
    @Override
    public String prettyPrint() {
        return super.prettyPrint() + "Modificado: " + getDateModified() + "\n";
    }
}