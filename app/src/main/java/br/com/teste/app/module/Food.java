package br.com.teste.app.module;

import java.io.Serializable;

public class Food implements Serializable {
	
	private static final long serialVersionUID = 2278625260594689981L;
	
	private int id;
	private int code;
	private FoodEnum type;
	private String name;
	private String period;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public FoodEnum getType() {
		return type;
	}
	
	public void setType(FoodEnum type) {
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPeriod() {
		return period;
	}
	
	public void setPeriod(String period) {
		this.period = period;
	}

	public Food(){ }

	public Food(int id, int code, FoodEnum type, String name, String period) {
		this.id = id;
		this.code = code;
		this.type = type;
		this.name = name;
		this.period = period;
	}

	@Override
	public String toString() {
		return "Food [id=" + id + ", code=" + code + ", type=" + type + ", name=" + name + ", period=" + period + "]";
	}
	
}