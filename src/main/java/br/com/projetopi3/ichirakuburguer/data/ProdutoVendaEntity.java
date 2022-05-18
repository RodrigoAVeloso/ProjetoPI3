package br.com.projetopi3.ichirakuburguer.data;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_prod_venda")
public class ProdutoVendaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
    private String descricao;
	
	@Column(nullable = false)
	private float preco;

	@ManyToMany
	List <ProdutoEstoqueEntity> produtoEstoqueList;

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

	public void setProdutoEstoqueList(ProdutoEstoqueEntity produtoEstoqueEntity) {
		this.produtoEstoqueList.add(produtoEstoqueEntity);
	}
	
	public List<ProdutoEstoqueEntity> getProdutoEstoqueList(){
		return produtoEstoqueList;
	}

}
