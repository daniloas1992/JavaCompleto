package model.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SS")
public class StudentSchorlarship extends Student {
	
	private double schorlarshipValue;

	public StudentSchorlarship() {

	}

	public StudentSchorlarship(Long registration, String name, double schorlarshipValue) {
		super(registration, name);
		this.schorlarshipValue = schorlarshipValue;
	}

	public double getSchorlarshipValue() {
		return schorlarshipValue;
	}

	public void setSchorlarshipValue(double schorlarshipValue) {
		this.schorlarshipValue = schorlarshipValue;
	}

}
