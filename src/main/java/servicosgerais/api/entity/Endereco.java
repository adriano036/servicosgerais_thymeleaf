package servicosgerais.api.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the endereco database table.
 * 
 */
@Entity
@NamedQuery(name="Endereco.findAll", query="SELECT e FROM Endereco e")
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String cep;

	private String cidade;

	private String complemento;

	private String estado;

	@Column(name="id_pessoa")
	private int idPessoa;

	//private Object latitude;

	private String logradouro;

	//private Object longitude;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Prestador
	@ManyToOne
	@JoinColumn(name="id_prestador")
	private Prestador prestador;

	public Endereco() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getIdPessoa() {
		return this.idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

//	public Object getLatitude() {
//		return this.latitude;
//	}
//
//	public void setLatitude(Object latitude) {
//		this.latitude = latitude;
//	}

	public String getLogradouro() {
		return this.logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

//	public Object getLongitude() {
//		return this.longitude;
//	}
//
//	public void setLongitude(Object longitude) {
//		this.longitude = longitude;
//	}

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