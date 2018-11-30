package servicosgerais.api.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the empresa database table.
 * 
 */
@Entity
@NamedQuery(name="Empresa.findAll", query="SELECT e FROM Empresa e")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String cnpj;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne
	@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;

	//bi-directional many-to-one association to Prestador
	@OneToMany(mappedBy="empresa")
	private List<Prestador> prestadors;

	//bi-directional many-to-one association to ServicoSistemaPrestado
	@OneToMany(mappedBy="empresa")
	private List<ServicoSistemaPrestado> servicoSistemaPrestados;

	public Empresa() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Prestador> getPrestadors() {
		return this.prestadors;
	}

	public void setPrestadors(List<Prestador> prestadors) {
		this.prestadors = prestadors;
	}

	public Prestador addPrestador(Prestador prestador) {
		getPrestadors().add(prestador);
		prestador.setEmpresa(this);

		return prestador;
	}

	public Prestador removePrestador(Prestador prestador) {
		getPrestadors().remove(prestador);
		prestador.setEmpresa(null);

		return prestador;
	}

	public List<ServicoSistemaPrestado> getServicoSistemaPrestados() {
		return this.servicoSistemaPrestados;
	}

	public void setServicoSistemaPrestados(List<ServicoSistemaPrestado> servicoSistemaPrestados) {
		this.servicoSistemaPrestados = servicoSistemaPrestados;
	}

	public ServicoSistemaPrestado addServicoSistemaPrestado(ServicoSistemaPrestado servicoSistemaPrestado) {
		getServicoSistemaPrestados().add(servicoSistemaPrestado);
		servicoSistemaPrestado.setEmpresa(this);

		return servicoSistemaPrestado;
	}

	public ServicoSistemaPrestado removeServicoSistemaPrestado(ServicoSistemaPrestado servicoSistemaPrestado) {
		getServicoSistemaPrestados().remove(servicoSistemaPrestado);
		servicoSistemaPrestado.setEmpresa(null);

		return servicoSistemaPrestado;
	}

}