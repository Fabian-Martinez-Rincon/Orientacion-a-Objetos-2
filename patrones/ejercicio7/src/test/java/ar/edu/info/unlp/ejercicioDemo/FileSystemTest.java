package ar.edu.info.unlp.ejercicioDemo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;

public class FileSystemTest {

    Directory root;
    File file1, file2, file3;
    Directory dir1;

    @BeforeEach
    void setUp() {
        file1 = new File("file1.txt", 100);
        file2 = new File("file2.txt", 200);
        file3 = new File("file3.txt", 150);

        dir1 = new Directory("dir1", 0);
        root = new Directory("root", 0);

        dir1.addElement(file1);
        dir1.addElement(file2);
        root.addElement(dir1);
        root.addElement(file3);
        
    }
    
    @Test
    public void testTamanoTotalOcupado() {
        assertEquals(300, dir1.tamanoTotalOcupado());
        assertEquals(450, root.tamanoTotalOcupado());
    }
    
    @Test
    public void testArchivoMasGrande() {
        assertSame(file2, root.archivoMasGrande());
    }
    
    @Test
    public void testArchivoMasNuevo() {
    	file1.setFechaCreacion(LocalDate.of(2021, 1, 1));
        file2.setFechaCreacion(LocalDate.of(2022, 1, 1));
        file3.setFechaCreacion(LocalDate.of(2023, 1, 1));
        
        assertSame(file3, root.archivoMasNuevo());
    }
    
    @Test
    public void testBuscar() {
        assertSame(file1, root.buscar("file1.txt"));
        assertNull(root.buscar("nonexistent.txt"));
    }
    
    @Test
    public void testBuscarTodos() {
    	File archivo = new File("cosa", 0);
    	Directory carpeta= new Directory("cosa", 0);
    	
    
    	carpeta.addElement(archivo);
        root.addElement(carpeta);
        
        List<FileSystemElement> results = root.buscarTodos("cosa");
        assertTrue(results.contains(archivo));
        assertTrue(results.contains(carpeta));
        
        assertEquals(2, results.size());
    }

    @Test
    public void testListadoDeContenido() {
        String expected = "/root\n/root/dir1\n/root/dir1/file1.txt\n/root/dir1/file2.txt\n/root/file3.txt\n";
        assertEquals(expected, root.listadoDeContenido());
    }
}

