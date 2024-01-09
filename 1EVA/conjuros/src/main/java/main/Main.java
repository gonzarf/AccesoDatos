package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.Conexion;

public class Main {

	public static void main(String[] args) {

		try (Connection con = Conexion.open()) {
			printSQL(con,
				"SELECT alias, SUM(unidades) as 'suma unidades'"
				+ " FROM magos INNER JOIN magos_pocimas ON id = idMago"
				+ " GROUP BY id"
			);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	public static void printSQL(Connection con, String query) {

		try (PreparedStatement ps = con.prepareStatement(query)) {

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					String alias = rs.getString("alias");
					String sum = rs.getString("suma unidades");

					System.out.println(
						"ALIAS: " + alias
						+ ", UNIDADES: " + sum
					);
				}

			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

}
