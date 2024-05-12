package Decorator;

public class AspectPermissions extends Aspect {

    public AspectPermissions(FileAttributes component) {
        super(component);
    }
    
    @Override
    public String prettyPrint() {
        return super.prettyPrint() + "Permisos: " + getPermissions() + "\n";
    }
}