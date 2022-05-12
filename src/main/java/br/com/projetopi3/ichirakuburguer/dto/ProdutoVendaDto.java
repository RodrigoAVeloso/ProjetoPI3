package br.com.projetopi3.ichirakuburguer.dto;

import java.util.List;

public class ProdutoVendaDto {
	
	private Integer codigo;
	private String nome;
	private String descricao;
	private float preco;
	
	private List<ProdutoEstoqueDto> produtoEstoqueDto;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public void setProdutoEstoque(ProdutoEstoqueDto produtoEstoque) {
		this.produtoEstoqueDto.add(produtoEstoque);
	}
	
	public List<ProdutoEstoqueDto> getProdutoEstoque(){
		return produtoEstoqueDto;
	}
	
	
}
