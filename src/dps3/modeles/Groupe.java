package dps3.modeles;

import dps3.config.FetchJSON;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.json.JSONObject;



public class Groupe extends Modele {
	private String nomGroupe; 
	ArrayList<Vote> votes;
	int BudgetAlloue;
	
	public Groupe(String nom) {
		/*
		 * Arguments : 
		 * 		- nom une chaine de caracteres 
		 * Sortie (constructeur donc pas vraiment mais si): groupe 
		 * Contenu de la fonction : crée un groupe aléatoire avec un budget aléatoire, en donnant à ce groupe un nombre aléatoire de votes aléatoires
		 */
		nomGroupe = nom;
		Random rnd = new Random();
		BudgetAlloue = 1000 + rnd.nextInt(90001); //budget entre 1 000 et 100 000
		votes = creerListeVoteTest(4+rnd.nextInt(8)); //entre 4 et 11 votes dans le groupe	
	}

	public Groupe(String ng,int b,ArrayList<Vote> v) { /*Si l'on dispose déja d'une liste de votes, ce constructeur la prendra en charge*/
		/*
		 * Arguments : 
		 * 		- ng une chaine de caracteres qui contiendra le nom du groupe a creer
		 * 		- b un entier qui contient le budget du groupe à creer
		 * 		- v une liste de votes qui est la liste des votes du groupe à creer
		 * Sortie (constructeur donc pas vraiment mais si): groupe 
		 * Contenu de la fonction : crée un groupe a partir des données passées en paramètres
		 */
		nomGroupe = ng;
		BudgetAlloue=b;
		votes = new ArrayList<>();
		votes.addAll(v);
	}
	public Groupe(String ng,int b,Vote... lesVotes) {/*Ce constructeur prend autant de votes que voulu en parametre et crée l'objet groupe correspondant*/
		/*
		 * Arguments : 
		 * 		- ng une chaine de caracteres qui contiendra le nom du groupe a creer
		 * 		- b un entier qui contient le budget du groupe à creer
		 * 		- lesVotes qui est une liste contenant un nombre inconnu de votes passés en parametres qui seront les votes du groupe, la fonction peut avoir 45 arguments si elle a 43 votes par exemple
		 * Sortie (constructeur donc pas vraiment mais si): null 
		 * Contenu de la fonction : crée un groupe a partir des données passées en paramètres
		 */
		nomGroupe = ng;
		BudgetAlloue=b;
		votes = new ArrayList<>();
		for(Vote v : lesVotes) {
			votes.add(v);
		}
	}
	public Groupe(int idGroupe) {
		/*
		 * Arguments : 
		 * 		-idGroupe l'identifiant dans la BD du groupe qu'on veut importer dans l'application java
		 * Sortie (constructeur donc pas vraiment mais si): null 
		 * Contenu de la fonction : crée un groupe a partir des données de la base de données
		 */
		try {
			votes = new ArrayList<>();
			JSONObject g = new JSONObject();
			g = FetchJSON.recupJSONGroupe(idGroupe);
			List<Object> listeIdVotes = g.getJSONArray("votes").toList();
			for(int i=0;i<listeIdVotes.size();i++) {
				int patch  = (int)listeIdVotes.get(i);
				Vote v = new Vote(patch,1);
				votes.add(v);
			}
			nomGroupe = g.getString("nomGroupe");
			BudgetAlloue= g.getInt("budget");

		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public Groupe(Groupe g) { 
		/*
		 * Arguments : 
		 * 		- g un groupe dont on va copier les données
		 * Sortie (constructeur donc pas vraiment une sortie): un nouveau groupe 
		 * Contenu de la fonction : crée un groupe à partir d'un groupe passé en paramètres en copiant ses exactes données
		 */
	    this.votes = new ArrayList<>(); //Pour le constructeur de vote on faisait une copie avec directement la méthode de arraylist
	    for (Vote vote : g.votes) { //ici la méthode reprendrait les references vers les votes donc on y prefere recreer les votes
	        this.votes.add(new Vote(vote)); 
	    }
	    this.BudgetAlloue = g.BudgetAlloue;
	}
	

	
	public String getNomGroupe() {
		/*
		 * Arguments : null 
		 * Sortie : String -> le nom du groupe
		 * Contenu de la fonction : getter pour nomGroupe
		 */
		return nomGroupe;
	}
	
	public ArrayList<Vote> getListeVote(){
		/*
		 * Arguments : null 
		 * Sortie : ArrayList<Vote> -> la liste des votes du groupe
		 * Contenu de la fonction : getter pour votes
		 */
		return votes;
	}

	public static ArrayList<Vote> creerListeVoteTest(int nbVote){
		/*
		 * Arguments :
		 * 		- nbVote -> un entier qui représente le nombre de votes à creer
		 * Sortie : 
		 * 		- ArrayList<Vote> la liste de votes crée par la fonction
		 * Contenu de la fonction :
		 * 		- une boucle qui tourne nbVote fois et creer autant de votes aléatoires qu'elle fait de tour, en les ajoutant à la liste à renvoyer à chaque fois 
		 */
		ArrayList<Vote> liste = new ArrayList<>();
		for (int i=0;i<nbVote;i++) {
			liste.add(Vote.creerRandom());
		}
		return liste;
	}
	public void afficherGroupe() {
		/*
		 * Arguments :
		 * 		- null
		 * Sortie : 
		 * 		- null
		 * Contenu de la fonction :
		 * 		- affichage stylisé d'un groupe, exclusivement pour l'application console décideur
		 */
    	System.out.println("-----------------------------------");
    	System.out.println(this.getNomGroupe());
		for (int i=0; i <this.votes.size();i++) {
			System.out.println("---------- Vote "+(i+1)+" ----------");
			this.votes.get(i).afficherVote();
		}
		System.out.println("-----------------------------------");
		System.out.println("Budget : " + this.BudgetAlloue + " €");
		System.out.println("-----------------------------------");
	}
	
	
	
	public int getNbVotantsGagnant() {
		/*
		 * Arguments :  null
		 * Sortie : 
		 * 		-un entier représentant le nombre de votes que représente le vote gagnant d'un vote
		 * Contenu de la fonction : 
		 * 		-renvoie le nombre de votes satisfaits si l'on choisit l'option majoritaire a chaque vote, à noter que cela ne compte pas des personnes mais bien des votes
		 */
		int total=0;
		for (Vote v : votes) {
			total+=v.nbVotantsGagnant();
		}
		return total;
	}
	

	
}
