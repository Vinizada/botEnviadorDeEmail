package entidade;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Email {
	
	public Email() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Email(String parametro) {
		super();
		this.id = 1L;
		this.dataInclusao = new Date();
		this.modeloId = 1L;
		this.contaId = 1L;
		this.variaveis = "[NOME]#TESTE;[PROJETO]#PROJETO TESTE";
		this.emails = "luiz#luiz.neto@diferpan.com.br;vinicius#vinicius.lima@diferpan.com.br";
		this.dataEnvio = new Date();
	}
	
	@Id
	private Long id;
	private Date dataInclusao;
	private Long modeloId;
	private Long contaId;
	private String variaveis;
	private String emails;
	private Date dataEnvio;
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDataInclusao() {
		return dataInclusao;
	}
	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	public Long getModeloId() {
		return modeloId;
	}
	public void setModeloId(Long modeloId) {
		this.modeloId = modeloId;
	}
	public Long getContaId() {
		return contaId;
	}
	public void setContaId(Long contaId) {
		this.contaId = contaId;
	}
	public String getVariaveis() {
		return variaveis;
	}
	public void setVariaveis(String variaveis) {
		this.variaveis = variaveis;
	}
	public String getEmails() {
		return emails;
	}
	public void setEmails(String emails) {
		this.emails = emails;
	}
	public Date getDataEnvio() {
		return dataEnvio;
	}
	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
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
		Email other = (Email) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
