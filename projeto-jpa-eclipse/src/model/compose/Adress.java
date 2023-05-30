package model.compose;

import javax.persistence.Embeddable;

@Embeddable //Insere os campos dessa classe na tabela da classe que fizer referência a esta
public class Adress {
	
	private String street;
	
	private String number;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}
