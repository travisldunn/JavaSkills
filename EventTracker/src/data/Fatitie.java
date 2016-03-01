package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FatCounter")
public class Fatitie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFatCounter;
	private int CurrentFat;
	private int GoalFat;
	private String FatFood;
	private int FatLeft;
	
	public Fatitie(){}
	
	public Fatitie(int currentFat, int goalFat, String fatFood, int fatLeft) {
		super();
		CurrentFat = currentFat;
		GoalFat = goalFat;
		FatFood = fatFood;
		FatLeft = fatLeft;
	}
	
	public int getCurrentFat() {
		return CurrentFat;
	}
	public void setCurrentFat(int currentFat) {
		CurrentFat = currentFat;
	}
	public int getGoalFat() {
		return GoalFat;
	}
	public void setGoalFat(int goalFat) {
		GoalFat = goalFat;
	}
	public String getFatFood() {
		return FatFood;
	}
	public void setFatFood(String fatFood) {
		FatFood = fatFood;
	}
	public int getIdFatCounter() {
		return idFatCounter;
	}
	public int getFatLeft() {
		return FatLeft;
	}
	public void setFatLeft(int fatLeft) {
		FatLeft = fatLeft;
	}
	
}
