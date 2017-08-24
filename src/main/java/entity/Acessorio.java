package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(name="Acessorio.findAll", query="SELECT a FROM Acessorio a")
public class Acessorio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nome;

	//bi-directional many-to-one association to Item
	@OneToMany(mappedBy="acessorio")
	private List<Item> items;

	public Acessorio() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Item> getItems() {
		return this.items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Item addItem(Item item) {
		getItems().add(item);
		item.setAcessorio(this);

		return item;
	}

	public Item removeItem(Item item) {
		getItems().remove(item);
		item.setAcessorio(null);

		return item;
	}

}