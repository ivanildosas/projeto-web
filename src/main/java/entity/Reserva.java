package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
@NamedQuery(name="Reserva.findAll", query="SELECT r FROM Reserva r")
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String descricao;

	private String sigla;

	//bi-directional many-to-one association to Cautela
	@OneToMany(mappedBy="reserva")
	private List<Cautela> cautelas;

	//bi-directional many-to-one association to ItemReserva
	@OneToMany(mappedBy="reserva")
	private List<ItemReserva> itemReservas;

	//bi-directional many-to-one association to Companhia
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_companhia")
	private Companhia companhia;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_responsavel")
	private Pessoa pessoa;

	public Reserva() {
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

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<Cautela> getCautelas() {
		return this.cautelas;
	}

	public void setCautelas(List<Cautela> cautelas) {
		this.cautelas = cautelas;
	}

	public Cautela addCautela(Cautela cautela) {
		getCautelas().add(cautela);
		cautela.setReserva(this);

		return cautela;
	}

	public Cautela removeCautela(Cautela cautela) {
		getCautelas().remove(cautela);
		cautela.setReserva(null);

		return cautela;
	}

	public List<ItemReserva> getItemReservas() {
		return this.itemReservas;
	}

	public void setItemReservas(List<ItemReserva> itemReservas) {
		this.itemReservas = itemReservas;
	}

	public ItemReserva addItemReserva(ItemReserva itemReserva) {
		getItemReservas().add(itemReserva);
		itemReserva.setReserva(this);

		return itemReserva;
	}

	public ItemReserva removeItemReserva(ItemReserva itemReserva) {
		getItemReservas().remove(itemReserva);
		itemReserva.setReserva(null);

		return itemReserva;
	}

	public Companhia getCompanhia() {
		return this.companhia;
	}

	public void setCompanhia(Companhia companhia) {
		this.companhia = companhia;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}