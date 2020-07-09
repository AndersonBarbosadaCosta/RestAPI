package br.com.anderson.RestAPI.models;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Can not be empty")
    @NotBlank(message = "Can not be blank")
    @Size(min = 4, max = 255)
    private String nome;

    private Integer qtde;

    private Date datecreated;


    public Product() {

    }

    public Product(Long id, String nome, Integer qtde) {
        super();
        this.id = id;
        this.nome = nome;
        this.qtde = qtde;
    }

    // metodo utilizado antes da persistencia para atribuir a data automaticamente
    @PrePersist
    public void onPrePersist() {
        if (this.datecreated == null) {
            this.datecreated = new Date();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtde() {
        return qtde;
    }

    public void setQtde(Integer qtde) {
        this.qtde = qtde;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }


    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "{id: " + this.id + "nome: " + this.nome + "qtde:" + this.qtde + "data Created:" + this.datecreated + "}";
    }


}
