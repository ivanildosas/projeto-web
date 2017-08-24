package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
@NamedQuery(name="Item.findAll", query="SELECT i FROM Item i")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String descricao;

	//bi-directional many-to-one association to CautelaItem
	@OneToMany(mappedBy="item")
	private List<CautelaItem> cautelaItems;

	//bi-directional many-to-one association to Acessorio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_acessorio")
	private Acessorio acessorio;

	//bi-directional many-to-one association to Arma
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_arma")
	private Arma arma;

	//bi-directional many-to-one association to Municao
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_municao")
	private Municao municao;

	//bi-directional many-to-one association to ItemReserva
	@OneToMany(mappedBy="item")
	private List<ItemReserva> itemReservas;

	public Item() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<CautelaItem> getCautelaItems() {
		return this.cautelaItems;
	}

	public void setCautelaItems(List<CautelaItem> cautelaItems) {
		this.cautelaItems = cautelaItems;
	}

	public CautelaItem addCautelaItem(CautelaItem cautelaItem) {
		getCautelaItems().add(cautelaItem);
		cautelaItem.setItem(this);

		return cautelaItem;
	}

	public CautelaItem removeCautelaItem(CautelaItem cautelaItem) {
		getCautelaItems().remove(cautelaItem);
		cautelaItem.setItem(null);

		return cautelaItem;
	}

	public Acessorio getAcessorio() {
		return this.acessorio;
	}

	public void setAcessorio(Acessorio acessorio) {
		this.acessorio = acessorio;
	}

	public Arma getArma() {
		return this.arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}

	public Municao getMunicao() {
		return this.municao;
	}

	public void setMunicao(Municao municao) {
		this.municao = municao;
	}

	public List<ItemReserva> getItemReservas() {
		return this.itemReservas;
	}

	public void setItemReservas(List<ItemReserva> itemReservas) {
		this.itemReservas = itemReservas;
	}

	public ItemReserva addItemReserva(ItemReserva itemReserva) {
		getItemReservas().add(itemReserva);
		itemReserva.setItem(this);

		return itemReserva;
	}

	public ItemReserva removeItemReserva(ItemReserva itemReserva) {
		getItemReservas().remove(itemReserva);
		itemReserva.setItem(null);

		return itemReserva;
	}

}