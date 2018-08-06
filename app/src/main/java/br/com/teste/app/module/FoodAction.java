package br.com.teste.app.module;

import java.util.ArrayList;
import java.util.List;

public class FoodAction {

	private List<Food>Foods = new ArrayList<>();

	public List<Food> getFoods() {
		return Foods;
	}

	public void setFoods(List<Food> foods) {
		Foods = foods;
	}
	
	public FoodAction(){
		Foods.add(new Food(1,1, FoodEnum.ENTREE, "Eggs", "Morning"));
		Foods.add(new Food(2,2, FoodEnum.SIDE, "Toast", "Morning"));
		Foods.add(new Food(3,3, FoodEnum.DRINK, "Coffee", "Morning"));
		Foods.add(new Food(4,1, FoodEnum.ENTREE, "Steak", "Night"));
		Foods.add(new Food(5,2, FoodEnum.SIDE, "Potato", "Night"));
		Foods.add(new Food(6,3, FoodEnum.DRINK, "Wine", "Night"));
		Foods.add(new Food(7,4, FoodEnum.DESSERT, "Cake", "Night"));
	}
	
	private String identifyPeriod(String time){
		String process = null;
		
		try{
			if(!time.isEmpty() && time != null && (time.length() == 4 || time.length() == 5)){
				String[] aux = time.split(":");
				
				if(Integer.valueOf(aux[0]) > 18 && Integer.valueOf(aux[0]) <= 23){
					process = "Night";
				}
				else{
					process = "Morning";
				}
			}
		}
		catch (Exception e) {
			System.out.println("Error occurred! "+e.getMessage());
			return "Error";
		}
		
		return process;
	}
	
	private String getByParameter(int code, String period){
		String process = null;
		
		try{
			if((!String.valueOf(code).isEmpty() && String.valueOf(code)!= null)
			    &&(!period.isEmpty() && period != null)){
					for(int i=0; i<= Foods.size()-1; i++){
						if((Foods.get(i).getCode() == code)&&(Foods.get(i).getPeriod() == period)){
							process=  Foods.get(i).getName();
							break;
						}
						else if((Foods.get(i).getCode() == 4)&&(period == "Morning")){
							process = "error";
							break;
						}
					}
			}
		}
		catch (Exception e) {
			System.out.println("Error occurred! "+e.getMessage());
		}
		
		return process;
	}
	
	public String order(String time, String combo){
		String process = "", equal= null;
		
		try{
			if((!time.isEmpty() && time != null)&&(!combo.isEmpty() && combo != null)){
				String[] aux = combo.split(",");
				
				if(identifyPeriod(time) == "Morning"){
					for(int i=0; i<= aux.length-1; i++){
						if(i == 0 && Integer.valueOf(aux[i]) > 1){
							process = "Eggs,";
							process = process + this.getByParameter(Integer.valueOf(aux[0]), "Morning")+",";
							i = 1;
						}
						else {
							if(i < aux.length-1){
								process = process + this.getByParameter(Integer.valueOf(aux[i]), "Morning")+",";
							}
							else{
								process = process + this.getByParameter(Integer.valueOf(aux[i]), "Morning");
							}
						}
					}
					
					aux = process.split(",");
					
					if(aux.length > 4){
						process = "";
						int count = 0, j= 0;
						
						for(int i=0; i<= aux.length-1; i++){
							if(j < aux.length-1)
								j = i+1;
							
							if(aux[i].equals(aux[j])){
								count++;
								if(count == 1){
									process = process + aux[i];
								}
							}
							else if(!aux[i].equals(aux[j]) || count <= 2){
								process = process + aux[i];
							}
							
							if(i < aux.length-1 && count == 0){
								process = process+",";
							}
						}
						
						if(count > 0){
							process = process +"(x"+count+")";
						}
					}
					
				}
				else{
					for(int i=0; i<= aux.length-1; i++){
						if(i < aux.length-1){
							process = process + this.getByParameter(Integer.valueOf(aux[i]), "Night")+",";
						}
						else{
							process = process + this.getByParameter(Integer.valueOf(aux[i]), "Night");
						}
					}
					
					aux = process.split(",");
					
					if(aux.length >= 4){
						process = "";
						
						int count = 0, j= 0;
						
						for(int i=0; i<= aux.length-1; i++){
							if(j < aux.length-1)
								j = i+1;
							
							if(aux[i].equals(aux[j])){
								count++;
								
								if(count==1){
									equal= aux[i]; 
								}
							}
						}
						
						j = 0;
						for(int i=0; i<= aux.length-1; i++){
							if(!aux[i].equals(equal))
								process = process + aux[i];
							
							if(aux[i].equals(equal) && j == 0){
								process = process+ equal +"(x"+count+")";
								j++;
							}
							
							if(i < aux.length-1){
								process = process+",";
							}
						}
					}
				}
				
				if(process.endsWith("(x1)")){
					process= process.replaceAll("(x1)","");
					process= process.replace("()","");
				}
				
				if(process.contains(",,")){
					process= process.replaceAll(",,", ",");
				}
				
				System.out.println(process);
			}
		}
		catch (Exception e) {
			System.out.println("Error occurred! "+e.getMessage());
		}
		
		return process;
	}
	
}