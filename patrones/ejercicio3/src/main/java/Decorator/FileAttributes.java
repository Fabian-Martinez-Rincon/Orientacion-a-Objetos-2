package Decorator;

public interface FileAttributes {
    default String prettyPrint() { return ""; }
    default String getName() { return ""; }
    default String getExtension() { return ""; }
    default String getSize() { return ""; }
    default String getDateCreated() { return ""; }
    default String getDateModified() { return ""; }
    default String getPermissions() { return ""; }
}