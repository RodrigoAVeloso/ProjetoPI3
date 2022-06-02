package br.com.projetopi3.ichirakuburguer.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class ProdutoEstoqueDto {
	
	@NotNull
    private Integer codigo;
    
    @NotBlank
    private String produtoNome;
    
    @NotNull
    @Min(1)
    private int qtd;
    
    @NotNull
    @DecimalMin ("0.50")
    private double preco;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getProdutoNome() {
		return produtoNome;
	}

	public void setProdutoNome(String produtoNome) {
		this.produtoNome = produtoNome;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	public void fromEstoque(ProdutoEstoqueDto produto) {
		this.produtoNome = produto.getProdutoNome();
		this.qtd = produto.getQtd();
		this.preco = produto.getPreco();
	}

	@Override
	public String toString() {
		return "ProdutoEstoqueDto [codigo=" + codigo + ", produtoNome=" + produtoNome + ", qtd=" + qtd + ", preco="
				+ preco + "]";
	}

}
