package pronosticosDeportivos;

public class Partido {
	private int idPartido;
	private String equipoA;
	private String equipoB;
	private int golesA;
	private int golesB;
	
	public Partido(int idPartido, String equipoA, String equipoB, int golesA, int golesB) {
		super();
		this.idPartido = idPartido;
		this.equipoA = equipoA;
		this.equipoB = equipoB;
		this.golesA = golesA;
		this.golesB = golesB;
	}
	
	public String resultado ()	{
		if(golesA > golesB) {
			return "L";
		}else if(golesB > golesA) {
			return "V";
		}else {
			return "E";
		}
	}

	public int getIdPartido() {
		return idPartido;
	}

	public String getEquipoA() {
		return equipoA;
	}

	public String getEquipoB() {
		return equipoB;
	}
	
}
