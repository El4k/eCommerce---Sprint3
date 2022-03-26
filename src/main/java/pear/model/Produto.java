package pear.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="produtos")
public class Produto {
	
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String nomeProduto;
	private String descricao;
	private Double valorProduto;
	private String imagem;
	private Long quantidadeEstoque;
	
	public Produto() {
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValorProduto() {
		return valorProduto;
	}
	public void setValorProduto(Double valorProduto) {
		this.valorProduto = valorProduto;
	}
	
	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	public Long getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Long quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public String criaLink () {
		return "/ecommerce/pear?acao=RemoveProduto&produto=";
	}
	
//	@Override
//	public String toString() {
//		return "<div><b>Produto:</b> " + nomeProduto + " " + descricao + "<br>"
//		+ "<b>Valor: R$</b> "+ valorProduto + "</div><br>"
//		+ "<div><img src= "+imagem+" width=200 height=100></div><br>"
//				+ "<a href="+criaLink()+id+"><input type=submit value=Remover_Produto></a><hr>";
//	}
}
