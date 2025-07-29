package model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Celso
 */
@Entity
@Table(name = "produto")
public class Produto implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "empresa_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_empresa"))
    private Empresa empresa;
    
    @Column(length = 80)
    private String descricao;
    private Double vlrcusto;
    
    @Column(precision = 10, scale = 2, nullable = true)
    private Double quantidade;
    
    @Column(precision = 10, scale = 2, nullable = true)
    private Double qtdultimacompra;

    @ManyToOne(optional = false)
    @JoinColumn(name = "marca_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_marca"))
    private Marca marca;

    @ManyToOne(optional = false)
    @JoinColumn(name = "unidade_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_unidade"))
    private Unidade unidade;

    private Double vlrvenda;
    
    @Column(length = 80)
    private String codigobarras;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "datacadastro")
    private Date dataCadastro;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "dataultimacompra")
    private Date dataultimaCompra;
    
    @Column(length = 1)
    private String servico;

    public Produto() {
        this.id = 0;
        this.descricao = "";
        this.vlrcusto = 0.0;
        this.vlrvenda = 0.0;
        this.quantidade = 0.0;
        this.qtdultimacompra = 0.0;
    }

    public Produto(Long id) {
        this.id = id;
        this.descricao = "";
        this.vlrcusto = 0.0;
        this.vlrvenda = 0.0;
        this.quantidade = 0.0;
        this.qtdultimacompra = 0.0;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getVlrcusto() {
        return vlrcusto;
    }

    public void setVlrcusto(Double vlrcusto) {
        this.vlrcusto = vlrcusto;
    }

    public Double getVlrvenda() {
        return vlrvenda;
    }

    public void setVlrvenda(Double vlrvenda) {
        this.vlrvenda = vlrvenda;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getQtdultimacompra() {
        return qtdultimacompra;
    }

    public void setQtdultimacompra(Double qtdultimacompra) {
        this.qtdultimacompra = qtdultimacompra;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public String getCodigobarras() {
        return codigobarras;
    }

    public void setCodigobarras(String codigobarras) {
        this.codigobarras = codigobarras;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
    public Date getDataultimaCompra() {
        return dataultimaCompra;
    }

    public void setDataultimaCompra(Date dataultimaCompra) {
        this.dataultimaCompra = dataultimaCompra;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }
    

    @Override
    public String toString() {
        return getDescricao();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Produto) {
            Produto p = (Produto) o;
            if (p.getId() == this.getId()) {
                return true;
            }
        }
        return false;
    }

}
