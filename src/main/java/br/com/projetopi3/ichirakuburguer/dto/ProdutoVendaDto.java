package br.com.projetopi3.ichirakuburguer.dto;

import java.util.List;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProdutoVendaDto {
	
	private Integer codigo;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String descricao;
	
	@NotNull
	@DecimalMin ("1.00")
	private float preco;
	
	@NotNull
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

	@Override
	public String toString() {
		return "ProdutoVendaDto [codigo=" + codigo + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco
				+ ", produtoEstoqueDto=" + produtoEstoqueDto + "]";
	}
	
	
}
