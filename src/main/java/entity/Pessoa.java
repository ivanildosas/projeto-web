package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
@NamedQuery(name="Pessoa.findAll", query="SELECT p FROM Pessoa p")
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String email;

	private String nome;

	private String telefone;

	//bi-directional many-to-one association to Cautela
	@OneToMany(mappedBy="pessoa")
	private List<Cautela> cautelas;

	//bi-directional many-to-one association to Militar
	@OneToMany(mappedBy="pessoa")
	private List<Militar> militars;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="pessoa")
	private List<Reserva> reservas;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="pessoa")
	private List<Usuario> usuarios;

	public Pessoa() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Cautela> getCautelas() {
		return this.cautelas;
	}

	public void setCautelas(List<Cautela> cautelas) {
		this.cautelas = cautelas;
	}

	public Cautela addCautela(Cautela cautela) {
		getCautelas().add(cautela);
		cautela.setPessoa(this);

		return cautela;
	}

	public Cautela removeCautela(Cautela cautela) {
		getCautelas().remove(cautela);
		cautela.setPessoa(null);

		return cautela;
	}

	public List<Militar> getMilitars() {
		return this.militars;
	}

	public void setMilitars(List<Militar> militars) {
		this.militars = militars;
	}

	public Militar addMilitar(Militar militar) {
		getMilitars().add(militar);
		militar.setPessoa(this);

		return militar;
	}

	public Militar removeMilitar(Militar militar) {
		getMilitars().remove(militar);
		militar.setPessoa(null);

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
		reserva.setPessoa(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setPessoa(null);

		return reserva;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setPessoa(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setPessoa(null);

		return usuario;
	}

}