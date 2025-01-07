package dps3.controleurs;

import java.util.ArrayList;

import dps3.modeles.Decideur;
import dps3.vues.interfaces.IVueControlee;

public class CDecideur extends Controleur {
    CDecideur(Decideur modele) {
        this.modele = modele;
        vues = new ArrayList<IVueControlee>();
    }

    @Override
    public Decideur getModele() {
        return (Decideur) super.getModele();
    }

}
