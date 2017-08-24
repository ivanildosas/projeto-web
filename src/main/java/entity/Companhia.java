package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
@NamedQuery(name="Companhia.findAll", query="SELECT c FROM Companhia c")
public class Companhia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	/*
	@SequenceGenerator( name = "pk_companhia", sequenceName = "companhia_seq", allocationSize = 1 )
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "pk_companhia" )
	@Column( name = "ID", nullable = false )*/
	private Integer id;

	private String nome;

	//bi-directional many-to-one association to Militar
	@OneToMany(mappedBy="companhia")
	private List<Militar> militars;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="companhia")
	private List<Reserva> reservas;

	public Companhia() {
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

	public List<Militar> getMilitars() {
		return this.militars;
	}

	public void setMilitars(List<Militar> militars) {
		this.militars = militars;
	}

	public Militar addMilitar(Militar militar) {
		getMilitars().add(militar);
		militar.setCompanhia(this);

		return militar;
	}

	public Militar removeMilitar(Militar militar) {
		getMilitars().remove(militar);
		militar.setCompanhia(null);

		return militar;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setCompanhia(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setCompanhia(null);

		return reserva;
	}

}