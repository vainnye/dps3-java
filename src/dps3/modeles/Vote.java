package dps3.modeles;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;

import dps3.config.FetchJSON;

public class Vote extends Modele {
	private ArrayList<Choix> lesChoix;
	private ArrayList<String> etiquettes;
	private String nomVote;
	private int idVote;
	private int totalVotant;
	private int estimBudget;
	private Choix choixGagnant;
	
	public Vote() {
		/*
		 * Arguments : null
		 * Sortie (c'est un constructeur donc pas vraiment une sortie mais ça fait quelque chose):
		 * 		-
		 * Contenu de la fonction : crée un vote vide
		 */
		lesChoix = new ArrayList<Choix>();
		etiquettes = new ArrayList<String>();
		totalVotant=0;
	}
    public Vote(Vote v) {
		/*
		 * Arguments :
		 * 		- v -> un vote dont on veut copier le contenu
		 * Sortie (c'est un constructeur donc pas vraiment une sortie mais ça fait quelque chose): 
		 * 		- un nouveau vote qui a les valeurs du vote passé en parametre 
		 * Contenu de la fonction : crée un vote a partir des valeurs du vote passé en paramètres
		 */
        this.lesChoix = new ArrayList<>(v.lesChoix);
        this.etiquettes = new ArrayList<>(v.etiquettes);
        this.totalVotant = v.totalVotant;
        this.estimBudget = v.estimBudget;
    }

    public Vote(int idVote, int idVotant) {
		/*
		 * Arguments : 
		 * 		- voir FetchJSON.recupJSONVote
		 * Sortie (c'est un constructeur donc pas vraiment une sortie mais ça fait quelque chose): 
		 * 		-un objet vote crée à partir des données de la base de données
		 * Contenu de la fonction : 
		 * 		- La fonction récupère l'objet JSON crée par la fonction interrogeant l'API et le transforme en un objet Vote java.
		 */
        try {
            // Récupération du JSON via l'API
            JSONObject j = FetchJSON.recupJSONVote(idVote, idVotant);
            
            // Remplir l'identifiant du vote
            this.nomVote = j.getString("titreVote");
            
            // Remplir l'estimation budgétaire
            if(j.get("evalBudget") == "null") {
            	this.estimBudget = -1;
            }else {
                this.estimBudget = j.getInt("evalBudget");
            }

            
            // Initialiser la liste des choix
            this.lesChoix = new ArrayList<>();
            JSONArray choixArray = j.getJSONArray("choixVote");
            int totalVotes = 0;
            
            
            for(int i=0;i<choixArray.length();i++) { //calculer le total des votes
            	JSONObject choixObj=choixArray.getJSONObject(i);
            	int nbVotes = choixObj.getInt("nbVote");
            	totalVotes += nbVotes;
            }
            // Remplir les choix
            for (int i = 0; i < choixArray.length(); i++) {
                JSONObject choixObj = choixArray.getJSONObject(i);
                String intitule = choixObj.getString("intitule");
                int nbVotes = choixObj.getInt("nbVote");
                

                double pourcentage = 0.0;
                if (totalVotes > 0) {
                    pourcentage = (nbVotes * 100.0) / totalVotes;
                }
                lesChoix.add(new Choix(intitule, pourcentage));
            }
            
            // Remplir le total des votants
            this.totalVotant = totalVotes;
            
            // Initialiser la liste des étiquettes
            this.etiquettes = new ArrayList<>();
            JSONArray etiquettesArray = j.getJSONArray("listeEtiquettes");
            for (int i = 0; i < etiquettesArray.length(); i++) {
                JSONObject etiquetteObj = etiquettesArray.getJSONObject(i);
                String label = etiquetteObj.getString("labelEtiquette");
                this.etiquettes.add(label);
            }
            
            // Déterminer le choix gagnant
            updateChoixGagnant();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public int getIdVote() {
    	return idVote;
    }
    
    //On ne va jamais modifier l'idVote, donc pas besoin de setter
    
    public int getEstimBudget() {
    	return estimBudget;
    }
    
    public void setEstimBudget(int value) {
    	estimBudget = value;
    }
    
    public String getNomVote() {
    	return nomVote;
    }
    
    public void setNomVote(String value) {
    	nomVote = value;
    }
    
    public int getTotalVotant() {
    	return totalVotant;
    }
    
    public void setTotalVotant(int value) {
    	totalVotant = value;
    }
    
    public Choix getChoixGagnant() {
    	return choixGagnant;
    }
    
    public void setChoixGagnant(Choix value) {
    	choixGagnant = value;
    }
    
    public ArrayList<Choix> getLesChoix(){
    	return lesChoix;
    }
    
    public void setLesChoix(ArrayList<Choix> listeChoix){
    	lesChoix = listeChoix;
    }
    
    public ArrayList<String> getListeEtiquette(){
    	return etiquettes;
    }
    
    public void setListeEtiquette(ArrayList<String> listeEtiquette){
    	etiquettes = listeEtiquette;
    }
    
    public void updateChoixGagnant() {
		/*
		 * Arguments : null
		 * Sortie : null
		 * Contenu de la fonction : met à jour un objet vote (this) en faisant en sorte que son choixGagnant devienne le choix qui a le plus de votes
		 */
    	Choix maxChoix = lesChoix.get(0);
    	for(Choix ch : lesChoix) {
    		if(ch.getPourcentage() > maxChoix.getPourcentage()) {
    			maxChoix = ch;
    		}
    		
    		choixGagnant = maxChoix;
    	}
    }
	
	public int nbVotantsGagnant()
	{
		/*
		 * Arguments : null 
		 * Sortie : null
		 * Contenu de la fonction : renvoie le nombre de votants (approximativement) que réprésente la proposition majoritaire
		 */
		return (int) ((totalVotant / 100.0) * Math.round(choixGagnant.getPourcentage()));
	}
	
    public static Vote creerRandom() {
		/*
		 * Arguments : 
		 * Sortie : 
		 * 		-un objet vote
		 * Contenu de la fonction : 
		 * 		-Crée un objet vote avec un budget, nombre de choix, et etiquettes aléatoires. 
		 *      -Cette fonction sert à creer des jeux de test
		 */
        Vote vote = new Vote();
        Random random = new Random();
        ArrayList<String> etiquettesPossibles = new ArrayList<>(Arrays.asList("Urgent","Information","Changement","Debat","Culture"));
        
        // Générer un nombre aléatoire de choix (entre 2 et 5 par exemple)
        int nombreDeChoix = 2 + random.nextInt(4);
        int nbEtiquettes = 1 + random.nextInt(3); // entre 1 et 3 etiquettes
        
        double totalPourcentage = 100.0;
        // Remplir lesChoix avec "a", "b", "c", ...
        for (int i = 0; i < nombreDeChoix; i++) {
        	double pourcentage;
            if (i == nombreDeChoix - 1) {
                // Assigner le reste au dernier choix pour garantir un total de 100%
                pourcentage = totalPourcentage;
            } else {
                pourcentage = Math.round(random.nextDouble() * totalPourcentage * 100.0) / 100.0;
                totalPourcentage -= pourcentage;
            }
            
            String nom = Character.toString((char) ('a' + i));
        	Choix c = new Choix(nom, pourcentage);
        	
            vote.lesChoix.add(c);
        }
    	int etiquetteChoisie = -1;
    	ArrayList<Integer> dejaChoisi = new ArrayList<>(Arrays.asList(-1)); //on met -1 dedans pour declencher le while directement
        for(int i =0;i<nbEtiquettes;i++) {
        	while(dejaChoisi.contains(etiquetteChoisie)) {
        		etiquetteChoisie = random.nextInt(5); //nombre entre 0 et 4 pour couvrir toutes les etiquettes de etiquettesPossibles
        	}
        	vote.etiquettes.add(etiquettesPossibles.get(etiquetteChoisie));
        	dejaChoisi.add(etiquetteChoisie);
        }

        // Générer des pourcentages aléatoires pour les choix

        vote.totalVotant = 10 + random.nextInt(491); //total de votant entre 10 et 500

        vote.estimBudget = 1000 + random.nextInt(9001); //budget entre 1000 et 10000
        
        vote.updateChoixGagnant();
        
        vote.nomVote="Vote de test";
        
        vote.idVote=-1; //idVote à -1 pour signaler que le vote n'appartient pas à la BD
        return vote;
    }
    
    public void afficherVote() {
		/*
		 * Arguments : null
		 * Sortie : null
		 * Contenu de la fonction : affiche un vote de maniere lisible pour un humain
		 */
        System.out.println("Vote Details:");
        System.out.println("Nom : "+nomVote);
        System.out.println("Total Votants: " + totalVotant);
        System.out.println("Estimation Budgetaire: " + estimBudget + " €");
        System.out.println("Etiquettes : ");
        for(int i =0;i<etiquettes.size();i++) {
        	System.out.println(etiquettes.get(i) + " ");
        }
        System.out.println("Choix et Pourcentages:");
        for (int i = 0; i < lesChoix.size(); i++) {
            System.out.println(lesChoix.get(i));
        }
    }
    
    public void updateBudget(int nvBudj) throws IOException {
		/*
		 * Arguments : 
		 * 		- nvBudj -> un entier qui correspond au budget que l'on veut appliquer à un vote
		 * Sortie : 
		 * 		- null 
		 * 		- peut throw une IOException si la requete API se passe mal
		 * Contenu de la fonction : 
		 * 		- change le budget du vote surlequel cette fonction est appelée en nvBudj, dans la base de données et dans l'objet vote
		 * 		- le fonctionnement des requetes HTML est similaire à celui dans la classe de l'api, avec la methode PUT au lieu de GET
		 */
    	if(idVote==-1) {
    		throw new IOException("Ce vote est généré aléatoirement, vous ne pouvez pas le modifier dans la BD");
    	}
        String baseUrl = "https://projets.iut-orsay.fr/saes3-vjacqu3/classePHP/rest/PUT.php";
        String urlString = baseUrl + "?table=Vote&idVote="+ this.idVote +"&evalBudget=" + nvBudj;
        /*idTemporaire apres on mettra -> */
        /*this.idVote à implémenter dans la classe mais pour l'instant l'api marche pas donc autant ne pas se faire chier*/; 
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        
        connection.setRequestMethod("PUT");  // Utilisation de la méthode PUT
        
        // Vérification du code de réponse HTTP pour du debug
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code : " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) {  // Vérification du code 200 OK
            System.out.println("Budget modifié !");
            this.estimBudget=nvBudj;
        } else {
            System.out.println("Échec de la modification du budget, code : " + responseCode);
        }
        
        connection.disconnect();
    }
	public static void main(String[] args) {
		Groupe g = new Groupe(1);
		g.afficherGroupe();
	}

}

