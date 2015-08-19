package Model;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet; 
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

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
			String sqlCommand = "SELECT * FROM CHECK " +
					"LIMIT 100 OFFSET " + offset;
			resultSet = statement.executeQuery(sqlCommand);
	
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

	public void createRecord(int Id, float amount, float state_Tax, float federal_Tax, float pension, float medical, int month, int day, int year) {

		Connection connection = null;
		Statement statement = null;
		Calendar calendar = null;
		try {
			calendar = Calendar.getInstance();
			calendar.set(year, month, day);
			Date date = new Date(calendar.getTimeInMillis());
			connection = DriverManager.getConnection(url, username, password);
			statement = connection.createStatement();
			Check check = new Check();
			check.setID(Id);
			check.setAmount(amount);
			check.setState_Tax(state_Tax);
			check.setFederal_Tax(federal_Tax);
			check.setPension(pension);
			check.setMedical(medical);
			check.setDate(date);
			checks.add(check);
			String sqlCommand = "INSERT INTO CHECK (Id, Amount, StateTax, FederalTax, Pension, Medical, Date)" +
					"VALUES (" +
					"'" + Id + "'," +
					"'" + state_Tax + "'," +
					"'" + federal_Tax + "'," +
					"'" + pension + "'," +
					"'" + medical + "'," +
					"'" + date + "')";
			statement.execute(sqlCommand);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			closeAllObjects(null, statement, connection);
		}
	}

	public void updateRecord(int Id, float amount, float state_Tax, float federal_Tax, float pension, float medical, int month, int day, int year) {

	}

	public void deleteRecord(int Id) {

		Connection connection = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection(url, username, password);
			statement = connection.createStatement();
			String sqlCommand = "DELETE FROM CHECK " +
								"WHERE Id = " + Id;
			statement.execute(sqlCommand);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			closeAllObjects(null, statement, connection);
		}
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