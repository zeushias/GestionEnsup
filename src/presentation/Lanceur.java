/**
 * 
 */
package presentation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import metier.Ecole;
import metier.Etudiant;
import metier.Utilisateur;
import service.ServiceGestionEnsup;

/**
 * @author DANON Kodzo Ap�l�t�
 *
 */
public class Lanceur {

	static int compteur = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// mot de passe mysql
		saisirMotDePasseMySQL();

		// utilisateur
		System.out.println("--------------------------------------------------------------");
		Scanner sc = new Scanner(System.in);
		System.out.print("Avez vous un login et mot de passe O / N  : ");
		String reponse = sc.next().toUpperCase();
		if (reponse.equals("O")) {
			affichageRechercheUtilisateur();
			// r�cup�ration du chiffre saisie
			int saisie = saisieOperation();
			//
			operation(saisie);
		} else {
			affichageCreationUtilisateur();
			// r�cup�ration du chiffre saisie
			int saisie = saisieOperation();
			//
			operation(saisie);
		}
		// op�ration � faire
		// methodeARepetition();

	}

	/*
	 * mot de passe base de donn�e
	 */
	private static void saisirMotDePasseMySQL() {
		Scanner sc = new Scanner(System.in);
		System.out.println("--------------------------------------------------------------");
		System.out.print("Avez vous un mot de passe pour mysql O / N : ");
		String reponse = sc.next().toUpperCase();
		if (reponse.equals("O")) {
			System.out.println();
			System.out.print("Veuillez saisir le mot de passe de votre base mysql : ");
			System.out.println();
			ServiceGestionEnsup.password = sc.next();
		}
	}

	// affichageCreationUtilisateur
	private static void affichageCreationUtilisateur() {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.print("Cr�ation d'utilisateur : ");
		System.out.println();
		System.out.print("Veuillez saisir votre login utilisateur : ");
		System.out.println();
		String loginUser = sc.next();
		System.out.println();
		System.out.print("Veuillez saisir votre mot de passe utilisateur : ");
		System.out.println();
		String passwordUser = sc.next();
		System.out.println();
		System.out.print("Veuillez saisir votre profil utilisateur D pour Directeur R pour REsponsable �tude : ");
		System.out.println();
		String profilUser = sc.next().toUpperCase();
		Utilisateur utilisateur = new Utilisateur(loginUser, passwordUser, profilUser);
		ServiceGestionEnsup.creerUtilisateur(utilisateur);
	}

	// affichageRechercheUtilisateur
	private static void affichageRechercheUtilisateur() {

		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.print("Veuillez saisir votre login utilisateur : ");
		System.out.println();
		String loginUser = sc.next();
		System.out.println();
		System.out.print("Veuillez saisir votre mot de passe utilisateur : ");
		System.out.println();
		String passwordUser = sc.next();

		Utilisateur utilisateur = new Utilisateur(loginUser, passwordUser, null);
		Utilisateur u = ServiceGestionEnsup.selectionUtilisateur(utilisateur);
		if (u != null) {
			if (u.getProfil().equals("R")) {
				// affichage resonsable
				affichageResponsable();
			} else {
				// affichage directeur
				affichageDirecteur();
			}
		} else {
			compteur++;
			affichageRechercheUtilisateur();
		}

	}

	// affichage responsable
	private static void affichageResponsable() {
		Scanner scan = new Scanner(System.in);

		// affichage basique
		System.out.println("--------------------------------------------------------------");
		System.out.println("Pour ins�rer un �tudiant tapez 1");
		System.out.println("Pour lister les �tudiants tapez 2");
		System.out.println("Pour supprimer un �tudiant tapez 3");
		System.out.println("Pour modifier le nom d'un �tudiant tapez 4");
		System.out.println("Pour associer une �cole � un �tudiant tapez 5");
		System.out.println("--------------------------------------------------------------");
		//
		System.out.print("Saisir un chiffre : ");

	}

	// affichage responsable
	private static void affichageDirecteur() {
		Scanner scan = new Scanner(System.in);

		// affichage basique
		System.out.println("--------------------------------------------------------------");
		System.out.println("Pour lister les �tudiants tapez 6");
		System.out.println("--------------------------------------------------------------");
		//
		System.out.print("Saisir un chiffre : ");

	}

	// saisir une num�ro qui correspond � une op�ration
	private static Integer saisieOperation() {
		//
		Scanner scan = new Scanner(System.in);
		int saisie = scan.nextInt();
		return saisie;
	}

	private static void methodeARepetition() {

	}

	/*
	 * demander si l'utilisateur veut poursuivre les op�rations
	 */
	private static void continuerOperation() {

		Scanner sc = new Scanner(System.in);
		System.out.print("Voulez-vous continuer? O / N : ");
		System.out.println();
		String reponse = sc.next().toUpperCase();
		//
		switch (reponse) {

		case "O":
			// recommencer
			methodeARepetition();
			break;
		case "N":
			// finir le programme
			System.out.println("Au revoir !!!");
			break;
		default:
			// reposer la question
			System.out.println("Mauvaise reponse");
			continuerOperation();
			break;
		}
	}

	private static void operation(int chiffre) {
		Scanner scan = new Scanner(System.in);
		switch (chiffre) {
		case 1:
			// enr�gistrer une �cole
			System.out.println();
			System.out.println("--------------------------------------------------------------");
			System.out.print("entrer le nom de l'�tudiant : ");
			String nomEtudiant = scan.next();
			System.out.println();
			System.out.print("entrer le prenom de l'�tudiant : ");
			String prenomEtudiant = scan.next();
			System.out.println();
			System.out.print("entrer l'email de l'�tudiant : ");
			String emailEtudaint = scan.next();
			System.out.println();
			System.out.print("entrer l'adresse de l'�cole : ");
			String adresseEtudiant = scan.next();
			System.out.println();
			System.out.print("entrer le t�l�phone de l'�tudiant : ");
			String telephoneEtudiant = scan.next();
			System.out.println();
			System.out.print("entrer la date de naissance de l'�tudiant : ");
			String dateNaissance = scan.next();
			System.out.println();

			Etudiant etudiant = new Etudiant(nomEtudiant, prenomEtudiant, emailEtudaint, adresseEtudiant,
					telephoneEtudiant, new Date());
			ServiceGestionEnsup.creerEtudiant(etudiant);

			break;
		case 2:

			break;

		case 3:

			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			// lister les �tudiants
			System.out.println();
			System.out.println("La liste des �tudiants");
			ServiceGestionEnsup.lireEtudiant();

			break;
		default:
			break;
		}
	}
}
