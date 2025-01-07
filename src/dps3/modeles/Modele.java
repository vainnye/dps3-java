package dps3.modeles;

import java.security.InvalidParameterException;

import dps3.controleurs.Controleur;
import dps3.modeles.interfaces.IModele;

public class Modele implements IModele {
    protected Controleur controleur;
    
    
    // cette méthode est inutile toute seule car il n'est pas possible de créer un controleur depuis une autre classe qu'un controleur (en passant par le constructeur)
    // car le constructeur de Controleur est protected
    // cette méthode fonctionne de pair avec IControleurModele.getOrCreateFrom(Modele modele)
    // TLDR: pour comprendre son utilité allez voir IControleurModele.getOrCreateFrom(Modele modele)
    @SuppressWarnings("unchecked")
    public static <TC extends Controleur> TC setOrGet(TC ctl) {
        if(ctl.getClass() == Controleur.class)
            throw new InvalidParameterException("Les instances directes de Controleur ne sont pas acceptées en paramètre");

        if(ctl.getModele().controleur == null)
            return ctl;
        else
            return (TC) ctl.getModele().controleur;
    }
}
