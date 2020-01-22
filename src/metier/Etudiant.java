/**
 * 
 */
package metier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author DANON Kodzo Apélété
 *
 */
public class Etudiant {

	// propriétés

	private int idEtudiant;
	private String nomEtudiant;
	private String prenomEtudiant;
	private String emailEtudiant;
	private String adresseEtudiant;
	private String telephoneEtudiant;
	private Date dateNaissanceEtudiant;
	private List<Cours> cours = new ArrayList<Cours>();

	// constructeur

	public Etudiant(int idEtudiant, String nomEtudiant, String prenomEtudiant, String emailEtudiant,
			String adresseEtudiant, String telephoneEtudiant, Date dateNaissanceEtudiant) {
		super();
		this.idEtudiant = idEtudiant;
		this.nomEtudiant = nomEtudiant;
		this.prenomEtudiant = prenomEtudiant;
		this.emailEtudiant = emailEtudiant;
		this.adresseEtudiant = adresseEtudiant;
		this.telephoneEtudiant = telephoneEtudiant;
		this.dateNaissanceEtudiant = dateNaissanceEtudiant;
	}

	public Etudiant(String nomEtudiant, String prenomEtudiant, String emailEtudiant, String adresseEtudiant,
			String telephoneEtudiant, Date dateNaissanceEtudiant) {
		super();
		this.nomEtudiant = nomEtudiant;
		this.prenomEtudiant = prenomEtudiant;
		this.emailEtudiant = emailEtudiant;
		this.adresseEtudiant = adresseEtudiant;
		this.telephoneEtudiant = telephoneEtudiant;
		this.dateNaissanceEtudiant = dateNaissanceEtudiant;
	}



	// getters et setters

	public int getIdEtudiant() {
		return idEtudiant;
	}

	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
	}

	public String getNomEtudiant() {
		return nomEtudiant;
	}

	public void setNomEtudiant(String nomEtudiant) {
		this.nomEtudiant = nomEtudiant;
	}

	public String getPrenomEtudiant() {
		return prenomEtudiant;
	}

	public void setPrenomEtudiant(String prenomEtudiant) {
		this.prenomEtudiant = prenomEtudiant;
	}

	public String getEmailEtudiant() {
		return emailEtudiant;
	}

	public void setEmailEtudiant(String emailEtudiant) {
		this.emailEtudiant = emailEtudiant;
	}

	public String getAdresseEtudiant() {
		return adresseEtudiant;
	}

	public void setAdresseEtudiant(String adresseEtudiant) {
		this.adresseEtudiant = adresseEtudiant;
	}

	public String getTelephoneEtudiant() {
		return telephoneEtudiant;
	}

	public void setTelephoneEtudiant(String telephoneEtudiant) {
		this.telephoneEtudiant = telephoneEtudiant;
	}

	public Date getDateNaissanceEtudiant() {
		return dateNaissanceEtudiant;
	}

	public void setDateNaissanceEtudiant(Date dateNaissanceEtudiant) {
		this.dateNaissanceEtudiant = dateNaissanceEtudiant;
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
		return "Etudiant [idEtudiant=" + idEtudiant + ", nomEtudiant=" + nomEtudiant + ", prenomEtudiant="
				+ prenomEtudiant + ", emailEtudiant=" + emailEtudiant + ", adresseEtudiant=" + adresseEtudiant
				+ ", telephoneEtudiant=" + telephoneEtudiant + ", dateNaissanceEtudiant=" + dateNaissanceEtudiant + "]";
	}

}
