package servicosgerais.api.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the historico_pagamento database table.
 * 
 */
@Entity
@Table(name="historico_pagamento")
@NamedQuery(name="HistoricoPagamento.findAll", query="SELECT h FROM HistoricoPagamento h")
public class HistoricoPagamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int ano;

	private int mes;

	private BigDecimal valor;

	//bi-directional many-to-one association to ServicoPrestado
	@ManyToOne
	@JoinColumn(name="id_servico_prestado")
	private ServicoPrestado servicoPrestado;

	//bi-directional many-to-one association to ServicoSistemaPrestado
	@ManyToOne
	@JoinColumn(name="id_servico_sistema_prestado")
	private ServicoSistemaPrestado servicoSistemaPrestado;

	public HistoricoPagamento() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAno() {
		return this.ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getMes() {
		return this.mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public ServicoPrestado getServicoPrestado() {
		return this.servicoPrestado;
	}

	public void setServicoPrestado(ServicoPrestado servicoPrestado) {
		this.servicoPrestado = servicoPrestado;
	}

	public ServicoSistemaPrestado getServicoSistemaPrestado() {
		return this.servicoSistemaPrestado;
	}

	public void setServicoSistemaPrestado(ServicoSistemaPrestado servicoSistemaPrestado) {
		this.servicoSistemaPrestado = servicoSistemaPrestado;
	}

}