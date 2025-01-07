package dps3.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject; 


public class FetchJSON {
	
	public static int loginDecideur(String identifiant,String pass) throws IOException{
		/*
		 * Arguments : 
		 * 		- idVote -> id du vote dont on veut les informations 
		 * 		- idVotant -> id de la personne dont on veut le vote, ne sevira pas ici mais est necessaire à l'api
		 * 		- idGroupe -> id du groupe dans lequel le vote est crée
		 * Sortie : 
		 * 		- un objet JSON qui contient toutes les informations liées au vote
		 * Contenu de la fonction : 
		 * 		- la fonction établit une connexion avec le serveur,envoie la requete Get, vérifie que le code de retour est le bon, puis convertit le contenu
		 * 			obtenu en JSON et renvoie cet objet
		 */
		JSONObject jsonVoulu = null;
		int reponse =-1;
        String baseUrl = "https://projets.iut-orsay.fr/saes3-vjacqu3/classePHP/rest/APILogin.php?login_utilisateur="+identifiant+"&password_utilisateur=";
        String urlString = baseUrl + pass; 
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        //Vérifier le code de réponse HTTP pour du debug
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code for request " + responseCode); 
        
        //lire la réponse en s'assurant que le code est le bon
        if (responseCode == HttpURLConnection.HTTP_OK) {  // on verifie que le code renvoie un ok
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            // Convertir la réponse en JSON
            String strReponse = response.toString();
            reponse = Integer.parseInt(strReponse);
        }else {
        	throw new IOException("Login ou mot de passe incorrect");
        }
        connection.disconnect();
		return reponse;
		
	}
	
	public static JSONObject recupJSONVote(int idVote,int idVotant) throws IOException {
		/*
		 * Arguments : 
		 * 		- idVote -> id du vote dont on veut les informations 
		 * 		- idVotant -> id de la personne dont on veut le vote, optionnel au niveau api
		 * Sortie : 
		 * 		- un objet JSON qui contient toutes les informations liées au vote
		 * Contenu de la fonction : 
		 * 		- la fonction établit une connexion avec le serveur,envoie la requete Get, vérifie que le code de retour est le bon, puis convertit le contenu
		 * 			obtenu en JSON et renvoie cet objet
		 */
		JSONObject jsonVoulu = null;
        String baseUrl = "https://projets.iut-orsay.fr/saes3-vjacqu3/classePHP/rest/GET.php?classe=vote&id=";
        String urlString = baseUrl + idVote; 
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        //Vérifier le code de réponse HTTP pour du debug
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code for ID " + idVote + ": " + responseCode); 
        
        //lire la réponse en s'assurant que le code est le bon
        if (responseCode == HttpURLConnection.HTTP_OK) {  // on verifie que le code renvoie un ok
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            // Convertir la réponse en JSON
            String jsonResponse = response.toString();
            // Analyser la réponse JSON
            JSONObject jsonObject = new JSONObject(jsonResponse);
            jsonVoulu = jsonObject;

        }
        connection.disconnect();
		return jsonVoulu;
		
	}
	public static JSONObject recupJSONGroupe(int idGroupe) throws IOException {
		/*
		 * Arguments : 
		 * 		- idVote -> id du vote dont on veut les informations 
		 * 		- idVotant -> id de la personne dont on veut le vote, optionnel au niveau api
		 * Sortie : 
		 * 		- un objet JSON qui contient toutes les informations liées au vote
		 * Contenu de la fonction : 
		 * 		- la fonction établit une connexion avec le serveur,envoie la requete Get, vérifie que le code de retour est le bon, puis convertit le contenu
		 * 			obtenu en JSON et renvoie cet objet
		 */
		JSONObject jsonVoulu = null;
        String baseUrl = "https://projets.iut-orsay.fr/saes3-vjacqu3/classePHP/rest/GET.php?classe=groupe&id="+idGroupe+"&votes=1";
        String urlString = baseUrl; 
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        //Vérifier le code de réponse HTTP pour du debug
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code for groupe : " + responseCode); 
        
        //lire la réponse en s'assurant que le code est le bon
        if (responseCode == HttpURLConnection.HTTP_OK) {  // on verifie que le code renvoie un ok
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            // Convertir la réponse en JSON
            String jsonResponse = response.toString();

            // Analyser la réponse JSON
            JSONObject jsonObject = new JSONObject(jsonResponse);
            jsonVoulu = jsonObject;
        }
        connection.disconnect();
		return jsonVoulu;
		
	}
	public static JSONObject recupJSONUtilisateur(int idUser) throws IOException {
		/*
		 * Arguments : 
		 * 		- idUser -> l'id de l'utilisateur dont on veut les informations
		 * Sortie : 
		 * 		- un objet JSON contenant les informations de l'utililsateur
		 * Contenu de la fonction : 
		 * 		- voir description de recupJSONVote
		 */
		JSONObject jsonVoulu = null;
        String baseUrl = "https://projets.iut-orsay.fr/saes3-vjacqu3/classePHP/rest/GET.php?classe=utilisateur&id=";
        String urlString = baseUrl + idUser; 
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        //Vérifier le code de réponse HTTP pour du debug
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code for ID " + idUser + ": " + responseCode); 
        
        //lire la réponse en s'assurant que le code est le bon
        if (responseCode == HttpURLConnection.HTTP_OK) {  // on verifie que le code renvoie un ok
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            // Convertir la réponse en JSON
            String jsonResponse = response.toString();

            // Analyser la réponse JSON
            JSONObject jsonObject = new JSONObject(jsonResponse);
            jsonVoulu = jsonObject;
        }
        connection.disconnect();
		return jsonVoulu;
		
	}
	public static void main(String[] args) {
		try {
			int idUser = loginDecideur("remib", "remi");
			JSONObject j = recupJSONUtilisateur(idUser);
			System.out.println("idutilisateur :" + j.getInt("idUtilisateur")); 
			System.out.println("pseudo : " + j.getString("pseudo"));
			System.out.println("nom : "+j.getString("nom"));
			System.out.println("prenom : "+j.getString("prenom"));
			System.out.println("lienpfp : "+j.getString("lienPhotoProfil"));
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}

	}
}

