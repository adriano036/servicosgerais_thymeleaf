package servicosgerais.api.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the servico_sistema database table.
 * 
 */
@Entity
@Table(name="servico_sistema")
@NamedQuery(name="ServicoSistema.findAll", query="SELECT s FROM ServicoSistema s")
public class ServicoSistema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="custo_fixo")
	private BigDecimal custoFixo;

	private String nome;

	private int porcentagem;

	//bi-directional many-to-one association to ServicoSistemaPrestado
	@OneToMany(mappedBy="servicoSistema")
	private List<ServicoSistemaPrestado> servicoSistemaPrestados;

	public ServicoSistema() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getCustoFixo() {
		return this.custoFixo;
	}

	public void setCustoFixo(BigDecimal custoFixo) {
		this.custoFixo = custoFixo;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPorcentagem() {
		return this.porcentagem;
	}

	public void setPorcentagem(int porcentagem) {
		this.porcentagem = porcentagem;
	}

	public List<ServicoSistemaPrestado> getServicoSistemaPrestados() {
		return this.servicoSistemaPrestados;
	}

	public void setServicoSistemaPrestados(List<ServicoSistemaPrestado> servicoSistemaPrestados) {
		this.servicoSistemaPrestados = servicoSistemaPrestados;
	}

	public ServicoSistemaPrestado addServicoSistemaPrestado(ServicoSistemaPrestado servicoSistemaPrestado) {
		getServicoSistemaPrestados().add(servicoSistemaPrestado);
		servicoSistemaPrestado.setServicoSistema(this);

		return servicoSistemaPrestado;
	}

	public ServicoSistemaPrestado removeServicoSistemaPrestado(ServicoSistemaPrestado servicoSistemaPrestado) {
		getServicoSistemaPrestados().remove(servicoSistemaPrestado);
		servicoSistemaPrestado.setServicoSistema(null);

		return servicoSistemaPrestado;
	}

}