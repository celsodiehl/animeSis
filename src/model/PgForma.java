package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Celso
 */
@Entity
@Table(name = "pgforma")
public class PgForma implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "condicao_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_condicao"))
    private PgCondicao condicao;
    
    @Column(length = 40)
    private String descricao;
    
    @Column(length = 2)
    private int qtdParcela;
    
    public PgForma() {
        this.id = 0;
        this.descricao = "";
    }

    public PgForma(long id) {
        this.id = id;
        this.descricao = "";
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PgCondicao getCondicao() {
        return condicao;
    }

    public void setCondicao(PgCondicao condicao) {
        this.condicao = condicao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtdParcela() {
        return qtdParcela;
    }

    public void setQtdParcela(int qtdParcela) {
        this.qtdParcela = qtdParcela;
    }
    
    @Override
    public String toString() {
        return getDescricao();
    }
    
    

}
