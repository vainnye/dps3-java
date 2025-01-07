package dps3.controleurs;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import javax.swing.JComponent;

import dps3.controleurs.interfaces.IControleur;
import dps3.modeles.Decideur;
import dps3.modeles.Groupe;
import dps3.modeles.Modele;
import dps3.modeles.Vote;
import dps3.vues.interfaces.IVueControlee;

public class Controleur implements IControleur {    
    protected Modele modele;
    protected ArrayList<IVueControlee> vues;
  
    
    // le but de cet méthode est de s'assurer de la cohérence du lien 1:1 entre le modele et le controleur
    // c'est le seul moyen de créer un controleur
    // si le modele a déjà un controleur, elle renverra le controlleur actuel
    @SuppressWarnings("unchecked")
    public static <TM extends Modele, TC extends Controleur> TC getOrCreateFrom(TM modele) {
        // cette méthode accepte toutes les classes filles de Modele sauf Modele en entrée
        if(modele.getClass() == Modele.class)
            throw new InvalidParameterException("Les instances directes de Modele ne sont pas acceptées en paramètre");
        

        if(modele instanceof Decideur)
            return (TC) Modele.setOrGet(new CDecideur((Decideur)modele));
        if(modele instanceof Groupe)
            return (TC) Modele.setOrGet(new CGroupe((Groupe)modele));
        if(modele instanceof Vote)
            return (TC) Modele.setOrGet(new CVote((Vote)modele));
        throw new InvalidParameterException(modele.getClass().toString()+" n'est pas un paramètre valide pour Controleur.getOrCreateFrom()");
    }

    @Override
    public Modele getModele() {
        return modele;
    }
    
    @Override
    public void ajouterVue(IVueControlee vue) {
        if(!(vue instanceof JComponent))
            throw new InvalidParameterException("La vue doit être un JComponent");
        
        if(!vues.contains(vue))
            vues.add(vue);
    }

    @Override
    public void retirerVue(IVueControlee vue) {
        if(!(vue instanceof JComponent))
            throw new InvalidParameterException("La vue doit être un JComponent");
        
        // on enlève toutes les vues du controleur correspondant à la vue passée en paramètre
        vues.removeIf(v -> (v == vue));
    }

}
