package servicosgerais.api.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the mensagem_conversa database table.
 * 
 */
@Entity
@Table(name="mensagem_conversa")
@NamedQuery(name="MensagemConversa.findAll", query="SELECT m FROM MensagemConversa m")
public class MensagemConversa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	@Column(name="ind_cliente")
	private byte indCliente;

	@Column(name="ind_prestador")
	private byte indPrestador;

	private String texto;

	//bi-directional many-to-one association to ConversaChat
	@ManyToOne
	@JoinColumn(name="id_conversa")
	private ConversaChat conversaChat;

	public MensagemConversa() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public byte getIndCliente() {
		return this.indCliente;
	}

	public void setIndCliente(byte indCliente) {
		this.indCliente = indCliente;
	}

	public byte getIndPrestador() {
		return this.indPrestador;
	}

	public void setIndPrestador(byte indPrestador) {
		this.indPrestador = indPrestador;
	}

	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public ConversaChat getConversaChat() {
		return this.conversaChat;
	}

	public void setConversaChat(ConversaChat conversaChat) {
		this.conversaChat = conversaChat;
	}

}