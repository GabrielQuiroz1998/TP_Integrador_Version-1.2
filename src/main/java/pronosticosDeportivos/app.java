package pronosticosDeportivos;

import java.sql.ResultSet;
import java.util.ArrayList;

public class app {
	
	public static ArrayList<Partido> consultaDBpartidos(ArrayList<Partido> partidos, String consulta) {
		try{ 	
			conexion cnx = new conexion();
			ResultSet resultados = cnx.consultaBD(consulta);
			while(resultados.next()) {
				Partido partido = new Partido(resultados.getInt(1), resultados.getString(2),
						resultados.getString(3),resultados.getInt(4),
						resultados.getInt(5));
				partidos.add(partido);			
			}
			cnx.close();
			} catch(Exception e)
				{ System.out.println(e);
			} 
		return partidos;
	}
	
	public static ArrayList<Pronostico> consultaDBpronosticos(ArrayList<Pronostico> pronosticos, String consulta){
		try{ 	
			conexion cnx = new conexion();
			ResultSet resultados = cnx.consultaBD(consulta);
			while(resultados.next()) {
				Pronostico pronostico = new Pronostico(resultados.getInt(1), resultados.getString(2));
				pronosticos.add(pronostico);
			}
			cnx.close();	
			} catch(Exception e)
				{ System.out.println(e);
			} 
		return pronosticos;
	}
	
	public static void lineaDivisoria() {
		System.out.println("__________________________________________________");
	}

	public static void asignarPuntajeUsuario(ArrayList<Partido> partidos,Usuario usuario) {
		for (int i = 0; i < partidos.size(); i++) {
			for (int y = 0; y < usuario.getPronostico().size(); y++) {
				    if(partidos.get(i).getIdPartido() == usuario.getPronostico().get(y).getIdPartido()) {
				    	if(partidos.get(i).resultado().equals(usuario.getPronostico().get(y).getPrediccion())){
				    		usuario.setPuntajeAcumulado();
				    		usuario.partidoAcertado();
				    	 }
				     }
			  }
		}		
	}
	
	public static void imprimirPuntajes(Usuario usuario) {
		System.out.println(usuario.getNombre().toUpperCase()+" "+usuario.getApellido().toUpperCase());
		System.out.println("Partidos acertados: " + usuario.getPartidosAcertados());
		System.out.println("Puntaje acumulado: " + usuario.getPuntajeAcumulado());
	}
	
	public static Usuario ganadorCompetencia(ArrayList<Usuario> usuarios) {
		Usuario ganador = usuarios.get(0);
		for(int i=0;i<usuarios.size()-1;i++) {
			if(usuarios.get(i).getPuntajeAcumulado() > usuarios.get(i+1).getPuntajeAcumulado()) {
				ganador = usuarios.get(i);
			}
		}
		return ganador;
	}
	
	public static void main(String[] args) {
		ArrayList<Partido> partidos = new ArrayList<Partido>();
		String consulta = "SELECT * FROM tp_gabrielquiroz.partido;";
		//estos metodos estan mal, tengo que separar la consulta de la creacion de los
		//arraylists pero los hice asi para no cargar tanto el main
		partidos = consultaDBpartidos(partidos,consulta);
		ArrayList<Pronostico> pronosticos = new ArrayList<Pronostico>();
		consulta = "SELECT * FROM tp_gabrielquiroz.pronosticos;";
		pronosticos = consultaDBpronosticos(pronosticos,consulta);
		
		//el usuario tiene que ingresar nombre, apellido, pronosticos y cantidad de puntos por acierto	
		Usuario gabriel = new Usuario("Gabriel","Quiroz", pronosticos, 2);
		Usuario marcelo = new Usuario("Marcelo","Quiroz", pronosticos, 3);
		Usuario guadalupe = new Usuario("Guadalupe","Quiroz", pronosticos, 4);
		Usuario ayelen = new Usuario("Ayelen","Quiroz", pronosticos, 1);
		Usuario fabiana = new Usuario("Fabiana","Espina", pronosticos, 1);
		asignarPuntajeUsuario(partidos, gabriel);
		asignarPuntajeUsuario(partidos, marcelo);
		asignarPuntajeUsuario(partidos, guadalupe);
		asignarPuntajeUsuario(partidos, ayelen);
		asignarPuntajeUsuario(partidos, fabiana);
		ArrayList<Usuario> listaDeUsuarios = new ArrayList<Usuario>();
		listaDeUsuarios.add(gabriel);
		listaDeUsuarios.add(marcelo);
		listaDeUsuarios.add(guadalupe);
		listaDeUsuarios.add(ayelen);
		listaDeUsuarios.add(fabiana);
		
		System.out.println("PUNTAJES");
		lineaDivisoria();
		imprimirPuntajes(gabriel);
		lineaDivisoria();
		imprimirPuntajes(marcelo);
		lineaDivisoria();
		imprimirPuntajes(guadalupe);
		lineaDivisoria();
		imprimirPuntajes(ayelen);
		lineaDivisoria();
		imprimirPuntajes(fabiana);
		lineaDivisoria();
		System.out.println("El ganador es: " + ganadorCompetencia(listaDeUsuarios).getNombre());	
	}
}
