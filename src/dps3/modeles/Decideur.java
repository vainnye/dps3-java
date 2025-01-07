package dps3.modeles;

import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.CDATASection;

import dps3.App;
import dps3.controleurs.CDecideur;
import dps3.controleurs.interfaces.IControleur;
import dps3.modeles.interfaces.IModele;

// la classe du décideur (l'utilisateur courant de l'app)
// 
public class Decideur extends Modele {
    public static final String DFT_PFP_PATH = App.DFT_PFP_PATH;
    private int idUtilisateur;
    private String pseudo;
    private String nom;
    private String prenom;
    private URL lienPhotoProfil; 

    // tous les groupes dont le décideur est décideur
    private ArrayList<Groupe> groupesDeDecision;

    // Constructeur pour debugger
    public Decideur(String lienPhotoProfil, ArrayList<Groupe> grps) {
        setLienPhotoProfil(lienPhotoProfil);
        groupesDeDecision = grps;
    }
    
    
    public static Decideur createDecideur() {
        Decideur decideur = new Decideur();
        
        // TODO : empêcher la connexion de l'utilisateur à l'app s'il n'est décideur d'aucun des groupes dont il est membre 
        // TODO : fetch les données JSON dans les attributs de Decideur
        String lienPhotoProfil; // lien récuéré via l'API REST
        setLienPhotoProfil(lienPhotoProfil);
        
        // decideur.idUtilisateur = 
        // decideur.pseudo = 
        // decideur.nom = 
        // decideur.prenom = 
        // decideur.lienPhotoProfil = 
        
        // TODO : créer un objet Groupe pour chaque groupe dont le Decideur est décisionnaire et l'ajouter à groupeDeDecision
        
        // decideur.groupesDeDecision =
        // return decideur;
    }
    
    public void setLienPhotoProfil(String lienPhotoProfil) {
        // "String lienPhotoProfil" lien récupéré via l'API REST
        try {
            this.lienPhotoProfil = new URI(lienPhotoProfil).toURL();
        }
        catch (MalformedURLException | URISyntaxException e) {
            this.lienPhotoProfil = null;
        }
    }
    
    public URL getLienPhotoProfil() {
        return lienPhotoProfil;
    }
    
    public ArrayList<Groupe> getGroupesDeDecision() {
        return groupesDeDecision;
    }
}
