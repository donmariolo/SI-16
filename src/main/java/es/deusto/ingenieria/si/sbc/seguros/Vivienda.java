package es.deusto.ingenieria.si.sbc.seguros;

import java.util.ArrayList;
import java.util.List;


public class Vivienda {
	
	public static enum Tipo {
		PISO, 
		CASA_UNIFAMILIAR
	}

	public static enum CalidadConstruccion {
		MEDIA,
		EXCELENTE
	}

	public static enum Antiguedad {
		VIEJA,
		SEMI_NUEVA,
		NUEVA
	}

	public static enum RangoPresupuesto {
		BAJO,
		MEDIO,
		ALTO
	}

	//El uso de esta enumeracion es opcional
	public static enum Tarea {
		
	}
	
	private String propietario;
	private String direccion;
	private Poliza poliza;
	private Tipo tipo;
	private CalidadConstruccion calidad;
	private int edad;
	private Antiguedad antiguedad;
	private double presupuesto;
	private RangoPresupuesto rangoPresupuesto;
	private boolean mejoras;
	private boolean pertenenciasValiosas;
	
	private Tarea tarea;
	private List<String> hitos;
	
	public String getPropietario() {
		return propietario;
	}
	
	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public Poliza getPoliza() {
		return poliza;
	}
	
	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}
	
	public Tipo getTipo() {
		return tipo;
	}
	
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	public CalidadConstruccion getCalidad() {
		return calidad;
	}
	
	public void setCalidad(CalidadConstruccion calidad) {
		this.calidad = calidad;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public Antiguedad getAntiguedad() {
		return antiguedad;
	}
	
	public void setAntiguedad(Antiguedad antiguedad) {
		this.antiguedad = antiguedad;
	}
	
	public double getPresupuesto() {
		return presupuesto;
	}
	
	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}
	
	public RangoPresupuesto getRangoPresupuesto() {
		return rangoPresupuesto;
	}
	
	public void setRangoPresupuesto(RangoPresupuesto rangoPresupuesto) {
		this.rangoPresupuesto = rangoPresupuesto;
	}
	
	public boolean isMejoras() {
		return mejoras;
	}
	
	public void setMejoras(boolean mejoras) {
		this.mejoras = mejoras;
	}
	
	public boolean isPertenenciasValiosas() {
		return pertenenciasValiosas;
	}
	
	public void setPertenenciasValiosas(boolean pertenenciasValiosas) {
		this.pertenenciasValiosas = pertenenciasValiosas;
	}
	
	public Tarea getTarea() {
		return tarea;
	}

	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}

	public void addHito(String hito) {
		if (hitos == null) {
			hitos = new ArrayList<String>();
		}
		
		if (!hitos.contains(hito)) {
			hitos.add(hito);
		}
	}
	
	public List<String> getHitos() {
		return hitos;
	}

	public String toString() {
		String result = "- Informacion de la vivienda:";
		result += "\n   * Direccion: " + direccion;
		result += "\n   * Propietario: " + propietario;
		
		if (tipo != null) {
			result += "\n   * Tipo: " + tipo.toString();
		}
		
		if (calidad != null) {
			result += "\n   * Calidad construccion: " + calidad.toString();
		}
		
		if (antiguedad == null) { 
			result += "\n   * Edad: " + edad;
		} else {
			result += "\n   * Antiguedad: " + antiguedad;
		}
			
		if (mejoras) {
			result += "\n   * Tiene mejoras";	
		}
			
		if (pertenenciasValiosas) {				
			result += "\n   * Posee pertenencias valiosas";
		}
			
		if (rangoPresupuesto == null) {
			result += "\n   * Presupuesto: " + presupuesto;
		} else {
			result += "\n   * Rango Presupuesto: " + rangoPresupuesto.toString();
		}
		
		if (poliza != null) {
			result += "\n   * POLIZA RECOMENDADA: " + poliza.toString();
		}
		
		if (hitos != null && !hitos.isEmpty()) {
			result += "\n   * RED DE SEGURIDAD (hitos): ";
			
			for (String hito : hitos) {
				result += "\n      - " + hito;
			}			
		}
		
		return result;
	}
}