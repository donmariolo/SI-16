package es.deusto.ingenieria.si.sbc.seguros;

public class Poliza {

	public static enum Nombre {
		TERCEROS,
		ESENCIAL_HOGAR,
		MULTI_RIESGO,
		PLATA,
		ORO,
		PLATINO
	}
	
	private Nombre nombre;
	private double coberturaContenido;
	private double coberturaContinente;
	private double coberturaTerceros;
	private boolean asistenciaHogar;
	private boolean asistenciaLegal;
	
	public Poliza() {		
	}
	
	public Poliza(Nombre nombre) {
		this.nombre = nombre;
	}
	
	public Nombre getNombre() {
		return nombre;
	}
	
	public void setNombre(Nombre nombre) {
		this.nombre = nombre;
	}
	
	public double getCoberturaContenido() {
		return coberturaContenido;
	}
	
	public void setCoberturaContenido(double coberturaContenido) {
		this.coberturaContenido = coberturaContenido;
	}
	
	public double getCoberturaContinente() {
		return coberturaContinente;
	}
	
	public void setCoberturaContinente(double coberturaContinente) {
		this.coberturaContinente = coberturaContinente;
	}
	
	public double getCoberturaTerceros() {
		return coberturaTerceros;
	}
	
	public void setCoberturaTerceros(double coberturaTerceros) {
		this.coberturaTerceros = coberturaTerceros;
	}
	
	public boolean isAsistenciaHogar() {
		return asistenciaHogar;
	}
	
	public void setAsistenciaHogar(boolean asistenciaHogar) {
		this.asistenciaHogar = asistenciaHogar;
	}
	
	public boolean isAsistenciaLegal() {
		return asistenciaLegal;
	}
	
	public void setAsistenciaLegal(boolean asistenciaLegal) {
		this.asistenciaLegal = asistenciaLegal;
	}
	
	public String toString() {
		return nombre.toString();
	}
}
