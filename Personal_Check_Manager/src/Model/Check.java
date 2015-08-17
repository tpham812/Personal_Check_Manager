package Model;

import java.sql.Date;
import java.util.Calendar;

public class Check {

	private int ID;
	private Date date;
	private float amount;
	private float state_tax;
	private float federal_tax;
	private float pension;
	private float medical;
	private Calendar calendar;
	
	public Check(int ID, float amount, float state_tax, float federal_tax, float pension, float medical, int month, int day, int year) {
		
		this.ID = ID;
		this.amount = amount;
		this.state_tax = state_tax;
		this.federal_tax = federal_tax;
		this.pension = pension;
		this.medical = medical;
		this.calendar = Calendar.getInstance();
		setDate(month, day, year);
	}
	
	public Check(int month, int day, int year) {
		
		this.calendar = Calendar.getInstance();
		setDate(month, day, year);
	}
	
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
	
	public void setDate(int month, int day, int year) {
		
		calendar.set(year, month, day);
		date = new Date(calendar.getTimeInMillis());
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