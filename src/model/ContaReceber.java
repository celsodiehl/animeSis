/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
@Table(name = "conta_receber")
public class ContaReceber implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_empresa"))
    private Empresa empresa;

    @Column(name = "descricao")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "venda_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_venda"))
    private Venda venda;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_cliente"))
    private Cliente cliente;

    @ManyToOne(optional = false)
    @JoinColumn(name = "forma_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_forma"))
    private PgForma Pgforma;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "data_vencimento")
    private Date data_vencimento;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_pagamento")
    private Date data_pagamento;


    @Column(name = "vlr_total", precision = 10, scale = 2, nullable = false)
    private Double vlr_total;

    @Column(name = "parcela")
    private int parcela;

    public ContaReceber() {
        this.id = 0;
        this.venda = new Venda();
        this.data_vencimento = new Date();
        this.data_pagamento = new Date();
        this.parcela = 0;
        this.vlr_total = 0.0;
    }

    public ContaReceber(long id) {
        this.id = id;
        this.venda = new Venda();
        this.data_vencimento = new Date();
        this.data_pagamento = new Date();
        this.parcela = 0;
        this.vlr_total = 0.0;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public PgForma getPgforma() {
        return Pgforma;
    }

    public void setPgforma(PgForma Pgforma) {
        this.Pgforma = Pgforma;
    }

    public Date getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(Date data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    public Date getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(Date data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public Double getVlr_total() {
        return vlr_total;
    }

    public void setVlr_total(Double vlr_total) {
        this.vlr_total = vlr_total;
    }

    public int getParcela() {
        return parcela;
    }

    public void setParcela(int parcela) {
        this.parcela = parcela;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ContaReceber) {
            ContaReceber p = (ContaReceber) o;
            if (p.getId() == this.getId()) {
                return true;
            }
        }
        return false;
    }

}
