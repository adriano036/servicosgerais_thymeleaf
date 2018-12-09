package servicosgerais.app.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pessoa database table.
 * 
 */
@Entity
@NamedQuery(name="Pessoa.findAll", query="SELECT p FROM Pessoa p")
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String email;

	private String nome;

	private String telefone1;

	private String telefone2;

	//bi-directional many-to-one association to Cliente
	@OneToMany(mappedBy="pessoa")
	private List<Cliente> clientes;

	//bi-directional many-to-one association to Empresa
	@OneToMany(mappedBy="pessoa")
	private List<Empresa> empresas;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	//bi-directional many-to-one association to Prestador
	@OneToMany(mappedBy="pessoa")
	private List<Prestador> prestadors;

	public Pessoa() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone1() {
		return this.telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return this.telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente addCliente(Cliente cliente) {
		getClientes().add(cliente);
		cliente.setPessoa(this);

		return cliente;
	}

	public Cliente removeCliente(Cliente cliente) {
		getClientes().remove(cliente);
		cliente.setPessoa(null);

		return cliente;
	}

	public List<Empresa> getEmpresas() {
		return this.empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	public Empresa addEmpresa(Empresa empresa) {
		getEmpresas().add(empresa);
		empresa.setPessoa(this);

		return empresa;
	}

	public Empresa removeEmpresa(Empresa empresa) {
		getEmpresas().remove(empresa);
		empresa.setPessoa(null);

		return empresa;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Prestador> getPrestadors() {
		return this.prestadors;
	}

	public void setPrestadors(List<Prestador> prestadors) {
		this.prestadors = prestadors;
	}

	public Prestador addPrestador(Prestador prestador) {
		getPrestadors().add(prestador);
		prestador.setPessoa(this);

		return prestador;
	}

	public Prestador removePrestador(Prestador prestador) {
		getPrestadors().remove(prestador);
		prestador.setPessoa(null);

		return prestador;
	}

}