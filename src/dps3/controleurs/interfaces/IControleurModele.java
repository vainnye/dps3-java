package dps3.controleurs.interfaces;

import dps3.modeles.interfaces.IModele;

public interface IControleurModele extends IControleur {
    // contient deux attributs :
    // private Modele modele;
    // private ArrayList<IVueControlee> vues;
    // 
    // où Modele est une classe **concrète** implémentant IModele
    
    public IModele getModele();  // sera appelé par la vue
}
