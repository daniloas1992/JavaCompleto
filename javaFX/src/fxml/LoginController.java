package fxml;

import org.controlsfx.control.Notifications;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;

public class LoginController {
	
	@FXML
	private TextField campoEmail;
	
	@FXML
	private TextField campoSenha;
	
	public void entrar() {
		
		boolean emailValido = campoEmail.getText().equals("123@123.com");
		boolean senhaValida = campoSenha.getText().equals("123");
		
		if(emailValido && senhaValida) {
			Notifications.create()
						 .position(Pos.TOP_RIGHT)
						 .title("Login FXML")
						 .text("Login efetuado com sucesso!")
						 .showInformation();
		} else {
			Notifications.create()
						 .position(Pos.TOP_RIGHT)
						 .title("Login FXML")
						 .text("Falha no Login!")
						 .showError();
		}
	}

}
