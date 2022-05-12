package br.com.projetopi3.ichirakuburguer.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_estoque")
public class ProdutoEstoqueEntity {

    @Id
    @Column(nullable = false)
    private Integer codigo;

    @Column(nullable = false)
    private String produtoNome;

    @Column(nullable = false)
    private int qtd;
    
    @Column(nullable = false)
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

	@Override
    public String toString() {
        return "ProdutoEntity{" +
                "codigo=" + codigo +
                ", produtoNome='" + produtoNome + '\'' +
                ", estoqueQtd=" + qtd +
                '}';
    }
}
