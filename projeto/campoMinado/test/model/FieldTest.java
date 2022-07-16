package projeto.campoMinado.test.model;

import projeto.campoMinado.src.exceptions.ExplosionException;
import projeto.campoMinado.src.model.Field;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

    @Test
    public void testInitialMarked() {
        assertFalse(field.isMarked());
    }

    @Test
    public void testChangeMarked() {
        field.changeMarked();
        assertTrue(field.isMarked());
    }

    @Test
    public void testChangeMarkedTwice() {
        field.changeMarked();
        field.changeMarked();
        assertFalse(field.isMarked());
    }

    @Test
    public void testOpenNoBombNoMarked() {
        assertTrue(field.open());
    }

    @Test
    public void testOpenNoBombMarked() {
        field.changeMarked();
        assertFalse(field.open());
    }

    @Test
    public void testOpenBombMarked() {
        field.changeMarked();
        field.setBomb();
        assertFalse(field.open());
    }

    @Test
    public void testOpenBombNoMarked() {
        field.setBomb();
        assertThrows(ExplosionException.class, () -> {
            field.open();
        });
    }

    @Test
    public void testOpenWithSafeNeighboors() {

        Field field11 = new Field(1,1);
        Field field22 = new Field(2,2);

        field22.addNeighboor(field11);
    
        field.addNeighboor(field22);
        field.open();

        assertTrue(field22.isOpened() && field11.isOpened());
    }

    @Test
    public void testOpenWithBombNeighboor() {

        Field field11 = new Field(1,1);
        Field field12 = new Field(1,2);
        Field field22 = new Field(2,2);

        field12.setBomb();

        field22.addNeighboor(field11);
        field22.addNeighboor(field12);
    
        field.addNeighboor(field22);
        field.open();

        assertTrue(field22.isOpened() && field11.isClosed());
    }

}
