package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
@NamedQuery(name="Municao.findAll", query="SELECT m FROM Municao m")
public class Municao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String calibre;

	//bi-directional many-to-one association to Item
	@OneToMany(mappedBy="municao")
	private List<Item> items;

	public Municao() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCalibre() {
		return this.calibre;
	}

	public void setCalibre(String calibre) {
		this.calibre = calibre;
	}

	public List<Item> getItems() {
		return this.items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Item addItem(Item item) {
		getItems().add(item);
		item.setMunicao(this);

		return item;
	}

	public Item removeItem(Item item) {
		getItems().remove(item);
		item.setMunicao(null);

		return item;
	}

}