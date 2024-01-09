package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// Se va a ocupar de realizar conexiones con la BD.
public class Conexion {
	private static final String url = "jdbc:mysql://localhost/hechiceria";
	private static final String usuario = "root";
	private static final String pswd = "AlumnoIFP";

	public static Connection open() throws SQLException {
		Properties props = new Properties();

		props.setProperty("user", usuario);
		props.setProperty("password", pswd);
		props.setProperty("ssl", "true");

		return DriverManager.getConnection(url, props);
	}

}
