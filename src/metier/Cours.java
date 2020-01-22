/**
 * 
 */
package metier;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DANON Kodzo Apélété
 *
 */
public class Cours {

	// propriétés

	private String themeCours;
	private int nombreHeure;
	private List<Etudiant> etudiants = new ArrayList<Etudiant>();

	// constructeur

	public Cours(String themeCours, int nombreHeure) {
		super();
		this.themeCours = themeCours;
		this.nombreHeure = nombreHeure;
	}

	// getters et setters

	public String getThemeCours() {
		return themeCours;
	}

	public void setThemeCours(String themeCours) {
		this.themeCours = themeCours;
	}

	public int getNombreHeure() {
		return nombreHeure;
	}

	public void setNombreHeure(int nombreHeure) {
		this.nombreHeure = nombreHeure;
	}

	public List<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	// tostring

	@Override
	public String toString() {
		return "Cours [themeCours=" + themeCours + ", nombreHeure=" + nombreHeure + "]";
	}

}
