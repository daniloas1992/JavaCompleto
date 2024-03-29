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

    public void changeMarked() {
        if(!opened) {
            marked = !marked;
        }
    }

    public boolean open() {

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

    public boolean isMarked() {
        return marked;
    }

    public void setBomb() {
        hasBomb = true;
    }

    public boolean hasBomb() {
        return hasBomb;
    }

    public boolean isOpened() {
        return opened;
    }

    void setOpened(final boolean opened) {
        this.opened = opened;
    }

    public boolean isClosed() {
        return !opened;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean goalAchieved() {
        final boolean unraveled = !hasBomb && opened;
        final boolean covered = hasBomb && marked;
        return unraveled || covered;
    }

    public long neighboorsBomb() {
       return neighboors.stream().filter(v -> v.hasBomb).count();
    }
    
    public void restart() {
        hasBomb = false;
        opened = false;
        marked = false;
    }

    @Override
    public String toString() {
        if(marked) {
            return "x";
        } else if (opened && hasBomb) {
            return "*";
        } else if (opened && neighboorsBomb() > 0) {
            return Long.toString(neighboorsBomb());
        } else if (opened) {
            return " ";
        } else {
            return "?";
        }
    }

}
