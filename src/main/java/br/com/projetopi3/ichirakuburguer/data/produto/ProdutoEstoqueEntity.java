package br.com.projetopi3.ichirakuburguer.data.produto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUTO_ESTOQUE")
public class ProdutoEstoqueEntity {

    @Id
    @Column(nullable = false)
    private Integer codigo;

    @Column(nullable = false)
    private String produtoNome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Long codigoBarras;

    @Column(nullable = false)
    private Float estoque;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(Long codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Float getEstoque() {
        return estoque;
    }

    public void setEstoque(Float estoque) {
        this.estoque = estoque;
    }


    @Override
    public String toString() {
        return "ProdutoEntity{" +
                "codigo=" + codigo +
                ", produtoNome='" + produtoNome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", codigoBarras=" + codigoBarras +
                ", estoque=" + estoque +
                '}';
    }
}
