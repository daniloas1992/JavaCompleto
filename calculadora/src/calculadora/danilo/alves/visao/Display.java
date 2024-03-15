package calculadora.danilo.alves.visao;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import calculadora.danilo.alves.modelo.Memoria;
import calculadora.danilo.alves.modelo.MemoriaObserver;

@SuppressWarnings("serial")
public class Display extends JPanel implements MemoriaObserver{
	
	private JLabel label; 
	
	public Display() {
		
		Memoria.getInstancia().adicionarObserver(this);
		
		setBackground(new Color(46,49,50));
		label = new JLabel(Memoria.getInstancia().getTextoAtual());
		label.setForeground(Color.WHITE);
		label.setFont(new Font("courier", Font.PLAIN, 30));
		
		setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 20));
		
		add(label);
	}

	@Override
	public void valorAlterado(String novoValor) {
		label.setText(novoValor);
	}

}
