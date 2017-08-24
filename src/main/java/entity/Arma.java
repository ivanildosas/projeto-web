package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
@NamedQuery(name="Arma.findAll", query="SELECT a FROM Arma a")
public class Arma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String calibre;

	private String fabricante;

	private String modelo;

	@Column(name="numero_serie")
	private String numeroSerie;

	//bi-directional many-to-one association to Item
	@OneToMany(mappedBy="arma")
	private List<Item> items;

	public Arma() {
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

	public String getFabricante() {
		return this.fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getNumeroSerie() {
		return this.numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public List<Item> getItems() {
		return this.items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Item addItem(Item item) {
		getItems().add(item);
		item.setArma(this);

		return item;
	}

	public Item removeItem(Item item) {
		getItems().remove(item);
		item.setArma(null);

		return item;
	}

}