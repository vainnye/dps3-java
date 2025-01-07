package dps3.modeles;

public class Choix extends Modele{
	private String nom;
	private double pourcentage;
	
	public Choix(String nom, double pourcentage) {
		/*
		 * Arguments :
		 * 		- nom -> nom qu'on veut donner au nouvel objet
		 * 		- pourcentage -> pourcentage des votes qui sont pour le choix
		 * Sortie (c'est un constructeur donc pas vraiment une sortie mais ça fait quelque chose): 
		 * 		- un nouveau choix avec les valeurs passées en parametres
		 * Contenu de la fonction : crée un choix a partir des valeurs passées en paramètres
		 */
		this.nom = nom;
		this.pourcentage = pourcentage;
	}
	
	public String getNom(){
		/*
		 * getter de Nom
		 */
		return nom;
	}
	
	public double getPourcentage() {
		/*
		 * getter de Nom
		 */
		return pourcentage;
	}
	
	public String toString() {
		/*
		 * Arguements :
		 * 		-null
		 * Sortie : 
		 * 		- une chaine de caracteres
		 * Contenu de la fonction :
		 * 		- mets l'objet choix sous forme human readable 
		 * 
		 */
		return nom + " : " + pourcentage + "%";
	}
}
