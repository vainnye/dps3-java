package dps3.modeles;

import dps3.modeles.interfaces.IModele;

public class Groupe implements IModele {
	private String nomGroupe; 
	// ArrayList<Vote> votes;
	int BudgetAlloue;
	
	public Groupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}

	// public Groupe() {
	// 	Random rnd = new Random();
	// 	BudgetAlloue = 1000 + rnd.nextInt(90001); //budget entre 1 000 et 100 000
	// 	votes = creerListeVoteTest(4+rnd.nextInt(8)); //entre 4 et 11 votes dans le groupe	
	// }

	public String getNomGroupe() {
		return nomGroupe;
	}

	// public Groupe(Groupe g) { 
	// /*
	//  * On definit un constructeur copiant les données d'un objet vote pour éviter les problemes de références dans la récursion
	//  */
	//     this.votes = new ArrayList<>(); //Pour le constructeur de vote on faisait une copie avec directement la méthode de arraylist
	//     for (Vote vote : g.votes) { //ici la méthode reprendrait les references vers les votes donc on y prefere recreer les votes
	//         this.votes.add(new Vote(vote)); 
	//     }
	//     this.BudgetAlloue = g.BudgetAlloue;
	// }
	
	// public ArrayList<Vote> getListeVote(){
	// 	return votes;
	// }

	// public static ArrayList<Vote> creerListeVoteTest(int nbVote){
	// 	ArrayList<Vote> liste = new ArrayList<>();
	// 	for (int i=0;i<nbVote;i++) {
	// 		liste.add(Vote.creerRandom());
	// 	}
	// 	return liste;
	// }
	
	
	
	// public int getNbVotantsGagnant() { //renvoie le nombre de votes satisfaits si l'on choisit l'option majoritaire a chaque vote, à noter que cela ne compte pas des personnes mais bien des votes
	// 	/*
	// 	 * Commentaire pour mes camarades dev et meme pour moi (s'il est encore la pendant la présentation c'est un peu gênant)
	// 	 * si on veut gerer des algos d'opti sur des utilisateurs specifiques/si on veut satisfaire chaque utilisateur au lieu de satisfaires des votes
	// 	 *  (ce qui politiquement n'est pas l'idée du siecle je pense) vu qu'on a pas de requetes sql : 
	// 	 *  -on prend tous les utilisateurs
	// 	 *  -on prend tous les membres
	// 	 *  -pour le groupe concerné on dégage de la liste tous les utilisateurs qui ne sont pas membre de notre groupe
	// 	 *  -on prend nos choixVote du groupe
	// 	 *  -on degage de la liste chaque utilisateur qui n'a aucune occurence ou que des occurences de vote null (blanc) dans choixVote
	// 	 *  -enfin la on a une liste de tous les membres qui ont vote au moins une fois pour une option
	// 	 *  -dans notre algo faudra verifier a chaque fois si dans un vote y'a qqn qui a pas encore été satisfait et "cocher" la case de la personne qd c bon
	// 	 *  -ça sera tres couteux donc des trucs comme ça c'est du glouton je pense bien
	// 	 *  
	// 	 */
	// 	int total=0;
	// 	for (Vote v : votes) {
	// 		total+=v.nbVotantsGagnant();
	// 	}
	// 	return total;
	// }
	

	
}
