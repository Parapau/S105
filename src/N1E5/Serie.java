package N1E5;

import java.io.Serializable;

public class Serie implements Serializable {
	private String nom;
	private int puntuacio;
	public Serie(String nom, int puntuacio) {
		this.nom = nom;
		this.puntuacio = puntuacio;
	}
	public String getNom() {
		return nom;
	}
	public int getPuntuacio() { 
		return puntuacio;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPuntuacio(int puntuacio) {
		this.puntuacio = puntuacio;
	}
	
	@Override
	public String toString () {
		return "La serie es diu " + getNom() + " i per mi te un " + getPuntuacio();
		
 	}
	
	
}
