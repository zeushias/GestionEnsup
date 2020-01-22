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
public class Enseignant {

	// propriétés
	
	private int idEnseignant;
	private String nomEnseignant;
	private String prenomEnseignant;
	private String emailEnseignant;
	private String adresseEnseignant;
	private String telephoneEnseignant;
	private List<Cours> cours = new ArrayList<Cours>();

	// constructeur
	
	public Enseignant(int idEnseignant, String nomEnseignant, String prenomEnseignant, String emailEnseignant,
			String adresseEnseignant, String telephoneEnseignant) {
		super();
		this.idEnseignant = idEnseignant;
		this.nomEnseignant = nomEnseignant;
		this.prenomEnseignant = prenomEnseignant;
		this.emailEnseignant = emailEnseignant;
		this.adresseEnseignant = adresseEnseignant;
		this.telephoneEnseignant = telephoneEnseignant;
	}

	// getters et setters
	
	public int getIdEnseignant() {
		return idEnseignant;
	}

	

	public void setIdEnseignant(int idEnseignant) {
		this.idEnseignant = idEnseignant;
	}

	public String getNomEnseignant() {
		return nomEnseignant;
	}

	public void setNomEnseignant(String nomEnseignant) {
		this.nomEnseignant = nomEnseignant;
	}

	public String getPrenomEnseignant() {
		return prenomEnseignant;
	}

	public void setPrenomEnseignant(String prenomEnseignant) {
		this.prenomEnseignant = prenomEnseignant;
	}

	public String getEmailEnseignant() {
		return emailEnseignant;
	}

	public void setEmailEnseignant(String emailEnseignant) {
		this.emailEnseignant = emailEnseignant;
	}

	public String getAdresseEnseignant() {
		return adresseEnseignant;
	}

	public void setAdresseEnseignant(String adresseEnseignant) {
		this.adresseEnseignant = adresseEnseignant;
	}

	public String getTelephoneEnseignant() {
		return telephoneEnseignant;
	}

	public void setTelephoneEnseignant(String telephoneEnseignant) {
		this.telephoneEnseignant = telephoneEnseignant;
	}
	
	public List<Cours> getCours() {
		return cours;
	}

	public void setCours(List<Cours> cours) {
		this.cours = cours;
	}

	// tostring
	
	@Override
	public String toString() {
		return "Enseignant [idEnseignant=" + idEnseignant + ", nomEnseignant=" + nomEnseignant + ", prenomEnseignant="
				+ prenomEnseignant + ", emailEnseignant=" + emailEnseignant + ", adresseEnseignant=" + adresseEnseignant
				+ ", telephoneEnseignant=" + telephoneEnseignant + "]";
	}

}
