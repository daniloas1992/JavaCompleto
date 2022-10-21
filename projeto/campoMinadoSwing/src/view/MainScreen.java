package projeto.campoMinadoSwing.src.view;

import javax.swing.JFrame;

import projeto.campoMinadoSwing.src.model.Board;

public class MainScreen extends JFrame{


    public MainScreen() {

        Board board = new Board(16, 30, 50);
        add(new PanelBoard(board));

        setTitle("Minefield");
        setSize(690, 438);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        
        new MainScreen();
        
    }
    
}
