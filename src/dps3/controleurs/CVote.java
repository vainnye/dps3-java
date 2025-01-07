package dps3.controleurs;

import java.util.ArrayList;

import dps3.modeles.Vote;
import dps3.vues.interfaces.IVueControlee;

public class CVote extends Controleur {
    CVote(Vote modele) {
        this.modele = modele;
        vues = new ArrayList<IVueControlee>();
    }

    @Override
    public Vote getModele() {
        return (Vote) super.getModele();
    }
}
