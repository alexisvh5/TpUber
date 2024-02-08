package ar.edu.unlam.pb1;

import java.util.Arrays;

public class Remiseria {

	private String nombreDeLaRemiseria;
	private double precioPorKilometro;
	private Vehiculo flota[];
	private Viaje viajes[];
	
	public Remiseria(String nombreDeLaRemiseria, double precioPorKilometro) {
		this.nombreDeLaRemiseria = nombreDeLaRemiseria;
		this.precioPorKilometro = precioPorKilometro;
	}

	public boolean agregarNuevoVehiculo(Vehiculo nuevo) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean agregarNuevaUbicacion(Ubicacion nuevo) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Vehiculo[] buscarVehiculosDisponibles() {
		return null;
	}

	@Override
	public String toString() {
		return "Remiseria [flota=" + Arrays.toString(flota) + "]";
	} 

	public double iniciarViaje(String patente, String destino) {
		// TODO Auto-generated method stub
		return 0d;
	}
	
	public boolean finalizarViaje(String patente) {
		return false;
	}

	public Vehiculo[] buscarVehiculosEnViaje() {
		// TODO Auto-generated method stub
		return null;
	}
}
