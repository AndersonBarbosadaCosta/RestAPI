package com.truxton.RestAPI.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
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
		return "{id: "+ this.id+ "nome: "+ this.nome+ "qtde:"+ this.qtde + "data Created:"+ this.datecreated+"}";
	}
	

}
