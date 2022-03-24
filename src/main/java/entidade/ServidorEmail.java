package entidade;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ServidorEmail {

	public ServidorEmail() {

	}

	public ServidorEmail(String parametro) {

		this.id = 1L;
		this.descricao = "Exchange";
		this.hostname = "diferpan-com-br.mail.protection.outlook.com";
		this.porta = 25L;
		this.SSL = "N";
		this.TLS = "N";

	}
	
	@Id
	private Long id;

	private String descricao;

	private String hostname;

	private Long porta;

	private String SSL;

	private String TLS;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public Long getPorta() {
		return porta;
	}

	public void setPorta(Long porta) {
		this.porta = porta;
	}

	public String getSSL() {
		return SSL;
	}

	public void setSSL(String sSL) {
		SSL = sSL;
	}

	public String getTLS() {
		return TLS;
	}

	public void setTLS(String tLS) {
		TLS = tLS;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServidorEmail other = (ServidorEmail) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
