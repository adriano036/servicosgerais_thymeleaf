package servicosgerais.api.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the servico_prestado database table.
 * 
 */
@Entity
@Table(name="servico_prestado")
@NamedQuery(name="ServicoPrestado.findAll", query="SELECT s FROM ServicoPrestado s")
public class ServicoPrestado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="avaliacao_cliente")
	private int avaliacaoCliente;

	@Column(name="avaliacao_prestador")
	private int avaliacaoPrestador;

	@Column(name="ind_confirmacao_valor")
	private byte indConfirmacaoValor;

	@Column(name="valor_cliente")
	private BigDecimal valorCliente;

	@Column(name="valor_devido")
	private BigDecimal valorDevido;

	@Column(name="valor_prestador")
	private BigDecimal valorPrestador;

	//bi-directional many-to-one association to Comentario
	@OneToMany(mappedBy="servicoPrestado")
	private List<Comentario> comentarios;

	//bi-directional many-to-one association to HistoricoPagamento
	@OneToMany(mappedBy="servicoPrestado")
	private List<HistoricoPagamento> historicoPagamentos;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Prestador
	@ManyToOne
	@JoinColumn(name="id_prestador")
	private Prestador prestador;

	//bi-directional many-to-one association to Servico
	@ManyToOne
	@JoinColumn(name="id_servico")
	private Servico servico;

	public ServicoPrestado() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAvaliacaoCliente() {
		return this.avaliacaoCliente;
	}

	public void setAvaliacaoCliente(int avaliacaoCliente) {
		this.avaliacaoCliente = avaliacaoCliente;
	}

	public int getAvaliacaoPrestador() {
		return this.avaliacaoPrestador;
	}

	public void setAvaliacaoPrestador(int avaliacaoPrestador) {
		this.avaliacaoPrestador = avaliacaoPrestador;
	}

	public byte getIndConfirmacaoValor() {
		return this.indConfirmacaoValor;
	}

	public void setIndConfirmacaoValor(byte indConfirmacaoValor) {
		this.indConfirmacaoValor = indConfirmacaoValor;
	}

	public BigDecimal getValorCliente() {
		return this.valorCliente;
	}

	public void setValorCliente(BigDecimal valorCliente) {
		this.valorCliente = valorCliente;
	}

	public BigDecimal getValorDevido() {
		return this.valorDevido;
	}

	public void setValorDevido(BigDecimal valorDevido) {
		this.valorDevido = valorDevido;
	}

	public BigDecimal getValorPrestador() {
		return this.valorPrestador;
	}

	public void setValorPrestador(BigDecimal valorPrestador) {
		this.valorPrestador = valorPrestador;
	}

	public List<Comentario> getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Comentario addComentario(Comentario comentario) {
		getComentarios().add(comentario);
		comentario.setServicoPrestado(this);

		return comentario;
	}

	public Comentario removeComentario(Comentario comentario) {
		getComentarios().remove(comentario);
		comentario.setServicoPrestado(null);

		return comentario;
	}

	public List<HistoricoPagamento> getHistoricoPagamentos() {
		return this.historicoPagamentos;
	}

	public void setHistoricoPagamentos(List<HistoricoPagamento> historicoPagamentos) {
		this.historicoPagamentos = historicoPagamentos;
	}

	public HistoricoPagamento addHistoricoPagamento(HistoricoPagamento historicoPagamento) {
		getHistoricoPagamentos().add(historicoPagamento);
		historicoPagamento.setServicoPrestado(this);

		return historicoPagamento;
	}

	public HistoricoPagamento removeHistoricoPagamento(HistoricoPagamento historicoPagamento) {
		getHistoricoPagamentos().remove(historicoPagamento);
		historicoPagamento.setServicoPrestado(null);

		return historicoPagamento;
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

	public Servico getServico() {
		return this.servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

}