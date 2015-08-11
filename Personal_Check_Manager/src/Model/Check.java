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
	
	@SuppressWarnings("deprecation")
	public Check(int ID, float amount, float state_tax, float federal_tax, float pension, float medical, int month, int day, int year) {
		
		this.ID = ID;
		this.amount = amount;
		this.state_tax = state_tax;
		this.federal_tax = federal_tax;
		this.pension = pension;
		this.medical = medical;
		date = new Date(year, month, day);
	}
	
}
