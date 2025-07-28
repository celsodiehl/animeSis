package model;

import java.util.Date;
import java.util.Objects;
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
@Table(name = "cliente")
public class Cliente implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "empresa_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_empresa"))
    private Empresa empresa;

    @Column(length = 50)
    private String nome;

    @Column(length = 1)
    private String tipo;

    @Column(length = 20)
    private String telefone;

    @Column(length = 80)
    private String rua;

    @Column(length = 20)
    private String numero;

    @Column(length = 80)
    private String bairro;

    @Temporal(TemporalType.DATE)
    @Column(name = "datacadastro")
    private Date dataCadastro;

    //NOT NULL
    @Column(length = 80, nullable = false)
    private String cidade;

    @ManyToOne(optional = false)
    @JoinColumn(name = "estado", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_estado"))
    private Estado estado;

    public Cliente() {
        this.id = 0;
        this.nome = "";
        //para as cidades vim vazia
        //this.cidade = new ArrayList<Cidade>();
    }

    public Cliente(long id) {
        this.id = id;
        this.nome = "";
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    @Override
    public String toString() {
        return getNome();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Cliente) {
            Cliente c = (Cliente) o;
            if (c.getId() == this.getId()) {
                return true;
            }
        }
        return false;
    }

}
