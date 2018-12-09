package servicosgerais.app.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="nr_pontuacao")
	private int nrPontuacao;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne
	@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;

	//bi-directional many-to-one association to ConversaChat
	@OneToMany(mappedBy="cliente")
	private List<ConversaChat> conversaChats;

	//bi-directional many-to-one association to Denuncia
	@OneToMany(mappedBy="cliente")
	private List<Denuncia> denuncias;

	//bi-directional many-to-one association to Endereco
	@OneToMany(mappedBy="cliente")
	private List<Endereco> enderecos;

	//bi-directional many-to-one association to ServicoPrestado
	@OneToMany(mappedBy="cliente")
	private List<ServicoPrestado> servicoPrestados;

	public Cliente() {
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

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<ConversaChat> getConversaChats() {
		return this.conversaChats;
	}

	public void setConversaChats(List<ConversaChat> conversaChats) {
		this.conversaChats = conversaChats;
	}

	public ConversaChat addConversaChat(ConversaChat conversaChat) {
		getConversaChats().add(conversaChat);
		conversaChat.setCliente(this);

		return conversaChat;
	}

	public ConversaChat removeConversaChat(ConversaChat conversaChat) {
		getConversaChats().remove(conversaChat);
		conversaChat.setCliente(null);

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
		denuncia.setCliente(this);

		return denuncia;
	}

	public Denuncia removeDenuncia(Denuncia denuncia) {
		getDenuncias().remove(denuncia);
		denuncia.setCliente(null);

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
		endereco.setCliente(this);

		return endereco;
	}

	public Endereco removeEndereco(Endereco endereco) {
		getEnderecos().remove(endereco);
		endereco.setCliente(null);

		return endereco;
	}

	public List<ServicoPrestado> getServicoPrestados() {
		return this.servicoPrestados;
	}

	public void setServicoPrestados(List<ServicoPrestado> servicoPrestados) {
		this.servicoPrestados = servicoPrestados;
	}

	public ServicoPrestado addServicoPrestado(ServicoPrestado servicoPrestado) {
		getServicoPrestados().add(servicoPrestado);
		servicoPrestado.setCliente(this);

		return servicoPrestado;
	}

	public ServicoPrestado removeServicoPrestado(ServicoPrestado servicoPrestado) {
		getServicoPrestados().remove(servicoPrestado);
		servicoPrestado.setCliente(null);

		return servicoPrestado;
	}

}