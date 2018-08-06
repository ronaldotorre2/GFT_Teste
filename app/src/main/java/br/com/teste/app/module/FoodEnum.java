package br.com.teste.app.module;

public enum FoodEnum {
	ENTREE(1,"Entree"),
	SIDE(2,"Side"),
	DRINK(3,"Drink"),
	DESSERT(4,"Dessert");
	
	private Integer code;
	private String name;
	
	public Integer getCode() {
		return code;
	}
	
	public void setCode(Integer code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	private FoodEnum(Integer code,String name){
		this.code = code;
		this.name = name;
	}
	
	
}