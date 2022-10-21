package projeto.campoMinadoSwing.src.view;

import javax.swing.JButton;
import javax.swing.JPanel;

import projeto.campoMinadoSwing.src.model.Board;
import java.awt.GridLayout;

public class PanelBoard extends JPanel{


    public PanelBoard(Board board) {

        setLayout(new GridLayout(board.getRows(), board.getColumns()));

        board.forEachField(f -> add(new ButtonField(f)));

        board.registerObserver(e -> {
            // TODO: Mostrar resultado para o usuário!
        });

    }
  
}
