package Model;

import java.sql.Date;

public class Check {

	private int ID;
	private Date date;
	private float amount;
	private float state_tax;
	private float federal_tax;
	private float pension;
	private float medical;
	
	
	public void setID(int ID) {
		
		this.ID = ID;
	}
	
	public void setAmount(float amount) {
		
		this.amount = amount;
	}
	
	public void setState_Tax(float state_tax) {
		
		this.state_tax = state_tax;
	}
	
	public void setFederal_Tax(float federal_tax) {
		
		this.federal_tax = federal_tax;
	}
	
	public void setPension(float pension) {
		
		this.pension = pension;
	}
	
	public void setMedical(float medical) {
		
		this.pension = medical;
	}
	
	public void setDate(Date date) {
		
		this.date = date;
	}
	
	public int getID() {
		
		return ID;
	}
	
	public float getAmount() {
		
		return amount;
	}
	
	public float getState_Tax() {
		
		return state_tax;
	}
	
	public float getFederal_Tax() {
		
		return federal_tax;
	}
	
	public float getPension() {
		
		return pension;
	}
	
	public float getMedical() {
		
		return medical;
	}
	
	public Date getDate() {
		
		return date;
	}
}