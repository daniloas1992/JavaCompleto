package projeto.campoMinado.src.view;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import projeto.campoMinado.src.exceptions.ExitException;
import projeto.campoMinado.src.exceptions.ExplosionException;
import projeto.campoMinado.src.model.Board;

public class BoardView {

    private Board board;
    private Scanner in = new Scanner(System.in);

    public BoardView(Board board) {
        this.board = board;

        startGame();
    }

    private void startGame() {
        try {
            boolean proceed = true;

            while(proceed) {

                play();

                System.out.println("Play again? (Y/n): ");
                String answer = in.nextLine();

                if("n".equalsIgnoreCase(answer)) {
                    proceed = false;
                } else {
                    board.restart();
                }
            }

        } catch (ExitException e) {
            System.out.println("Bye Bye!!!");
        } finally {
            in.close();
        }
    }

    private void play() {
       try {

            while(!board.goalAchieved()) {
                
                System.out.println(board);

                String inputValue = inputValue("Insert (row,column): ");
                Iterator<Integer> values = Arrays.stream(inputValue.split(","))
                                                 .map(value -> Integer.parseInt(value.trim()))
                                                 .iterator();

                inputValue = inputValue("1 - Open or 2 - (Un)Mark:");

                if("1".equals((inputValue))) {
                    board.open(values.next(), values.next());
                } else if ("2".equals((inputValue))){
                    board.changeMarked(values.next(), values.next());
                }

            }
            
            System.out.println(board);
            System.out.println("You Win!");

       } catch (ExplosionException e) {
            System.out.println(board);
            System.out.println("You lost!");
       } 
    }

    private String inputValue(String text) {

        System.out.print(text);
        String input = in.nextLine();

        if("exit".equalsIgnoreCase(input)) {
            throw new ExitException();
        }

        return input;

    }
    
}
