package dps3.controleurs.interfaces;

import dps3.modeles.interfaces.IModele;
import dps3.vues.interfaces.IVueControlee;

public interface IControleur {
    // voir la classe Controleur pour l'implémentation

    public IModele getModele();  // sera appelé par la vue
    public void ajouterVue(IVueControlee vue); // appelé dans le contructeur d'une vue
    public void retirerVue(IVueControlee vue); // appelé par une vue liée au controleur qui ne peux pas apparaître à l'écran
    public void updateLesVues();
}
