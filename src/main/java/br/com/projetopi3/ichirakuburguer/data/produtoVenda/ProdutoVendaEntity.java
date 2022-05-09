package br.com.projetopi3.ichirakuburguer.data.produtoVenda;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.projetopi3.ichirakuburguer.data.produto.ProdutoEstoqueEntity;

@Entity
public class ProdutoVendaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private Integer quantidade;
	@Column(nullable = false)
	private float preco;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "produto_id", referencedColumnName = "id")
	ProdutoEstoqueEntity produtoEstoque;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public ProdutoEstoqueEntity getProdutoEstoque() {
		return produtoEstoque;
	}

	public void setProdutoEstoque(ProdutoEstoqueEntity produtoEstoque) {
		this.produtoEstoque = produtoEstoque;
	}
	
	
}
