package servicosgerais.api.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the prestador database table.
 * 
 */
@Entity
@NamedQuery(name="Prestador.findAll", query="SELECT p FROM Prestador p")
public class Prestador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="nr_pontuacao")
	private int nrPontuacao;

	@Column(name="raio_interesse")
	private int raioInteresse;

	//bi-directional many-to-one association to ConversaChat
	@OneToMany(mappedBy="prestador")
	private List<ConversaChat> conversaChats;

	//bi-directional many-to-one association to Denuncia
	@OneToMany(mappedBy="prestador")
	private List<Denuncia> denuncias;

	//bi-directional many-to-one association to Endereco
	@OneToMany(mappedBy="prestador")
	private List<Endereco> enderecos;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="id_empresa")
	private Empresa empresa;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne
	@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;

	//bi-directional many-to-one association to ServicoPrestado
	@OneToMany(mappedBy="prestador")
	private List<ServicoPrestado> servicoPrestados;

	//bi-directional many-to-one association to ServicoPrestador
	@OneToMany(mappedBy="prestador")
	private List<ServicoPrestador> servicoPrestadors;

	//bi-directional many-to-one association to ServicoSistemaPrestado
	@OneToMany(mappedBy="prestador")
	private List<ServicoSistemaPrestado> servicoSistemaPrestados;

	public Prestador() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNrPontuacao() {
		return this.nrPontuacao;
	}

	public void setNrPontuacao(int nrPontuacao) {
		this.nrPontuacao = nrPontuacao;
	}

	public int getRaioInteresse() {
		return this.raioInteresse;
	}

	public void setRaioInteresse(int raioInteresse) {
		this.raioInteresse = raioInteresse;
	}

	public List<ConversaChat> getConversaChats() {
		return this.conversaChats;
	}

	public void setConversaChats(List<ConversaChat> conversaChats) {
		this.conversaChats = conversaChats;
	}

	public ConversaChat addConversaChat(ConversaChat conversaChat) {
		getConversaChats().add(conversaChat);
		conversaChat.setPrestador(this);

		return conversaChat;
	}

	public ConversaChat removeConversaChat(ConversaChat conversaChat) {
		getConversaChats().remove(conversaChat);
		conversaChat.setPrestador(null);

		return conversaChat;
	}

	public List<Denuncia> getDenuncias() {
		return this.denuncias;
	}

	public void setDenuncias(List<Denuncia> denuncias) {
		this.denuncias = denuncias;
	}

	public Denuncia addDenuncia(Denuncia denuncia) {
		getDenuncias().add(denuncia);
		denuncia.setPrestador(this);

		return denuncia;
	}

	public Denuncia removeDenuncia(Denuncia denuncia) {
		getDenuncias().remove(denuncia);
		denuncia.setPrestador(null);

		return denuncia;
	}

	public List<Endereco> getEnderecos() {
		return this.enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Endereco addEndereco(Endereco endereco) {
		getEnderecos().add(endereco);
		endereco.setPrestador(this);

		return endereco;
	}

	public Endereco removeEndereco(Endereco endereco) {
		getEnderecos().remove(endereco);
		endereco.setPrestador(null);

		return endereco;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<ServicoPrestado> getServicoPrestados() {
		return this.servicoPrestados;
	}

	public void setServicoPrestados(List<ServicoPrestado> servicoPrestados) {
		this.servicoPrestados = servicoPrestados;
	}

	public ServicoPrestado addServicoPrestado(ServicoPrestado servicoPrestado) {
		getServicoPrestados().add(servicoPrestado);
		servicoPrestado.setPrestador(this);

		return servicoPrestado;
	}

	public ServicoPrestado removeServicoPrestado(ServicoPrestado servicoPrestado) {
		getServicoPrestados().remove(servicoPrestado);
		servicoPrestado.setPrestador(null);

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
		servicoPrestador.setPrestador(this);

		return servicoPrestador;
	}

	public ServicoPrestador removeServicoPrestador(ServicoPrestador servicoPrestador) {
		getServicoPrestadors().remove(servicoPrestador);
		servicoPrestador.setPrestador(null);

		return servicoPrestador;
	}

	public List<ServicoSistemaPrestado> getServicoSistemaPrestados() {
		return this.servicoSistemaPrestados;
	}

	public void setServicoSistemaPrestados(List<ServicoSistemaPrestado> servicoSistemaPrestados) {
		this.servicoSistemaPrestados = servicoSistemaPrestados;
	}

	public ServicoSistemaPrestado addServicoSistemaPrestado(ServicoSistemaPrestado servicoSistemaPrestado) {
		getServicoSistemaPrestados().add(servicoSistemaPrestado);
		servicoSistemaPrestado.setPrestador(this);

		return servicoSistemaPrestado;
	}

	public ServicoSistemaPrestado removeServicoSistemaPrestado(ServicoSistemaPrestado servicoSistemaPrestado) {
		getServicoSistemaPrestados().remove(servicoSistemaPrestado);
		servicoSistemaPrestado.setPrestador(null);

		return servicoSistemaPrestado;
	}

}