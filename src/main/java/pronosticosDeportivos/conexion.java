package pronosticosDeportivos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class conexion {
	private Connection con;
	
	public conexion(){
		//con try le "digo" a java intente hacer esto, y de no poder ejecutar las instrucciones
		//lanzo las excepciones en el catch y sigo con la pila de ejecucion
		try {
			//Class.forName("com.mysql.jdbc.Driver");//1-Registro el Driver (esta comentado por que no es necesario)
			String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
			String nombre = "root";
			String password= "sanlorenzo";
			this.con = DriverManager.getConnection(url,nombre,password); //2-Crear Conexion
		} catch (SQLException e) {//aca capturo el tipo de error
			//aca uso los metodos del error para tratar de detallar el problema
			System.out.println(e.getSQLState());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public ResultSet consultaBD(String sql) throws SQLException {
		Statement stm = this.con.createStatement();//3-crear sentencia
		return stm.executeQuery(sql);
	}
	
	public void close() throws SQLException	{
		this.con.close();
	}	
	
}
