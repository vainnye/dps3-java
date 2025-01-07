package dps3.controleurs;

import dps3.controleurs.abstraits.CModeleAbstrait;
import dps3.modeles.Vote;

public class CVote extends CModeleAbstrait {
    public CVote(Vote modele) {
        super(modele);
    }
    
    public Vote getModele() {
        return (Vote)super.getModele();
    }
}
