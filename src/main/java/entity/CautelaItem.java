package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name="cautela_item")
@NamedQuery(name="CautelaItem.findAll", query="SELECT c FROM CautelaItem c")
public class CautelaItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="dtc_devolucao")
	private Timestamp dtcDevolucao;

	@Column(name="qtd_cautela")
	private Integer qtdCautela;

	@Column(name="qtd_devolucao")
	private Integer qtdDevolucao;

	//bi-directional many-to-one association to Cautela
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_cautela")
	private Cautela cautela;

	//bi-directional many-to-one association to Item
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_item")
	private Item item;

	public CautelaItem() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getDtcDevolucao() {
		return this.dtcDevolucao;
	}

	public void setDtcDevolucao(Timestamp dtcDevolucao) {
		this.dtcDevolucao = dtcDevolucao;
	}

	public Integer getQtdCautela() {
		return this.qtdCautela;
	}

	public void setQtdCautela(Integer qtdCautela) {
		this.qtdCautela = qtdCautela;
	}

	public Integer getQtdDevolucao() {
		return this.qtdDevolucao;
	}

	public void setQtdDevolucao(Integer qtdDevolucao) {
		this.qtdDevolucao = qtdDevolucao;
	}

	public Cautela getCautela() {
		return this.cautela;
	}

	public void setCautela(Cautela cautela) {
		this.cautela = cautela;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}