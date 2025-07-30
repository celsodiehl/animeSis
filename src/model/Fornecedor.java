package model;

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

/**
 *
 * @author Celso
 */
@Entity
@Table(name = "fornecedor")
public class Fornecedor implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "empresa_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_empresa"))
    private Empresa empresa;

    @Column(length = 80)
    private String nome;

    @Column(length = 1)
    private String tipo;

    @Column(length = 20)
    private String telefone;

    @Column(length = 40)
    private String endereco;

    @Column(length = 40)
    private String bairro;

    //NOT NULL
    @Column(length = 80, nullable = false)
    private String cidade;

    @ManyToOne(optional = false)
    @JoinColumn(name = "estado", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_estado"))
    private Estado estado;

    @Column(length = 40)
    private String email;

    @Column(length = 40)
    private String site;

    @Column(length = 40)
    private String contato;

    @Column(length = 40)
    private String contatotelefone;

    public Fornecedor() {
        this.id = 0;
        this.nome = "";

    }

    public Fornecedor(long id) {
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getContatotelefone() {
        return contatotelefone;
    }

    public void setContatotelefone(String contatotelefone) {
        this.contatotelefone = contatotelefone;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public String toString() {
        return getNome();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Cliente) {
            Fornecedor c = (Fornecedor) o;
            if (c.getId() == this.getId()) {
                return true;
            }
        }
        return false;
    }

}
