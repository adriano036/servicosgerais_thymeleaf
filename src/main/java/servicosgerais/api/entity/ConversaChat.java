package servicosgerais.api.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the conversa_chat database table.
 * 
 */
@Entity
@Table(name="conversa_chat")
@NamedQuery(name="ConversaChat.findAll", query="SELECT c FROM ConversaChat c")
public class ConversaChat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Prestador
	@ManyToOne
	@JoinColumn(name="id_prestador")
	private Prestador prestador;

	//bi-directional many-to-one association to MensagemConversa
	@OneToMany(mappedBy="conversaChat")
	private List<MensagemConversa> mensagemConversas;

	public ConversaChat() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<MensagemConversa> getMensagemConversas() {
		return this.mensagemConversas;
	}

	public void setMensagemConversas(List<MensagemConversa> mensagemConversas) {
		this.mensagemConversas = mensagemConversas;
	}

	public MensagemConversa addMensagemConversa(MensagemConversa mensagemConversa) {
		getMensagemConversas().add(mensagemConversa);
		mensagemConversa.setConversaChat(this);

		return mensagemConversa;
	}

	public MensagemConversa removeMensagemConversa(MensagemConversa mensagemConversa) {
		getMensagemConversas().remove(mensagemConversa);
		mensagemConversa.setConversaChat(null);

		return mensagemConversa;
	}

}