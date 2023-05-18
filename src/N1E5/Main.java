package N1E5;

import java.io.IOException;

public class Main {
	public static void main (String args[]) {
		Serie serie = new Serie ("Andor", 10);
		Serie serieQueJaNoEsSerie = null;
		try {
			Seriealitzador.serielitzacio(serie, "C:\\Users\\formacio\\Desktop\\serie.ser");
			System.out.println("serialitzat, ara el deserialitzo");
			
			serieQueJaNoEsSerie = Seriealitzador.deserialitzacio("C:\\Users\\formacio\\Desktop\\serie.ser");
			System.out.println(serieQueJaNoEsSerie);
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e);
		}
		
	}
}
