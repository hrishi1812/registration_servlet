package registration_servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class UserCRUD {
	public Connection getConnection() throws Throwable {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlets?user=root&password=976478@se.com");
		return connection;
	}
	public int signUp(User user) throws Throwable {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO USER VALUES(?,?,?,?,?,?,?,?)");
		preparedStatement.setInt(1, user.getId());
		preparedStatement.setString(2, user.getName());
		preparedStatement.setLong(3, user.getPhone());
		preparedStatement.setInt(4, user.getAge());
		preparedStatement.setString(5, user.getFatherName());
		preparedStatement.setString(6, user.getMotherNmae());
		preparedStatement.setString(7, user.getEmail());
		preparedStatement.setString(8, user.getPassword());
		int result=preparedStatement.executeUpdate();
		connection.close();
		return result;
	}
	public String logIn(String email) throws Throwable {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("Select password from user where email=? ");
		preparedStatement.setString(1, email);
		ResultSet resultSet=preparedStatement.executeQuery();
		String password=null;
		if(resultSet.next()) {
			password=resultSet.getString("password");
		}
		connection.close();
		return password;
	}


}
