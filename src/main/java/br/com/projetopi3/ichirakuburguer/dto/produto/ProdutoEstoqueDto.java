package br.com.projetopi3.ichirakuburguer.dto.produto;

import org.springframework.stereotype.Component;

@Component
public class ProdutoEstoqueDto {

    private Integer codigo;

    private String produtoNome;

    private String descricao;

    private Long codigoBarras;

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
        return "ProdutoDto{" +
                "codigo=" + codigo +
                ", produtoNome='" + produtoNome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", codigoBarras=" + codigoBarras +
                ", estoque=" + estoque +
                '}';
    }
}
