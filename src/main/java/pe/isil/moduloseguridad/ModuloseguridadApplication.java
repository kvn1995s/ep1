package pe.isil.moduloseguridad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class ModuloseguridadApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ModuloseguridadApplication.class, args);

		//Cargar Driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		//Crear conexion
		Connection conexion = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/moduloseg2", "root", "kamc123456");

		//Ep1Statement(conexion);
		Ep1PreparedStatementResult(conexion);
		//Ep1CallableStatement(conexion);

		}
	public static void Ep1Statement(Connection connection) throws Exception {
		//Crear statement
		Statement statement = connection.createStatement();

		//Ejecutar sentencia
		int affectedRows = statement.executeUpdate("update userswow set name='jorge' where id=1");
		System.out.println("Filas afectadas: " + affectedRows);

		ResultSet resultSet = statement.executeQuery("select * from userswow");
		while (resultSet.next()) {
			System.out.println(resultSet.getString("name"));
		}
		System.out.println("Filas afectadas: " + affectedRows);

	}

	public static void Ep1PreparedStatementResult(Connection connection) throws Exception{

		PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM userswow WHERE NAME=?");
		preparedStatement.setString(1,"Kevin");

		int affectedRows = preparedStatement.executeUpdate();

		System.out.println("Filas afectadas: " + affectedRows);
	}
	public static void Ep1CallableStatement(Connection connection) throws Exception{

		CallableStatement cs = connection.prepareCall("{call getAllUssers()}");
		ResultSet rs = cs.executeQuery();

		while(rs.next()){
			System.out.println(rs.getString("name") + " " +
					rs.getString("nickname") + " " +
					rs.getString("pass") + " " +
					rs.getString("class") + " " +
					rs.getString("spec")	+ " " +
					rs.getString("lvl") + " " +
					rs.getString("enable")
			);
		}
	}
}
