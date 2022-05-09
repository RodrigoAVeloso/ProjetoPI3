package br.com.projetopi3.ichirakuburguer.dto.produtoVenda;

import br.com.projetopi3.ichirakuburguer.dto.produto.ProdutoEstoqueDto;

public class ProdutoVendaDto {
	
	private Integer id;
	private Integer quantidade;
	private float preco;
	
	private ProdutoEstoqueDto produtoEstoqueDto;

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

	public ProdutoEstoqueDto getProdutoEstoqueDto() {
		return produtoEstoqueDto;
	}

	public void setProdutoEstoqueDto(ProdutoEstoqueDto produtoEstoqueDto) {
		this.produtoEstoqueDto = produtoEstoqueDto;
	}
	
	
}
