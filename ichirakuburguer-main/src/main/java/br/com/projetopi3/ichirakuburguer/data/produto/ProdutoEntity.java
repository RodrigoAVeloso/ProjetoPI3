package br.com.projetopi3.ichirakuburguer.data.produto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "PRODUTO")
public class ProdutoEntity {

    @Id
    @Column
    private Integer codigo;

    @Column
    private String produtoNome;

    @Column
    private String descricao;

    @Column
    private Long codigoBarras;

    @Column
    private Float estoque;

    @Column
    private Boolean ativo;

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

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "ProdutoEntity{" +
                "codigo=" + codigo +
                ", produtoNome='" + produtoNome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", codigoBarras=" + codigoBarras +
                ", estoque=" + estoque +
                ", ativo=" + ativo +
                '}';
    }
}
