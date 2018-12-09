package servicosgerais.app.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the servico_sistema_prestado database table.
 * 
 */
@Entity
@Table(name="servico_sistema_prestado")
@NamedQuery(name="ServicoSistemaPrestado.findAll", query="SELECT s FROM ServicoSistemaPrestado s")
public class ServicoSistemaPrestado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to HistoricoPagamento
	@OneToMany(mappedBy="servicoSistemaPrestado")
	private List<HistoricoPagamento> historicoPagamentos;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="id_empresa")
	private Empresa empresa;

	//bi-directional many-to-one association to Prestador
	@ManyToOne
	@JoinColumn(name="id_prestador")
	private Prestador prestador;

	//bi-directional many-to-one association to ServicoSistema
	@ManyToOne
	@JoinColumn(name="id_servico_sistema")
	private ServicoSistema servicoSistema;

	public ServicoSistemaPrestado() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<HistoricoPagamento> getHistoricoPagamentos() {
		return this.historicoPagamentos;
	}

	public void setHistoricoPagamentos(List<HistoricoPagamento> historicoPagamentos) {
		this.historicoPagamentos = historicoPagamentos;
	}

	public HistoricoPagamento addHistoricoPagamento(HistoricoPagamento historicoPagamento) {
		getHistoricoPagamentos().add(historicoPagamento);
		historicoPagamento.setServicoSistemaPrestado(this);

		return historicoPagamento;
	}

	public HistoricoPagamento removeHistoricoPagamento(HistoricoPagamento historicoPagamento) {
		getHistoricoPagamentos().remove(historicoPagamento);
		historicoPagamento.setServicoSistemaPrestado(null);

		return historicoPagamento;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Prestador getPrestador() {
		return this.prestador;
	}

	public void setPrestador(Prestador prestador) {
		this.prestador = prestador;
	}

	public ServicoSistema getServicoSistema() {
		return this.servicoSistema;
	}

	public void setServicoSistema(ServicoSistema servicoSistema) {
		this.servicoSistema = servicoSistema;
	}

}