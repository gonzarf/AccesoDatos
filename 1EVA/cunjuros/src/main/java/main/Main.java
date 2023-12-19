package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.Conexion;

public class Main {

	public static void main(String[] args) {
		
		try (Connection con = Conexion.open()) {
			
			//System.out.println("Nombre: " + con.getMetaData().getDatabaseProductName());
			
			printSQL(con,"SELECT alias, sum(unidades) FROM magos INNER JOIN magos_pocimas ON id = idMago group by id;"); 
			
		}catch(SQLException ex) {
			
			ex.printStackTrace();
			
		}
	}
	
	public static void printSQL(Connection con, String query /*,String aliasFilter*/) { //  AÑADIMOS UN STRING QUE VA A SER EL WHERE DE LA CONSULTA
		
		try (PreparedStatement ps = con.prepareStatement(query)){
			
			//ps.setString(1, aliasFilter); // SUSTITUIMOS LA PRUIMERA INTERROGACION POR EL sTRING RECIBIDO
			
			try (ResultSet rs = ps.executeQuery()){
				
				while (rs.next()) {  // rs.next() RECORRE LOS DATOS UE DEVULEVE LA QUERY Y NOS DEVUELVE TRUE MIENTRAS HAYA ALGO EN LA SIGUIENTE LINEA.
					
					//int id = rs.getInt("id");
					String alias = rs.getString("alias");
					//String nombre = rs.getString("nombre");
					int unidades= rs.getInt("sum(unidades)");
					
					System.out.println("ALIAS: " + alias
							+ ", UNIDADES: " + unidades
					);
					
				}
				
			}
			
		}catch(SQLException ex) {
			
			ex.printStackTrace();
			
		}
		
	}

}
