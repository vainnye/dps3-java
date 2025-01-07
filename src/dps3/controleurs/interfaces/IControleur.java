package dps3.controleurs.interfaces;

import dps3.vues.interfaces.IVueControlee;

public interface IControleur {
    // contient un attribut :
    // private ArrayList<IVueControlee> vues;

    public void ajouterVue(IVueControlee vue); // appelé dans le contructeur d'une vue
    public void retirerVue(IVueControlee vue); // appelé dans le **destructeur** d'une vue
    
}
