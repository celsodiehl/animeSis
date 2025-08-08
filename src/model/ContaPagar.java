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
 *
 * @author Celso
 */
@Entity
@Table(name = "contapagar")
public class ContaPagar implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "descricao")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "entrada_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_entrada"))
    private Entrada entrada;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "fornecedor_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_fornecedor"))
    private Fornecedor fornecedor;
    
    //@ManyToOne(optional = false)
    // @JoinColumn(name = "forma_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_forma"))
    //private PgForma Pgforma;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "datapagto")
    private Date dataPagamento;

    @Temporal(TemporalType.DATE)
    @Column(name = "datavencimento")
    private Date dataVencimento;

    @Column(name = "vlrtotal", precision = 10, scale = 2, nullable = false)
    private Double vlrTotal;

    @Column(name = "parcela")
    private int parcela;

    public ContaPagar() {
        this.id = 0;
        this.fornecedor = new Fornecedor();
    }

    public ContaPagar(long id) {
        this.id = id;
        this.fornecedor = new Fornecedor();
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Entrada getEntrada() {
        return entrada;
    }

    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Double getVlrTotal() {
        return vlrTotal;
    }

    public void setVlrTotal(Double vlrTotal) {
        this.vlrTotal = vlrTotal;
    }

    public int getParcela() {
        return parcela;
    }

    public void setParcela(int parcela) {
        this.parcela = parcela;
    }
    
    

}
