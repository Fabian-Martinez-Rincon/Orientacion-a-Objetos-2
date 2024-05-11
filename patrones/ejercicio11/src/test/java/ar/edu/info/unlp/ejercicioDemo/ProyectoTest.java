package ar.edu.info.unlp.ejercicioDemo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ProyectoTest {

    Proyecto proyecto;
    Etapa etapaInicial;

    @BeforeEach
    void setUp() {
        proyecto = new Proyecto(
                "Nuevo Proyecto", // nombre
                LocalDate.of(2021, 1, 1), // fechaInicio
                LocalDate.of(2021, 1, 15), // fechaFin
                "Construir un ejemplo", // objetivo
                3, // numIntegrantes
                100.0
        );
    }

    @Test
    void crearProyecto_EstadoInicialEnConstruccion() {
        assertEquals("Nuevo Proyecto", proyecto.getNombre());
        assertNotNull(proyecto.getEstado());
    }

    @Test
    void aprobarEtapa_DeberiaCambiarEstado() {
        proyecto.aprobarEtapa();
        assertTrue(proyecto.getEstado() instanceof EnEvaluacion);
    }

    @Test
    void cancelarProyecto_DeberiaActualizarObjetivo() {
        proyecto.cancelarProyecto();
        assertTrue(proyecto.getObjetivo().contains("(Cancelado)"));
        assertTrue(proyecto.getEstado() instanceof Cancelada);
    }
    
    @Test
    void calcularCosto_DeberiaCalcularCorrectamente() {
        long dias = ChronoUnit.DAYS.between(proyecto.getFechaInicio(), proyecto.getFechaFin());
        double costoEsperado = dias * proyecto.getNumIntegrantes() * proyecto.getCostoPorDia();
        assertEquals(costoEsperado, proyecto.costoProyecto());
    }
    

    

    @Test
    void modificarMargenDeGanancia_EnConstruccionDeberiaPermitirCambio() {
        proyecto.setEtapa(new Construccion(proyecto)); // Configuramos el estado a Construccion para el test
        double nuevoMargen = 9.0;
        proyecto.modificarMargenDeGanancias(nuevoMargen);
        assertEquals(nuevoMargen, proyecto.getMargenGanancia());
    }
    
    /*

    @Test
    void modificarMargenDeGanancia_FueraDeConstruccionNoDeberiaPermitirCambio() {
        proyecto.setEstado(new EnEvaluacion()); // Configuramos el estado a EnEvaluacion
        double margenOriginal = proyecto.getMargenGanancia();
        double nuevoMargen = 12.0;

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            proyecto.modificarMargenDeGanancia(nuevoMargen);
        });

        String expectedMessage = "El margen de ganancia para 'En construcción' debe estar entre 8% y 10%.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
        assertEquals(margenOriginal, proyecto.getMargenGanancia()); // El margen debería seguir siendo el original
    }*/
}
