package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import model.enuns.Situacao;

/**
 *
 * @author Celso
 */
@Entity
@Table(name = "entrada")
public class Entrada implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "empresa_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_empresa"))
    private Empresa empresa;

    @Temporal(TemporalType.DATE)
    @Column(name = "dataentrada", nullable = false)
    private Date dataentrada;

    @Temporal(TemporalType.DATE)
    @Column(name = "dataemissao", nullable = false)
    private Date dataemissao;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fornecedor_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_fornecedor"))
    private Fornecedor fornecedor;

    @Column(name = "numero")
    private int numero;

    @Column(name = "serie", length = 10)
    private String serie;

    //PORCENTAGEM DE DESCONTO//
    @Column(name = "desconto")
    private int desconto;

    @Column(name = "vlrtotal", precision = 10, scale = 2, nullable = false)
    private Double vlrtotal;

    @Column(name = "vlrfrete", precision = 10, scale = 2, nullable = true)
    private Double vlrfrete;

    @Enumerated(EnumType.ORDINAL)
    private Situacao situacao;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "entrada")
    private List<EntradaItem> itens;

    public Entrada() {
        this.id = 0;
        this.fornecedor = new Fornecedor();
        this.dataentrada = new Date();
        this.vlrtotal = 0.0;
        this.vlrfrete = 0.0;
        this.itens = new ArrayList<>();
        // this.itensRemover = new ArrayList<>();
    }

    public Entrada(long id) {
        this.id = id;
        this.fornecedor = new Fornecedor();
        this.dataentrada = new Date();
        this.vlrtotal = 0.0;
        this.vlrfrete = 0.0;
        this.itens = new ArrayList<>();
    }
    
      //CONSTRUI PRA USAR NO BUSCA PRODUTO
    public Entrada(long id, Fornecedor fornecedor, Date dataentrada, Double vlrtotal, Situacao situacao) {
        this.id = id;
        this.fornecedor = fornecedor;
        this.dataentrada = dataentrada;
        this.vlrtotal = vlrtotal;
        this.situacao = situacao;
    }

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

    public Date getDataentrada() {
        return dataentrada;
    }

    public void setDataentrada(Date dataentrada) {
        this.dataentrada = dataentrada;
    }

    public Date getDataemissao() {
        return dataemissao;
    }

    public void setDataemissao(Date dataemissao) {
        this.dataemissao = dataemissao;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getDesconto() {
        return desconto;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }

    public Double getVlrSubTotal() {
        double total = 0.0;
        for (EntradaItem iv : itens) {
            total += (iv.getQuantidade() * iv.getVlrunitario());
        }
        return total;
    }

    public Double getVlrfrete() {
        return vlrfrete;
    }

    public void setVlrfrete(Double vlrfrete) {
        this.vlrfrete = vlrfrete;
    }

    public Double getVlrTotal() {
        double total = 0.0;
        total = getVlrSubTotal() + getVlrfrete();
        return total;
    }

    public void setVlrtotal(Double vlrtotal) {
        this.vlrtotal = vlrtotal;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public void setSituacao(int situacao) {
        if (situacao == Situacao.ABERTA.getId()) {
            setSituacao(Situacao.ABERTA);
        } else if (situacao == Situacao.FINALIZADA.getId()) {
            setSituacao(Situacao.FINALIZADA);
        } else if (situacao == Situacao.CANCELADA.getId()) {
            setSituacao(Situacao.CANCELADA);
        }
    }

    public List<EntradaItem> getItens() {
        return itens;
    }

    public void setItens(List<EntradaItem> itens) {
        this.itens = itens;
    }

    public void addItem(EntradaItem item) {
        itens.add(item);
    }

    public int quantidadeItens() {
        return itens.size();
    }

}
