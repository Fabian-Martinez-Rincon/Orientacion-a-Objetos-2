package ar.edu.info.unlp.ejercicioDemo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

public class ExcursionTest {
    private Excursion excursion;
    private Usuario user1, user2, user3;

    @BeforeEach
    void setUp() {
        LocalDateTime startDate = LocalDateTime.of(2023, 10, 1, 8, 0);
        LocalDateTime endDate = LocalDateTime.of(2023, 10, 3, 18, 0);
        excursion = new Excursion("Kayak Adventure", startDate, endDate, "River Dock", 150.0, 2, 4);
        user1 = new Usuario("John", "Doe", "john.doe@example.com");
        user2 = new Usuario("Jane", "Doe", "jane.doe@example.com");
        user3 = new Usuario("Jim", "Beam", "jim.beam@example.com");
    }

    @Test
    public void testAddParticipant_ProvisorioState() {
        excursion.addParticipant(user1);
        assertEquals(1, excursion.getParticipants().size());
        assertTrue(excursion.getState() instanceof Provisorio);
        assertEquals("Name: Kayak Adventure,"
        		+ " Cost: 150,00"
        		+ ", Dates: 2023-10-01T08:00 to 2023-10-03T18:00"
        		+ ", Meeting Point: River Dock"
        		+ ", Needed to start: 1", excursion.getInfo());
        
        excursion.addParticipant(user2);
        assertEquals("Name: Kayak Adventure, "
        		+ "Cost: 150,00, "
        		+ "Dates: 2023-10-01T08:00 to 2023-10-03T18:00"
        		+ ", Meeting Point: River Dock, "
        		+ "Emails: john.doe@example.com, "
        		+ "jane.doe@example.com, "
        		+ "Slots remaining: 2", excursion.getInfo());
    }

    
    @Test
    public void testTransitionToEnProgreso() {
        excursion.addParticipant(user1);
        excursion.addParticipant(user2); // This should trigger the state change to EnProgreso
        assertTrue(excursion.getState() instanceof EnProgreso);
        assertEquals(true, excursion.getInfo().contains("Slots remaining: 2"));
    }
    
    

    @Test
    public void testFullCapacityTransition() {
        excursion.addParticipant(user1);
        excursion.addParticipant(user2);
        excursion.addParticipant(user3);
        Usuario user4 = new Usuario("Max", "Payne", "max.payne@example.com");
        excursion.addParticipant(user4); // This should fill the capacity and trigger Definitiva state
        assertTrue(excursion.getState() instanceof Definitiva);
        assertEquals(true, excursion.getInfo().contains("FULL"));
    }
    
    @Test
    public void testWaitListHandling() {
        excursion.addParticipant(user1);
        excursion.addParticipant(user2);
        excursion.addParticipant(user3);
        Usuario user4 = new Usuario("Max", "Payne", "max.payne@example.com");
        Usuario user5 = new Usuario("Alan", "Wake", "alan.wake@example.com");
        excursion.addParticipant(user4);
        excursion.addParticipant(user5); // This should add user to the wait list
        assertTrue(excursion.getState() instanceof Definitiva);
        assertEquals(1, excursion.getWaitList().size());
        assertTrue(excursion.getWaitList().contains(user5));
    }
    
    @Test
    public void testProvisionalToDefinitiveInfo() {
        excursion.addParticipant(user1);
        String infoBefore = excursion.getInfo();
        excursion.addParticipant(user2);
        String infoAfter = excursion.getInfo();
        assertFalse(infoBefore.equals(infoAfter));
        assertTrue(infoAfter.contains("Emails"));
    }/**/
}
