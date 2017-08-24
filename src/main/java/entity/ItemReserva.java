package entity;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="item_reserva")
@NamedQuery(name="ItemReserva.findAll", query="SELECT i FROM ItemReserva i")
public class ItemReserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="ind_cautela")
	private Boolean indCautela;

	private Integer quantidade;

	//bi-directional many-to-one association to Item
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_item")
	private Item item;

	//bi-directional many-to-one association to Reserva
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_reserva")
	private Reserva reserva;

	public ItemReserva() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getIndCautela() {
		return this.indCautela;
	}

	public void setIndCautela(Boolean indCautela) {
		this.indCautela = indCautela;
	}

	public Integer getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Reserva getReserva() {
		return this.reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

}