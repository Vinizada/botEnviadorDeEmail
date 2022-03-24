package entidade;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ContaEmail {
	
	
	
	
	public ContaEmail() {
		super();

	}
	
	
	

	public ContaEmail(String parametro) {
		super();
		this.id = 1L;
		this.email = "luiz.neto@diferpan.com.br";
		this.senha = "lrn2027@";
		this.nome = "Escrit�rio de Projetos";
		this.servidorId = 1L;
	}



	@Id
	private Long id;


    private String email;
    

    private String senha;
    

    private String nome;
    
    private Long servidorId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getServidorId() {
		return servidorId;
	}

	public void setServidorId(Long servidorId) {
		this.servidorId = servidorId;
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
		ContaEmail other = (ContaEmail) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
    
    
	

}
