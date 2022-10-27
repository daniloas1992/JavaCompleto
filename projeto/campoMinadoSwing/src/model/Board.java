package projeto.campoMinadoSwing.src.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import projeto.campoMinadoSwing.src.view.ButtonField;

public class Board implements FieldObserver{

    private final int rows;
    private final int columns;
    private final int bombs;

    private final List<Field> fields = new ArrayList<>();
    private final List<Consumer<ResultEvent>> observers = new ArrayList<>();

    public Board(int rows, int columns, int bombs) {
        this.rows = rows;
        this.columns = columns;
        this.bombs = bombs;

        generateFields();
        connectNeighboors();
        drawBombs();

    }

    public void forEachField(Consumer<Field> function) {
        fields.forEach(function);
    }

    public void registerObserver(Consumer<ResultEvent> observer) {
        observers.add(observer);
    }

    private void notifyObservers(boolean result) {
        observers.stream()
                 .forEach(o -> o.accept(new ResultEvent((result))));
    }

    private void generateFields() {
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                Field field = new Field(row, column);
                field.registerObserver(this);
                fields.add(field);
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


    public int getRows() {
        return this.rows;
    }


    public int getColumns() {
        return this.columns;
    }

    public void open(int row, int column) {

        fields.parallelStream()
              .filter(field -> field.getRow() == row && field.getColumn() == column)
              .findFirst()
              .ifPresent(field -> field.open());             
    }

    public void changeMarked(int row, int column) {
        fields.parallelStream()
              .filter(field -> field.getRow() == row && field.getColumn() == column)
              .findFirst()
              .ifPresent(field -> field.changeMarked());         
    }

    @Override
    public void eventOccurred(Field field, FieldEvent event) {
        if(event == FieldEvent.EXPLODE)         {
            showBombs();
            notifyObservers(false);
        } else if (goalAchieved()) {
            notifyObservers(true);
        }
    }

    private void showBombs() {
        fields.stream()
              .filter(field -> field.hasBomb())
              .filter(field -> !field.isMarked())
              .forEach(field -> field.setOpened(true));
    }    
}
