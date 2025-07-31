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
 * @author Celso
 */
@Entity
@Table(name = "venda")
public class Venda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "empresa_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_empresa"))
    private Empresa empresa;

    @Temporal(TemporalType.DATE)
    @Column(name = "datavenda", nullable = false)
    private Date datavenda;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_cliente"))
    private Cliente cliente;

    @Column(name = "vlrsubtotal", precision = 10, scale = 2, nullable = false)
    private Double vlrsubtotal;

    //PORCENTAGEM DE DESCONTO
    @Column(name = "desconto")
    private int desconto;

    //VALOR DO DESCONTO
    @Column(name = "vlrdesconto", precision = 10, scale = 2)
    private Double vlrdesconto;

    @Column(name = "vlrtotal", precision = 10, scale = 2, nullable = false)
    private Double vlrtotal;

    @Enumerated(EnumType.ORDINAL)
    private Situacao situacao;

    @ManyToOne
    @JoinColumn(name = "pgforma_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_pgforma"))
    private PgForma forma;

    //SEMPRE QUE FOR LISTA TREM QUE SER LAZY, LAZY é PREGUIÇOSO, não TRAZ OS ITENS
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "venda")
    private List<VendaItem> itens;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "venda")
    private List<VendaReceber> parcelas;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "venda")
    private List<Conciliacao> conciliacao;

    public Venda() {
        this.id = 0;
        this.cliente = new Cliente();
        this.empresa = new Empresa();
        this.datavenda = new Date();
        this.vlrsubtotal = 0.0;
        this.itens = new ArrayList<>();
        this.parcelas = new ArrayList<>();
        this.conciliacao = new ArrayList<>();
        // this.itensRemover = new ArrayList<>();
    }

    public Venda(long id) {
        this.id = id;
        this.cliente = new Cliente();
        this.empresa = new Empresa();
        this.datavenda = new Date();
        this.vlrsubtotal = 0.0;
        this.itens = new ArrayList<>();
        this.parcelas = new ArrayList<>();
        this.conciliacao = new ArrayList<>();
        // this.itensRemover = new ArrayList<>();

    }

    //CONSTRUI PRA USAR NO BUSCA PRODUTO
    public Venda(long id, Cliente cliente, Date datavenda, Double vlrtotal, Situacao situacao) {
        this.id = id;
        this.cliente = cliente;
        this.datavenda = datavenda;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDatavenda() {
        return datavenda;
    }

    public void setDatavenda(Date datavenda) {
        this.datavenda = datavenda;
    }

    public Double getVlrsubtotal() {
        double stotal = 0.0;
        for (VendaItem iv : itens) {
            stotal += (iv.getQuantidade() * iv.getVlr_unitario());
        }
        return stotal;
    }

    public void setVlrsubtotal(Double vlrsubtotal) {
        this.vlrsubtotal = vlrsubtotal;
    }

    public int getDesconto() {
        return desconto;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }
    
    //SÓ PRA BUSCAR O TOTAL
    public Double getVlrtotal() {
        return vlrtotal;
    }
    
    public Double getCalcVlrTotal() {
        double total = 0.0;
        double vlrdesconto = 0.0;

        vlrdesconto = ((getVlrsubtotal() * getDesconto()) / 100);
        total = (getVlrsubtotal() - vlrdesconto);
        return total;
    }

    public void setVlrtotal(Double vlrtotal) {
        this.vlrtotal = vlrtotal;
    }

    public Double getVlrdesconto() {
        double vlrdesconto = 0;

        vlrdesconto = (getVlrsubtotal() - getCalcVlrTotal());
        return vlrdesconto;
    }

    public void setVlrdesconto(Double vlrdesconto) {
        this.vlrdesconto = vlrdesconto;
    }

    public PgForma getForma() {
        return forma;
    }

    public void setForma(PgForma forma) {
        this.forma = forma;
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

    public List<VendaItem> getItens() {
        return itens;
    }

    public void setItens(List<VendaItem> itens) {
        this.itens = itens;
    }

    public List<VendaReceber> getParcelas() {
        return parcelas;
    }

    public void setParcelas(List<VendaReceber> parcelas) {
        this.parcelas = parcelas;
    }

    public List<Conciliacao> getConciliacao() {
        return conciliacao;
    }

    public void setConciliacao(List<Conciliacao> conciliacao) {
        this.conciliacao = conciliacao;
    }
    
    public void addItem(VendaItem item) {
        itens.add(item);
    }

    public int quantidadeItens() {
        return itens.size();
    }
    

}