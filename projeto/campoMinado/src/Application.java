package projeto.campoMinado.src;

import projeto.campoMinado.src.model.Board;
import projeto.campoMinado.src.view.BoardView;

public class Application {
    
    public static void main(String[] args) {
        
        Board board = new Board(6, 6, 10);
        new BoardView(board);
    }
}
