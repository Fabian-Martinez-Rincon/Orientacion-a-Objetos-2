package ar.edu.info.unlp.ejercicioDemo;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.Duration;

public class ToDoItemTest {
    
    ToDoItem item;
    
    @BeforeEach
    void setUp() throws Exception {
        item = new ToDoItem("Tarea de ejemplo");
    }
    
    @Test
    public void testExceptionPause() {

        IllegalStateException exception = assertThrows(
            IllegalStateException.class,
            item::togglePause
        );

        assertEquals("Cannot pause when in pending state.", exception.getMessage());
    }

    @Test
    public void testExceptionWorkedTime() {

        IllegalStateException exception = assertThrows(
            IllegalStateException.class,
            item::workedTime
        );

        assertEquals("Task has not started yet.", exception.getMessage());
    }
    
    @Test
    public void testStart() {
        item.start();
        assertTrue(item.getState() instanceof InProgress);
    }
    
    
    @Test
    public void testTogglePause() {
        item.start();
        item.togglePause();
        assertTrue(item.getState() instanceof Paused);
    }
    
    @Test
    public void testFinish() {
        item.start();
        item.togglePause();
        item.finish();
        assertTrue(item.getState() instanceof Finished);
    }
    
    @Test
    public void testWorkedTime() {
        item.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        item.finish();
        Duration workedTime = item.workedTime();
        assertEquals(2,workedTime.getSeconds());
        assertTrue(workedTime.getSeconds() >= 2 && workedTime.getSeconds() < 3);
    }
    
    @Test
    public void testAddComment() {
        item.addComment("Esto es un comentario.");
        assertFalse(item.getComments().isEmpty());
        assertEquals("Esto es un comentario.", item.getComments().get(0));
    }
    
    @Test
    public void testAddCommentAfterFinish() {
        item.start();
        item.finish();
        assertThrows(IllegalStateException.class, () -> item.addComment("No debería agregarse."));
        
        IllegalStateException exception = assertThrows(
                IllegalStateException.class, () -> item.addComment("No debería agregarse.")
            );

        assertEquals("Cannot add comments to a finished task.", exception.getMessage());
    }
}
