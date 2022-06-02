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
	
	private List<ProdutoEstoqueDto> produtoEstoqueList;

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

	public void setProdutoEstoqueList(ProdutoEstoqueDto produtoEstoqueDto) {
		this.produtoEstoqueList.add(produtoEstoqueDto);
	}
	
	public List<ProdutoEstoqueDto> getProdutoEstoqueList(){
		return produtoEstoqueList;
	}
	
	public void fromProduto(ProdutoVendaDto produto) {
		this.descricao = produto.getDescricao();
		this.nome = produto.getNome();
		this.preco = produto.getPreco();
		
	}

	@Override
	public String toString() {
		return "Nome=" + nome + ", descricao=" + descricao + ", preco=" + preco
				+ ", produtoEstoqueDto=" + produtoEstoqueList + "]";
	}
	
	
}
