package projeto.campoMinadoSwing.src.view;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import projeto.campoMinadoSwing.src.model.Field;
import projeto.campoMinadoSwing.src.model.FieldEvent;
import projeto.campoMinadoSwing.src.model.FieldObserver;

public class ButtonField extends JButton  implements FieldObserver, MouseListener{
    
    private final Color BG_DEFAULT = new Color(184, 184, 184);
    private final Color BG_CHECK = new Color(8, 179, 247);
    private final Color BG_EXPLODE = new Color(189, 66, 68);
    private final Color TEXT_GREEN = new Color(0, 100, 0);

    private Field field;

    public ButtonField(Field field) {
        this.field = field;
        setBackground(BG_DEFAULT);
        setOpaque(true);
        setBorder(BorderFactory.createBevelBorder(0));
        
        addMouseListener(this);
        field.registerObserver(this);        
    }

    @Override
    public void eventOccurred(Field field, FieldEvent event) {

        switch(event) {
            case OPEN:
                aplyStyleOpen();
                break;
            case CHECK:
                aplyStyleCheck();
                break;
            case EXPLODE:
                aplyStyleExplode();
                break;
            default:
                aplyStyleDefault();
        }

        SwingUtilities.invokeLater(() -> {
            repaint();
            validate();
        });
    }

    private void aplyStyleDefault() {
        setBackground(BG_DEFAULT);
        setBorder(BorderFactory.createBevelBorder(0));
        setText("");
    }

    private void aplyStyleExplode() {
        setBackground(BG_EXPLODE);
        setForeground(Color.WHITE);
        setText("X");
    }

    private void aplyStyleCheck() {
        setBackground(BG_CHECK);
        setForeground(Color.BLACK);
        setText("M");
    }

    private void aplyStyleOpen() {

        setBorder(BorderFactory.createLineBorder(Color.GRAY));

        if(field.hasBomb()) {
            setBackground(BG_EXPLODE);
            return;
        }

        setBackground(BG_DEFAULT);       

        switch (field.neighboorsBomb()) {
            case 1:
                setForeground(TEXT_GREEN);
                break;
            case 2:
                setForeground(Color.BLUE);
                break;
            case 3:
                setForeground(Color.YELLOW);
                break;
            case 4:
            case 5:
            case 6:
                setForeground(Color.RED);
                break;
            default:
                setForeground(Color.PINK);
        }

        String value = !field.safeNeighborhood() ? field.neighboorsBomb() + "" : "";

        setText(value);
    }


    //Mouse interface listener

    @Override
    public void mousePressed(MouseEvent e) {
       if(e.getButton() == 1)  {
        field.open();
       } else {
        field.changeMarked();
       }
    }

    public void mouseClicked(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}
}
