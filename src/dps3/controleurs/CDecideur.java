package dps3.controleurs;

import dps3.controleurs.abstraits.CModeleAbstrait;
import dps3.modeles.Decideur;

public class CDecideur extends CModeleAbstrait {
    public CDecideur(Decideur modele) {
        super(modele);
    }

    public Decideur getModele() {
        return (Decideur)super.getModele();
    }
}
