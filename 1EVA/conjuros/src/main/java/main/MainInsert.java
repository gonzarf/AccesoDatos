package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;
import entidades.Mago;

public class MainInsert {

	public static void main(String[] args) {
		
		ArrayList<Mago> magosNuevos = new ArrayList<>();
		
		magosNuevos.add(new Mago("MagoNuevo1", "Mago Nuevo 1", "111111111"));
		magosNuevos.add(new Mago("MagoNuevo2", "Mago Nuevo 2", "222222222"));
		magosNuevos.add(new Mago("MagoNuevo3", "Mago Nuevo 3", "333333333"));
		
		
		//Codigo para insertar datos en la base de datos
		
		try (Connection con = Conexion.open()) {
			
			//insertar(con, magosNuevos);
			//actualozarNombre(con, 1, "Gonzalo");
			borrar(con,2);
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			
		}
	}

	// Actualizar datos en la base de datos
	private static void actualozarNombre(Connection con, int primaryKey, String nuevoNombre) {
		
		String sql = "UPDATE magos SET nombre = ? WHERE id = ?";
		
		try(PreparedStatement ps = con.prepareStatement(sql)) {
			
			ps.setString(1, nuevoNombre);
			ps.setInt(2, primaryKey);
				
			int nFilas = ps.executeUpdate();
			
			System.out.println("Se han modificado " + nFilas + " correctamente.");
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			
		}
	}
	
	private static void borrar(Connection con, int primaryKey) {
		
		String sql = "DELETE FROM magos WHERE id = ?";
		
		try(PreparedStatement ps = con.prepareStatement(sql)) {
			
			ps.setInt(1, primaryKey);
				
			int nFilas = ps.executeUpdate();
			
			System.out.println("Se han borrado " + nFilas + " correctamente.");
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			
		}
	}

	private static void insertar(Connection con, ArrayList<Mago> magosNuevos) {
		
		String sql = "INSERT INTO magos VALUES (NULL, ?, ?, ?)";
		
		try(PreparedStatement ps = con.prepareStatement(sql)) {
			
			for (Mago m : magosNuevos) {
				
				ps.setString(1, m.getAlias());
				ps.setString(2, m.getNombre());
				ps.setString(3, m.getTelefono());
				
				int nFilas = ps.executeUpdate();
				
				System.out.println("Se han anadido " + nFilas + " correctamente.");
				
			}
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
		}
		
	}

}
