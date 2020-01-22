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
 * @author DANON Kodzo Apélété
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
			// récupération du chiffre saisie
			int saisie = saisieOperation();
			//
			operation(saisie);
		} else {
			affichageCreationUtilisateur();
			// récupération du chiffre saisie
			int saisie = saisieOperation();
			//
			operation(saisie);
		}
		// opération à faire
		// methodeARepetition();

	}

	/*
	 * mot de passe base de donnée
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
		System.out.print("Création d'utilisateur : ");
		System.out.println();
		System.out.print("Veuillez saisir votre login utilisateur : ");
		System.out.println();
		String loginUser = sc.next();
		System.out.println();
		System.out.print("Veuillez saisir votre mot de passe utilisateur : ");
		System.out.println();
		String passwordUser = sc.next();
		System.out.println();
		System.out.print("Veuillez saisir votre profil utilisateur D pour Directeur R pour REsponsable étude : ");
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
		System.out.println("Pour insérer un étudiant tapez 1");
		System.out.println("Pour lister les étudiants tapez 2");
		System.out.println("Pour supprimer un étudiant tapez 3");
		System.out.println("Pour modifier le nom d'un étudiant tapez 4");
		System.out.println("Pour associer une école à un étudiant tapez 5");
		System.out.println("--------------------------------------------------------------");
		//
		System.out.print("Saisir un chiffre : ");

	}

	// affichage responsable
	private static void affichageDirecteur() {
		Scanner scan = new Scanner(System.in);

		// affichage basique
		System.out.println("--------------------------------------------------------------");
		System.out.println("Pour lister les étudiants tapez 6");
		System.out.println("--------------------------------------------------------------");
		//
		System.out.print("Saisir un chiffre : ");

	}

	// saisir une numéro qui correspond à une opération
	private static Integer saisieOperation() {
		//
		Scanner scan = new Scanner(System.in);
		int saisie = scan.nextInt();
		return saisie;
	}

	private static void methodeARepetition() {

	}

	/*
	 * demander si l'utilisateur veut poursuivre les opérations
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
			// enrégistrer une école
			System.out.println();
			System.out.println("--------------------------------------------------------------");
			System.out.print("entrer le nom de l'étudiant : ");
			String nomEtudiant = scan.next();
			System.out.println();
			System.out.print("entrer le prenom de l'étudiant : ");
			String prenomEtudiant = scan.next();
			System.out.println();
			System.out.print("entrer l'email de l'étudiant : ");
			String emailEtudaint = scan.next();
			System.out.println();
			System.out.print("entrer l'adresse de l'école : ");
			String adresseEtudiant = scan.next();
			System.out.println();
			System.out.print("entrer le téléphone de l'étudiant : ");
			String telephoneEtudiant = scan.next();
			System.out.println();
			System.out.print("entrer la date de naissance de l'étudiant : ");
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
			break;
		default:
			break;
		}
	}
	}
