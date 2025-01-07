package dps3.controleurs;

import dps3.controleurs.abstraits.CModeleAbstrait;
import dps3.modeles.Groupe;

public class CGroupe extends CModeleAbstrait {
    public CGroupe(Groupe modele) {
        super(modele);
    }
    
    public Groupe getModele() {
        return (Groupe)super.getModele();
    }
}
