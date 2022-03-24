package entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_EMAIL")
@SequenceGenerator(name = "EMAILS_SEQ", sequenceName = "SEQ_EMAILS", initialValue = 1, allocationSize = 1)
public class EnviaEmail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMAILS_SEQ")
	private Long id;

	@Column(name = "DTHRINCLUSAO")
	private Date dataHoraInclusao;

	@Column(name = "MODELO_ID")
	private Long modeloId;

	@Column(name = "CONTA_ID")
	private Long contaId;

	@Column(name = "VARIAVEIS")
	private String variaveis;

	@Column(name = "EMAILS")
	private String emails;

	@Column(name = "DTHRENVIO")
	private Date dataHoraEnvio;

	public EnviaEmail() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataHoraInclusao() {
		return dataHoraInclusao;
	}

	public void setDataHoraInclusao(Date dataHoraInclusao) {
		this.dataHoraInclusao = dataHoraInclusao;
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

	public Date getDataHoraEnvio() {
		return dataHoraEnvio;
	}

	public void setDataHoraEnvio(Date dataHoraEnvio) {
		this.dataHoraEnvio = dataHoraEnvio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnviaEmail other = (EnviaEmail) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "EnviaEmail [id=" + id + ", dataHoraInclusao=" + dataHoraInclusao + ", modeloId=" + modeloId
				+ ", contaId=" + contaId + ", variaveis=" + variaveis + ", emails=" + emails + ", dataHoraEnvio="
				+ dataHoraEnvio + "]";
	}

}
