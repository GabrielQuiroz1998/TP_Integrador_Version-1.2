package pronosticosDeportivos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class conexion {
	private Connection con;
	
	public conexion(){
		try {
			//Class.forName("com.mysql.jdbc.Driver");//1-Registro el Driver
			//el regristro del driver esta comentado por que la consola me dice que no es necesario
			//ya que ser carga automaticamente
			String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
			String nombre = "root";
			String password= "sanlorenzo";
			this.con = DriverManager.getConnection(url,nombre,password); //2-Crear Conexion
		} catch (Exception e) {
			// TODO: handle exception
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
