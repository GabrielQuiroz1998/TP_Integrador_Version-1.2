package pronosticosDeportivos;

import java.util.ArrayList;

public class Usuario {
	private String nombre;
	private String apellido;
	private ArrayList<Pronostico> pronostico;
	private int puntosPorAcertar;
	private int puntajeAcumulado;
	private int partidosAcertados;
	private static int cantidadUsuarios;
	
	public Usuario(String nombre, String apellido, ArrayList<Pronostico> pronostico, int puntosPorAcertar) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.pronostico = pronostico;
		this.puntajeAcumulado = 0;
		this.partidosAcertados = 0;
		this.puntosPorAcertar  = puntosPorAcertar;
		cantidadUsuarios ++;
	}

	public void setPuntajeAcumulado() {
		this.puntajeAcumulado += getPuntosPorAcertar();
	}

	public int getPuntajeAcumulado() {
		return puntajeAcumulado;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public ArrayList<Pronostico> getPronostico() {
		return pronostico;
	}

	public int getPuntosPorAcertar() {
		return puntosPorAcertar;
	}
	
	public void partidoAcertado() {
		this.partidosAcertados += 1;
	}
	
	public int getPartidosAcertados() {
		return partidosAcertados;
	}

	public static int getCantidadUsuarios() {
		return cantidadUsuarios;
	}	
	
	
}
