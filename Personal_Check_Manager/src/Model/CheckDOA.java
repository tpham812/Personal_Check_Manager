package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet; 
import java.sql.Statement;
import java.util.ArrayList;

public class CheckDOA {

	private ArrayList<Check> checks;
	private final String url = "jdbc:mysql://localhost:3306/truongdb";
	private final String username = "tpham812";
	private final String password = "August121991";
	private int offset;

	public CheckDOA () {

		checks = new ArrayList<Check>();
		offset = 0;
	}

	public ArrayList<Check> getAllRecords () {

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DriverManager.getConnection(url, username, password);
			statement = connection.createStatement();
			String sqlQuery = "SELECT * FROM CHECK" +
					"LIMIT 100 OFFSET " + offset;
			resultSet = statement.executeQuery(sqlQuery);
			checks.clear();
			try {
				while(resultSet.next()) {
					Check check = new Check();
					check.setID(resultSet.getInt("Id"));
					check.setAmount(resultSet.getFloat("Amount"));
					check.setState_Tax(resultSet.getFloat("StateTax"));
					check.setFederal_Tax(resultSet.getFloat("FederalTax"));
					check.setPension(resultSet.getFloat("Pension"));
					check.setMedical(resultSet.getFloat("Medical"));
					check.setDate(resultSet.getDate("Date"));
					checks.add(check);
				}
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			closeAllObjects(resultSet, statement, connection);
		}
		return checks;
	}

	public void createRecord(int ID, float amount, float state_tax, float federal_tax, float pension, float medical, int month, int day, int year) {

	}

	public void updateRecord(int ID, float amount, float state_tax, float federal_tax, float pension, float medical, int month, int day, int year) {

	}

	public void deleteRecord(int ID) {

	}

	public void nextOffSet() {

		offset += 100;
	}

	public void previousOffSet() {

		offset -= 100;
	}

	private void closeAllObjects(ResultSet resultSet, Statement statement, Connection connection) {

		try{
			if(resultSet!= null)
				resultSet.close();
			if(statement != null)
				statement.close();
			if(connection != null)
				connection.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}