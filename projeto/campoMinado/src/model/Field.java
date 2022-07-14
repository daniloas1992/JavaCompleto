package projeto.campoMinado.src.model;

import java.util.ArrayList;
import java.util.List;

import projeto.campoMinado.src.exceptions.ExplosionException;

public class Field {

    private final int row;
    private final int column;
    
    private boolean hasBomb = false;
    private boolean opened = false;
    private boolean marked = false;

    private List<Field> neighboors = new ArrayList<>();

    public Field(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public boolean addNeighboor(Field neighboor) {
        
        boolean rowDiff = this.row != neighboor.row;
        boolean columnDiff = this.column != neighboor.column;
        boolean diagonal = rowDiff && columnDiff;

        int deltaRow = Math.abs(this.row - neighboor.row);
        int deltaColumn = Math.abs(this.column - neighboor.column);

        int deltaFinal = deltaRow + deltaColumn;

        if(deltaFinal == 1 && !diagonal) {
            neighboors.add(neighboor);
            return true;
        } else if (deltaFinal == 2 && diagonal) {
            neighboors.add(neighboor);
            return true;
        }

        return false;
    }

    protected void changeMarked() {
        if(!marked) {
            marked = !marked;
        }
    }

    protected boolean open() {

        if(!opened && !marked) {
            opened = true;

            if(hasBomb) {
                throw new ExplosionException();
            }

            if(safeNeighborhood()) {
                neighboors.forEach(n -> n.open());
            }

            return true;
        }

        return false;
    }

    protected boolean safeNeighborhood() {
        return neighboors.stream().noneMatch(n -> n.hasBomb);
    }
    
}
