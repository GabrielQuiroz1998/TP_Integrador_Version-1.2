package pronosticosDeportivos;

public class Pronostico {
	 private int idPartido;
	 private String prediccion;
	 
	 public Pronostico(int idPartido, String prediccion) {
		super();
		this.idPartido = idPartido;
		this.prediccion = prediccion;
	}

	public int getIdPartido() {
		return idPartido;
	}

	public String getPrediccion() {
		return prediccion;
	}
	 
}