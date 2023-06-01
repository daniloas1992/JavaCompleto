package model.inheritance;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

//se deixar sem "@Inheritance" cria uma única tabela com classe + herança

//InheritanceType.TABLE_PER_CLASS: Cada classe concreta gera uma tabela

//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Cria uma tabela com todos os campos das classe e um campo para diferenciar
//@Inheritance(strategy = InheritanceType.JOINED) // Cria tabelas com base nas classe e um campo para diferenciar

//Usa junto com SINGLE_TABLE ou JOINED: @DiscriminatorColumn(name= "type", length= 2, discriminatorType = DiscriminatorType.STRING)
//Usa junto com SINGLE_TABLE ou JOINED: @DiscriminatorValue("ST") // Cada classe precisa de um

@Entity                                                    
@Inheritance(strategy = InheritanceType.JOINED)      
@DiscriminatorColumn(name= "type", length= 2, discriminatorType = DiscriminatorType.STRING)	
@DiscriminatorValue("ST")																	
public class Student {                                                                      
	
	@Id
	private Long registration;
	
	private String name;

	public Student() {

	}

	public Student(Long registration, String name) {
		super();
		this.registration = registration;
		this.name = name;
	}

	public Long getRegistration() {
		return registration;
	}

	public void setRegistration(Long registration) {
		this.registration = registration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
