package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import metier.Ecole;
import metier.Etudiant;
import metier.Utilisateur;

/**
 * @author DANON Kodzo Apélété
 *
 */

public class ServiceGestionEnsup {

	public static String password = "";
	
	/**
	 * 
	 * @param utilisateur les informations sur l'utilisateur
	 */
	public static void creerUtilisateur(Utilisateur utilisateur) {
		// information de la base de donnee

				String url = "jdbc:mysql://localhost/gestionensup";
				String login = "root";

				Connection cn = null;
				Statement st = null;

				try {
					// etape1 chargement du driver

					Class.forName("com.mysql.jdbc.Driver");

					// etape2 recupertion de la connnexion

					cn = DriverManager.getConnection(url, login, password);

					// etape 3 creation du statement
					st = cn.createStatement();
					String sql = "INSERT INTO `utilisateur` (`login`,`password`, `profil`) "
							+ "VALUES ('" + utilisateur.getLogin() + "','"+ utilisateur.getPassword() + "', '"
							+ utilisateur.getProfil()+"')";

					// etape 4 executer la requette
					st.executeUpdate(sql);
					System.out.println("Utilisateur enrégistré avec succès !!!! ");

				} catch (SQLException e) {

					e.printStackTrace();
				} catch (ClassNotFoundException e) {

					e.printStackTrace();
				} finally {

					// etape 5 liberer les ressources
					try {
						cn.close();
						st.close();
					} catch (SQLException e) {

						e.printStackTrace();
					}
				}
	}
	
	/**
	 * 
	 * @param ecole les informations sur l'école
	 */
	public static void creerEcole(Ecole ecole) {

		// information de la base de donnee

		String url = "jdbc:mysql://localhost/gestionensup";
		String login = "root";

		Connection cn = null;
		Statement st = null;

		try {
			// etape1 chargement du driver

			Class.forName("com.mysql.jdbc.Driver");

			// etape2 recupertion de la connnexion

			cn = DriverManager.getConnection(url, login, password);

			// etape 3 creation du statement
			st = cn.createStatement();
			String sql = "INSERT INTO `ecole` (`nomEcole`,`emailEcole`, `adresseEcole`,`telephoneEcole`, `telephoneEcole`) "
					+ "VALUES ('" + ecole.getNomEcole() + "','"+ ecole.getEmailEcole() + "', '"
					+ ecole.getAdresseEcole()+"', '"+ecole.getTelephoneEcole()+"', '"+ecole.getDirecteur()+"')";

			// etape 4 executer la requette
			st.executeUpdate(sql);
			System.out.println("Ecole enrégistré avec succès !!!! ");

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} finally {

			// etape 5 liberer les ressources
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}
	
	/**
	 *  liste des étudiants
	 */
	public static void lireEtudiant() {

		// information de la base de donnee

		String url = "jdbc:mysql://localhost/gestionensup";
		String login = "root";

		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			// etape1 chargement du driver

			Class.forName("com.mysql.jdbc.Driver");

			// etape2 recupertion de la connnexion

			cn = DriverManager.getConnection(url, login, password);

			// etape 3 creation du statement
			st = cn.createStatement();
			String sql = "select * from etudiant";

			// etape 4 executer la requette
			System.out.println("Liste des etudiants ");
			rs = st.executeQuery(sql);

			// etape5 parcours du resultSet
			while (rs.next()) {
				System.out.println(rs.getInt("idEtudiant"));
				System.out.println(" ");
				System.out.print(rs.getString("nomEtudiant"));
				System.out.print(" ");
				System.out.println(rs.getString("prenomEtudiant"));
				System.out.print(" ");
				System.out.println(rs.getString("emailEtudiant"));
				System.out.print(" ");
				System.out.println(rs.getString("adresseEtudiant"));
				System.out.print(" ");
				System.out.println(rs.getString("telephoneEtudiant"));
				System.out.print(" ");
				System.out.println(rs.getString("dateNaissanceEtudiant"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} finally {

			// etape 5 liberer les ressources
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}
	
	public static Utilisateur selectionUtilisateur(Utilisateur utilisateur) {
		
		// information de la base de donnee

		String url = "jdbc:mysql://localhost/gestionensup";
		String login = "root";

		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		Utilisateur user = null;
		try {
			// etape1 chargement du driver

			Class.forName("com.mysql.jdbc.Driver");

			// etape2 recupertion de la connnexion

			cn = DriverManager.getConnection(url, login, password);

			// etape 3 creation du statement
			st = cn.createStatement();
			String sql = "select * from utilisateur where `login` =  '" + utilisateur.getLogin() + "' and "
					+ "`password` = '" + utilisateur.getPassword() + "'";

			// etape 4 executer la requette
			rs = st.executeQuery(sql);

			// etape5 parcours du resultSet
			while (rs.next()) {
				user = new Utilisateur (rs.getInt("idUser"), 
						rs.getString("login"), 
						rs.getString("password"), 
						rs.getString("profil")
						);
			}

		} catch (SQLException e) {
			System.out.println("L'utilisateur n'existe pas");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} finally {

			// etape 5 liberer les ressources
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return user;
	}
	
	//update de étudiant
		public static void updateEtudiant(String ancienNom, String nouveauNom) {
			// information de la base de donnee

			String url = "jdbc:mysql://localhost/gestionensup";
			String login = "root";

			Connection cn = null;
			Statement st = null;

			try {
				// etape1 chargement du driver

				Class.forName("com.mysql.jdbc.Driver");

				// etape2 recupertion de la connnexion

				cn = DriverManager.getConnection(url, login, password);

				// etape 3 creation du statement
				st = cn.createStatement();
				String sql = "update etudiant set nom = '" + nouveauNom + "' where nom = '" + ancienNom + "'";

				// etape 4 executer la requette

				int rs = st.executeUpdate(sql);
				System.out.println("modification du nom de l'étudiant éffectuée avec succès");

			} catch (SQLException e) {
				System.out.println("Le nom n'existe pas");
				e.printStackTrace();
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			} finally {

				// etape 5 liberer les ressources
				try {
					cn.close();
					st.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}

		}

		public static void deleteEtudiant(String nom) {

			// information de la base de donnee

			String url = "jdbc:mysql://localhost/gestionensup";
			String login = "root";

			Connection cn = null;
			Statement st = null;
			ResultSet rs = null;

			try {
				// etape1 chargement du driver

				Class.forName("com.mysql.jdbc.Driver");

				// etape2 recupertion de la connnexion

				cn = DriverManager.getConnection(url, login, password);

				// etape 3 creation du statement
				st = cn.createStatement();
				String sql = "delete from `etudiant` where `nom` = '" + nom + "'";
				// etape 4 executer la requette
				st.executeUpdate(sql);

				// etape5 parcours du resultSet
				System.out.println("Suppression éffectuée avec succès");

			} catch (SQLException e) {

				e.printStackTrace();
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			} finally {

				// etape 5 liberer les ressources
				try {
					cn.close();
					st.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}
		
		public static void creerEtudiant(Etudiant etudiant) {

			// information de la base de donnee

			String url = "jdbc:mysql://localhost/gestionensup";
			String login = "root";

			Connection cn = null;
			Statement st = null;

			try {
				// etape1 chargement du driver

				Class.forName("com.mysql.jdbc.Driver");

				// etape2 recupertion de la connnexion

				cn = DriverManager.getConnection(url, login, password);

				// etape 3 creation du statement
				st = cn.createStatement();
				String sql = "INSERT INTO `etudiant` (`nomEtudiant`, `prenomEtudiant`,`emailEtudiant`, "
						+ "`adresseEtudiant`,`telephoneEtudiant`) "
						+ "VALUES ('" + etudiant.getNomEtudiant() + "','"+ etudiant.getPrenomEtudiant() + "', '"
						+ etudiant.getEmailEtudiant()+"', '"+etudiant.getAdresseEtudiant()+"', '"+etudiant.getTelephoneEtudiant() +"')";

				// etape 4 executer la requette
				st.executeUpdate(sql);
				System.out.println("Etudiant enrégistré avec succès !!!! ");

			} catch (SQLException e) {

				e.printStackTrace();
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			} finally {

				// etape 5 liberer les ressources
				try {
					cn.close();
					st.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}
		

}
