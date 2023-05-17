package jcolonia.daw2023.examen;

import java.util.Scanner;
import java.util.Vector;

public class VistaMenúBásico extends VistaGeneral{
	
	private Vector <String> lista;
	
	public <T> VistaMenúBásico(Scanner scConsola, T[] OPCIONES_MENÚ_PRINCIPAL) {
		super(scConsola);
		
		lista = new Vector<>();
		
		for(T elemento : OPCIONES_MENÚ_PRINCIPAL) {
			lista.add(elemento.toString());
		}
	}
	
	/*
	 * Muestra las opciones del menu
	 */
	
	public void mostrarOpciones() {
		int i;
		
		for(i=0;i<lista.size();i++) {
			System.out.printf("%d) %s%n", i+1, lista.get(i));
		}
		System.out.println("0) Salir\n");
	}
	
	/*
	 * Pregunta al usuario que opcion quiere elegir.
	 * Respuesta sera la respuesta elegida por el usuario.
	 * La excepcion en caso de que algo vaya mal
	 */
	
	public int pedirOpcion() throws ErroresMultiplesException {
		int i = pedirNumero("Elije una opcion: (0 si quieres salir)", 0, lista.size());
		System.out.printf("%n%n");
	
		return i;
	}

	public void mostrarTítulo1() {
		// TODO Esbozo de método generado automáticamente
		
	}
}
