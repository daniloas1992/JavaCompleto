package layout;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Quadrado extends Rectangle{

private static int i = 0;
	
	private String[] cores = {
		"#c33c5e", "#39aac5", "#28d78a", "fb520c", "#6547a5", "f50428"	
	};
	
	public Quadrado() {
		this(100, 100);
	}
	
	public Quadrado(int tamanho) {
		this(tamanho, tamanho);
	}
	
	public Quadrado(int largura, int altura) {
		
		setWidth(largura);
		setHeight(altura);
		
		setFill(Color.web(cores[i++]));
				
		if(i == 6) i =0;
	}
	
}
