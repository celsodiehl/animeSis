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
@Table(name = "pgcondicao")
public class PgCondicao implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "empresa_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_empresa"))
    private Empresa empresa;

    @Column(length = 40)
    private String descricao;

    @Column(length = 2)
    private String tipo;

    public PgCondicao() {
        this.id = 0;
        this.descricao = "";
    }

    public PgCondicao(long id) {
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public String toString() {
        return getDescricao();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }
    
       @Override
    public boolean equals(Object o) {
        if (o instanceof PgCondicao) {
            PgCondicao c = (PgCondicao) o;
            if (c.getId() == this.getId()) {
                return true;
            }
        }
        return false;
    }

}
