package dps3.controleurs;

import java.util.ArrayList;

import dps3.modeles.Groupe;
import dps3.vues.interfaces.IVueControlee;

public class CGroupe extends Controleur {
    CGroupe(Groupe modele) {
        this.modele = modele;
        vues = new ArrayList<IVueControlee>();
    }

    @Override
    public Groupe getModele() {
        return (Groupe) super.getModele();
    }
}
