package model.onetomany;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Ordered", schema = "curso_java") // "Order" é palavra reservada no MySql, não pode ser usado como nome de tabela!
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Date date;
	
	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY) // Nome do atributo na classe "Order" que está com a anotação "@ManyToOne"
	private List<ItemOrder> itens;                         // LAZY = Quando é "ToMany" por padrão é LAZY, só carrega se for usar
	
	public Order() {
		this(new Date());
	}

	public Order(Date date) {
		super();
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<ItemOrder> getItens() {
		return itens;
	}

	public void setItens(List<ItemOrder> itens) {
		this.itens = itens;
	}

}
