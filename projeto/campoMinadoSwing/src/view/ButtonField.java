package projeto.campoMinadoSwing.src.view;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;

import projeto.campoMinadoSwing.src.model.Field;
import projeto.campoMinadoSwing.src.model.FieldEvent;
import projeto.campoMinadoSwing.src.model.FieldObserver;

public class ButtonField extends JButton  implements FieldObserver{
    
    private final Color BG_DEFAULT = new Color(184, 184, 184);
    private final Color BG_CHECK = new Color(8, 179, 247);
    private final Color BG_EXPLODE = new Color(189, 66, 68);
    private final Color TEXT_GREEN = new Color(0, 100, 0);

    private Field field;

    public ButtonField(Field field) {
        this.field = field;
        setBackground(BG_DEFAULT);
        setBorder(BorderFactory.createBevelBorder(0));;
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
    }

    private void aplyStyleDefault() {
    }

    private void aplyStyleExplode() {
    }

    private void aplyStyleCheck() {
    }

    private void aplyStyleOpen() {
    }
}
