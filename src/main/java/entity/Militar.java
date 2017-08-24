package entity;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@NamedQuery(name="Militar.findAll", query="SELECT m FROM Militar m")
public class Militar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="nome_guerra")
	private String nomeGuerra;

	private String posto;

	//bi-directional many-to-one association to Companhia
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_companhia")
	private Companhia companhia;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;

	public Militar() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeGuerra() {
		return this.nomeGuerra;
	}

	public void setNomeGuerra(String nomeGuerra) {
		this.nomeGuerra = nomeGuerra;
	}

	public String getPosto() {
		return this.posto;
	}

	public void setPosto(String posto) {
		this.posto = posto;
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