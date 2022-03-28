package pear.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="enderecos")
public class Endereco {
	
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id; 
	private String tipoEndereco;
	private String CEP;
	private String rua;
	private Integer numero;
	private String cidade;
	private String estado;
	private String bairro;
	
	public Endereco() {
	}
	
	public Endereco(String paramRua, Integer numero, String paramCidade, String paramEstado, String paramCEP, String paramBairro) {
		this.rua = paramRua;
		this.numero = numero;
		this.cidade = paramCidade;
		this.estado = paramEstado;
		this.CEP = paramCEP;
		this.setBairro(paramBairro);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoEndereco() {
		return tipoEndereco;
	}

	public void setTipoEndereco(String tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}

	public String getCEP() {
		return CEP;
	}
	public void setCEP(String cEP) {
		CEP = cEP;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
}
