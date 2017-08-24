package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


@Entity
@NamedQuery(name="Cautela.findAll", query="SELECT c FROM Cautela c")
public class Cautela implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="dtc_retirada")
	private Timestamp dtcRetirada;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;

	//bi-directional many-to-one association to Reserva
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_reserva")
	private Reserva reserva;

	//bi-directional many-to-one association to CautelaItem
	@OneToMany(mappedBy="cautela")
	private List<CautelaItem> cautelaItems;

	public Cautela() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getDtcRetirada() {
		return this.dtcRetirada;
	}

	public void setDtcRetirada(Timestamp dtcRetirada) {
		this.dtcRetirada = dtcRetirada;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Reserva getReserva() {
		return this.reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public List<CautelaItem> getCautelaItems() {
		return this.cautelaItems;
	}

	public void setCautelaItems(List<CautelaItem> cautelaItems) {
		this.cautelaItems = cautelaItems;
	}

	public CautelaItem addCautelaItem(CautelaItem cautelaItem) {
		getCautelaItems().add(cautelaItem);
		cautelaItem.setCautela(this);

		return cautelaItem;
	}

	public CautelaItem removeCautelaItem(CautelaItem cautelaItem) {
		getCautelaItems().remove(cautelaItem);
		cautelaItem.setCautela(null);

		return cautelaItem;
	}

}