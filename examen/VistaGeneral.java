package jcolonia.daw2023.examen;

import java.util.Scanner;

public class VistaGeneral {
private static Scanner sc;
	
	private static final String TEXTO = "Introducir un Numero (Tecla F = salir)";
	
	public VistaGeneral(Scanner entrada) {
		sc = entrada;
	}
	
	public static Scanner getScanner() {
		if(sc == null) {
			sc = new Scanner(System.in);
		}
		return sc;
	}
	
	public static String pedirTextos() {
		String elem;
		System.out.println("Escribe un texto:");
		sc = getScanner();
		elem = sc.nextLine();
		System.out.println();
		return elem;
	}
	
	public static String pedirTextos(String texto) {
	    String elem;
	    System.out.print(texto);
	    sc = getScanner();
	    elem = sc.nextLine();  
	    System.out.println();
	    
	    return elem;
	  }
	
	public static int pedirNumero() throws ErroresMultiplesException, TeclaException {
		int num = 0;
		int er = 0;
		boolean salir = false;
		do {
			if(er > 5) {
				throw new ErroresMultiplesException();
			}
			sc = getScanner();
			System.out.printf("%s%n", TEXTO);
		      String texto = sc.nextLine();
		      
		      if(texto.compareToIgnoreCase("Q") == 0) {
		        throw new TeclaException();
		      }
		      try {
		        num = Integer.parseInt(texto);
		        salir = true;
		      }catch(NumberFormatException ex) {
		        System.err.printf("Escriba un numero: %s%n", ex.getLocalizedMessage());
		        er++;
		      }
		} while(!salir);
		  return num;
	}
	
	public static int pedirNumero(String texto) throws ErroresMultiplesException {
		int num = 0;
	    int er = 0;
	    boolean salir = false;
	    do {
	      if (er > 4) {
	        throw new ErroresMultiplesException();
	      }
	      sc = getScanner();
	      System.out.printf("%s%n", texto);
	      String leerTeclado = sc.nextLine();
	      try {
	        num = Integer.parseInt(leerTeclado);
	        salir = true;
	      }catch(NumberFormatException ex) {
	        System.err.printf("Escriba un numero: %s%n", ex.getLocalizedMessage());
	        er++;
	      }      
	    }while(!salir);
	        
	    return num;
	}
	
	public static int pedirNumero(String texto, int valorMin, int valorMax) throws ErroresMultiplesException {
	    int num = 0;
	    int er = 0;
	    boolean salir = false;
	    do {
	      if (er > 4) {
	        throw new ErroresMultiplesException();
	      }
	      sc = getScanner();
	      System.out.printf("%s entre %d y %d%n", texto, valorMin, valorMax);
	      String read = sc.nextLine();
	      try {
	        num = Integer.parseInt(read);
	        if(num < valorMin ||num > valorMax) {
	          throw new Invalideces();
	        }
	        salir = true;
	      }catch(NumberFormatException ex) {
	        System.err.printf("Escribe el numero que quieres: %s%n", ex.getLocalizedMessage());
	        er++;
	      }catch(Invalideces ex) {
	        System.err.printf("Escribe un numero entre : %s%n", ex.getLocalizedMessage());
	        er++;
	      }
	    }while(!salir);
	        
	    return num;
	  }
}
