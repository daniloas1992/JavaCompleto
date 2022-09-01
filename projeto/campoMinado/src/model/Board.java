package projeto.campoMinado.src.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import projeto.campoMinado.src.exceptions.ExplosionException;

public class Board {

    private int rows;
    private int columns;
    private int bombs;

    private final List<Field> fields = new ArrayList<>();  

    public Board(int rows, int columns, int bombs) {
        this.rows = rows;
        this.columns = columns;
        this.bombs = bombs;

        generateFields();
        connectNeighboors();
        drawBombs();

    }

    private void generateFields() {
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                fields.add(new Field(row, column));
            }
        }
    }

    private void connectNeighboors() {
        for(Field f1: fields) {
            for (Field f2: fields) {
                f1.addNeighboor(f2);
            }
        }
    }

    private void drawBombs() {
        long countBombs = 0;

        Predicate<Field> hasBomb = field -> field.hasBomb();

        do {
            final int random = (int) (Math.random() * fields.size());
            fields.get(random).setBomb();
            countBombs = fields.stream().filter(hasBomb).count();
        } while (countBombs < bombs);
    }

    public boolean goalAchieved() {
        return fields.stream().allMatch(field -> field.goalAchieved());
    }

    public void restart() {
        fields.stream().forEach(field -> field.restart());
        drawBombs();
    }

    public void open(int row, int column) {

        try {
            fields.parallelStream()
              .filter(field -> field.getRow() == row && field.getColumn() == column)
              .findFirst()
              .ifPresent(field -> field.open());
        } catch (ExplosionException e) {

            fields.forEach(field -> field.setOpened(true));
            throw e;
        }

                 
    }

    public void changeMarked(int row, int column) {
        fields.parallelStream()
              .filter(field -> field.getRow() == row && field.getColumn() == column)
              .findFirst()
              .ifPresent(field -> field.changeMarked());         
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        
        sb.append("  ");
        for (int column = 0; column < columns; column++) {
            sb.append(" ").append(column).append(" ");
        }
        sb.append("\n");

        int position = 0;
        for (int row = 0; row < rows; row++) {
            sb.append(" ").append(row);
            for (int column = 0; column < columns; column++) {
                sb.append(" ");
                sb.append(fields.get(position));
                sb.append(" ");
                position++;
            }
            sb.append("\n");
        }

        return sb.toString();
    }
    
}
