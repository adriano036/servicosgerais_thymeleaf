package servicosgerais.api.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the denuncia database table.
 * 
 */
@Entity
@NamedQuery(name="Denuncia.findAll", query="SELECT d FROM Denuncia d")
public class Denuncia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String texto;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Prestador
	@ManyToOne
	@JoinColumn(name="id_prestador")
	private Prestador prestador;

	public Denuncia() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Prestador getPrestador() {
		return this.prestador;
	}

	public void setPrestador(Prestador prestador) {
		this.prestador = prestador;
	}

}