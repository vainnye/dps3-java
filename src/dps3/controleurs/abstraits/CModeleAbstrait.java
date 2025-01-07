package dps3.controleurs.abstraits;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import javax.swing.JComponent;

import dps3.controleurs.interfaces.IControleurModele;
import dps3.modeles.interfaces.IModele;
import dps3.vues.interfaces.IVueControlee;

public abstract class CModeleAbstrait implements IControleurModele {
    protected IModele modele;
    protected ArrayList<IVueControlee> vues;

    public CModeleAbstrait(IModele modele) {
        this.modele = modele;
        vues = new ArrayList<IVueControlee>();
    }

    @Override
    public IModele getModele() {
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
