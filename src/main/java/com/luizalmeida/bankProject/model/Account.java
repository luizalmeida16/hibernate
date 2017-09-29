package com.luizalmeida.bankProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.gson.Gson;

@Entity
public class Account {
	
	@Id
	@GeneratedValue
	private Long id;
	private Integer number;
	private Double balance;
	
	public Long getId(){
		return this.id;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String toJson() {
		return new Gson().toJson(this);
	}
	
}
