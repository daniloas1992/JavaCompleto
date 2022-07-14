package projeto.campoMinado.test.model;

import projeto.campoMinado.src.model.Field;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FieldTest {

    private Field field;

    @BeforeEach
    public void inicializeField() {
        field = new Field(3,3);
    }
    
    @Test
    public void testTrueNeighboorLeft() {
        Field neighboor = new Field(3,2);    
        boolean result = field.addNeighboor(neighboor);
        assertTrue(result);
    }

    @Test
    public void testTrueNeighboorRight() {
        Field neighboor = new Field(3,4);    
        boolean result = field.addNeighboor(neighboor);
        assertTrue(result);
    }

    @Test
    public void testTrueNeighboorUp() {
        Field neighboor = new Field(2,3);    
        boolean result = field.addNeighboor(neighboor);
        assertTrue(result);
    }

    @Test
    public void testTrueNeighboorDown() {
        Field neighboor = new Field(4,3);    
        boolean result = field.addNeighboor(neighboor);
        assertTrue(result);
    }

    @Test
    public void testTrueNeighboorDiagonal() {
        Field neighboor = new Field(2,2);    
        boolean result = field.addNeighboor(neighboor);
        assertTrue(result);
    }

    @Test
    public void testFalseNeighboor() {
        Field neighboor = new Field(1,1);    
        boolean result = field.addNeighboor(neighboor);
        assertFalse(result);
    }

}
