package ar.edu.unlam.pb1;

import java.util.Arrays;
import java.util.Scanner;

/****
 * Interfaz de usuario para la ejecución del software para gestión de viajes desde la UNLAM
 * @author Juan Monteagudo
 *
 */
public class PruebaUberUnlam {

	private static Scanner teclado = new Scanner(System.in);
	private static final int INCORPORAR_VEHICULO = 1, AGREGAR_UBICACION = 2, INICIAR_VIAJE = 3, FINALIZAR_VIAJE = 4, CALCULAR_IMPORTE_PROMEDIO = 5, SALIR = 9;
	
	/****
	 * Método principal
	 * @param args
	 */
	public static void main (String args[]) {
		String nombreDeLaRemiseria = "Remis UNLAM";
		double precioPorKilometro = 10;
		Remiseria actual = null;
		
		System.out.println("Ingrese el nombre de la remisería");
		nombreDeLaRemiseria = teclado.next();
		actual = new Remiseria(nombreDeLaRemiseria, precioPorKilometro);
		
		int opcion = 0;
		do {
			System.out.println(actual);
			mostrarMenu();
			
			opcion = teclado.nextInt();
			
			switch(opcion) {
			case INCORPORAR_VEHICULO:
				incorporarVehiculo(actual);
				break;
			case AGREGAR_UBICACION:
				agregarUbicacion(actual);
				break;
			case INICIAR_VIAJE:
				iniciarViaje(actual);
				break;
			case FINALIZAR_VIAJE:
				finalizarViaje(actual);
				break;
			case CALCULAR_IMPORTE_PROMEDIO:
				calcularImportePromedio(actual);
			default:
				System.out.println("Opción inválida");
			}		
		} while(opcion!=SALIR);	
	}


	/****
	 * Se visualizan las opciones del menú
	 */
	private static void mostrarMenu() {
		System.out.println("Opciones");
		System.out.println(INCORPORAR_VEHICULO + ". Incorporar nuevo vehiculo");
		System.out.println(AGREGAR_UBICACION + ". Agregar nueva ubicación");
		System.out.println(INICIAR_VIAJE + ". Iniciar nuevo viaje");
		System.out.println(FINALIZAR_VIAJE + ". Finalizar viaje");
		System.out.println(CALCULAR_IMPORTE_PROMEDIO + ". Calcular el importe promedio de viajes");
		System.out.println(SALIR + ". Salir");
		System.out.println("Ingrese la opción deseada");
	}
	
	/****
	 * Incorporación de un nuevo vehículo a la remisería
	 * @param actual La remisería sobre la cual se está incorporando el nuevo vehículo
	 */
	private static void incorporarVehiculo(Remiseria actual) {
		String patente, nombreDelConductor, marca, modelo;
		Vehiculo nuevo = null;
		
		System.out.println("Ingrese la marca del vehículo: ");
		marca = teclado.next();
		System.out.println("Ingrese el modelo del vehículo: ");
		modelo = teclado.next();
		System.out.println("Ingrese la patente: ");
		patente = teclado.next();
		System.out.println("Ingrese el nombre del conductor: ");
		nombreDelConductor = teclado.next();
				
		nuevo = new Vehiculo(marca, modelo, patente, nombreDelConductor);
		
		if(actual.agregarNuevoVehiculo(nuevo)) {
			System.out.println("Se dio de alta el nuevo vehículo: " + nuevo);
		}
		else {
			System.out.println("Ocurrió un error. Posiblemente se llenó la capacidad de la flota");
		}
	}

	/****
	 * Agregar un destino posible a la remiseria
	 * @param actual La remisería sobre la cual se está incorporando el nuevo destino
	 */
	private static void agregarUbicacion(Remiseria actual) {
		String nombreUbicacion;
		int distanciaEnKilometros;
		Ubicacion nueva = null;
		
		System.out.println("Ingrese la descripción de la nueva ubicación");
		nombreUbicacion = teclado.next();
		System.out.println("Ingrese la distancia en kilómetros");
		distanciaEnKilometros = teclado.nextInt();
		
		nueva = new Ubicacion(nombreUbicacion, distanciaEnKilometros);

		boolean resultado = actual.agregarNuevaUbicacion(nueva);
		if(resultado) {
			System.out.println("Se agregó la nueva ubicación " + nueva);
		}
		else {
			System.out.println("Ocurrió un error agregando la ubicación");
		}
	}

	/****
	 * Inicia un viaje
	 * @param actual La remisería sobre la cual se está iniciando el viaje
	 */
	private static void iniciarViaje(Remiseria actual) {
		String ubicacionDeseada, patente;
		double precio;
		Vehiculo disponibles[] = actual.buscarVehiculosDisponibles();
		
		System.out.println(Arrays.toString(disponibles));
		System.out.println("Ingrese el vehiculo deseado");
		patente = teclado.next();
		
		System.out.println("Ingrese la ubicación a la que desea ir:");
		ubicacionDeseada = teclado.next();
		
		precio = actual.iniciarViaje(patente, ubicacionDeseada); 
		if(precio > 0) {
			System.out.println("Se inició el viaje. El precio será $ " + precio + ". Recuerde avisar cuando finaliza para liberar el vehiculo");
		}		
	}
	
	/****
	 * Finaliza un viaje
	 * @param actual La remisería sobre la cual se está iniciando el viaje
	 */
	private static void finalizarViaje(Remiseria actual) {
		String patente;
		Vehiculo enViaje[] = actual.buscarVehiculosEnViaje();
		
		System.out.println(Arrays.toString(enViaje));
		System.out.println("Ingrese el vehiculo que terminó su viaje");
		patente = teclado.next();
	
		if(actual.finalizarViaje(patente)) {
			System.out.println("Se finalizó el viaje. El vehiculo utilizado ya se encuentra disponible nuevamente");
		}		
		else {
			System.out.println("Ese vehículo no estaba en ningún viaje");
		}
	}
	
	private static void calcularImportePromedio(Remiseria actual) {
	
		
	}

}
