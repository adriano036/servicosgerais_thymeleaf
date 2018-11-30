package servicosgerais.api.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the servico_prestador database table.
 * 
 */
@Entity
@Table(name="servico_prestador")
@NamedQuery(name="ServicoPrestador.findAll", query="SELECT s FROM ServicoPrestador s")
public class ServicoPrestador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to Prestador
	@ManyToOne
	@JoinColumn(name="id_prestador")
	private Prestador prestador;

	//bi-directional many-to-one association to Servico
	@ManyToOne
	@JoinColumn(name="id_servico")
	private Servico servico;

	public ServicoPrestador() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Prestador getPrestador() {
		return this.prestador;
	}

	public void setPrestador(Prestador prestador) {
		this.prestador = prestador;
	}

	public Servico getServico() {
		return this.servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

}