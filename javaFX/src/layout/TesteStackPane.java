package layout;

import javafx.scene.layout.StackPane;

public class TesteStackPane extends StackPane {
	
	public TesteStackPane() {
		Caixa c1 = new Caixa().comTexto("1");
		Caixa c2 = new Caixa().comTexto("2");
		Caixa c3 = new Caixa().comTexto("3");
		Caixa c4 = new Caixa().comTexto("4");
		Caixa c5 = new Caixa().comTexto("5");
		Caixa c6 = new Caixa().comTexto("6");
		
		getChildren().addAll(c2, c3, c4, c5, c6, c1);
		
		setOnMouseClicked(e -> {
			if(e.getSceneX() > getScene().getWidth() / 2) { // Clique do lado direito
				getChildren().get(0).toFront(); // Pega o elemento do índice "0" e envia para o final (Topo da pilha)
			} else {
				getChildren().get(5).toBack(); // Pega o elemento do índice "5" e envia pro começo (Baixo da pilha)
			}
		});
		
	}

}
