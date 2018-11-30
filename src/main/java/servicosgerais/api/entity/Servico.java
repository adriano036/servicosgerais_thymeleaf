package servicosgerais.api.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the servico database table.
 * 
 */
@Entity
@NamedQuery(name="Servico.findAll", query="SELECT s FROM Servico s")
public class Servico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nome;

	//bi-directional many-to-one association to Servico
	@ManyToOne
	@JoinColumn(name="id_servico_pai")
	private Servico servico;

	//bi-directional many-to-one association to Servico
	@OneToMany(mappedBy="servico")
	private List<Servico> servicos;

	//bi-directional many-to-one association to ServicoPrestado
	@OneToMany(mappedBy="servico")
	private List<ServicoPrestado> servicoPrestados;

	//bi-directional many-to-one association to ServicoPrestador
	@OneToMany(mappedBy="servico")
	private List<ServicoPrestador> servicoPrestadors;

	public Servico() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Servico getServico() {
		return this.servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public List<Servico> getServicos() {
		return this.servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public Servico addServico(Servico servico) {
		getServicos().add(servico);
		servico.setServico(this);

		return servico;
	}

	public Servico removeServico(Servico servico) {
		getServicos().remove(servico);
		servico.setServico(null);

		return servico;
	}

	public List<ServicoPrestado> getServicoPrestados() {
		return this.servicoPrestados;
	}

	public void setServicoPrestados(List<ServicoPrestado> servicoPrestados) {
		this.servicoPrestados = servicoPrestados;
	}

	public ServicoPrestado addServicoPrestado(ServicoPrestado servicoPrestado) {
		getServicoPrestados().add(servicoPrestado);
		servicoPrestado.setServico(this);

		return servicoPrestado;
	}

	public ServicoPrestado removeServicoPrestado(ServicoPrestado servicoPrestado) {
		getServicoPrestados().remove(servicoPrestado);
		servicoPrestado.setServico(null);

		return servicoPrestado;
	}

	public List<ServicoPrestador> getServicoPrestadors() {
		return this.servicoPrestadors;
	}

	public void setServicoPrestadors(List<ServicoPrestador> servicoPrestadors) {
		this.servicoPrestadors = servicoPrestadors;
	}

	public ServicoPrestador addServicoPrestador(ServicoPrestador servicoPrestador) {
		getServicoPrestadors().add(servicoPrestador);
		servicoPrestador.setServico(this);

		return servicoPrestador;
	}

	public ServicoPrestador removeServicoPrestador(ServicoPrestador servicoPrestador) {
		getServicoPrestadors().remove(servicoPrestador);
		servicoPrestador.setServico(null);

		return servicoPrestador;
	}

}