package com.dieat.dto;
/**
 * DB에 저장될 음식의 영양표<br>
 * foodNo : 품목에 매겨지는 인덱스 번호<br>
 * foonName : 품목의 이름<br>
 * kcal : 품목의 열량(그램당 킬로칼로리)<br>
 * carbo : 품목의 탄수화물 함유량<br>
 * protein : 품목의 단백질 함유량<br>
 * fat : 품목의 지방 함유량<br>
 * sugars : 품목의 당 함유량<br>
 * natrium : 품목의 나트륨 함유량<br>
 * @author HSL
 *
 */
public class FoodInfo {
	
	private int foodNo;
	private String foodName;
	private int kcal;
	private float carbo;
	private float protein;
	private float fat;
	private float sugars;
	private float natrium;
	
	public int getFoodNo() {
		return foodNo;
	}
	public void setFoodNo(int foodNo) {
		this.foodNo = foodNo;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getKcal() {
		return kcal;
	}
	public void setKcal(int kcal) {
		this.kcal = kcal;
	}
	public float getCarbo() {
		return carbo;
	}
	public void setCarbo(float carbo) {
		this.carbo = carbo;
	}
	public float getProtein() {
		return protein;
	}
	public void setProtein(float protein) {
		this.protein = protein;
	}
	public float getFat() {
		return fat;
	}
	public void setFat(float fat) {
		this.fat = fat;
	}
	public float getSugars() {
		return sugars;
	}
	public void setSugars(float sugars) {
		this.sugars = sugars;
	}
	public float getNatrium() {
		return natrium;
	}
	public void setNatrium(float natrium) {
		this.natrium = natrium;
	}
	
	
	
}
