package dps3.vues.interfaces;

import java.awt.event.HierarchyListener;
import java.awt.event.HierarchyEvent;

public interface IVueControlee extends IVue, HierarchyListener {
    // contient un attribut :
    // private CModele controleur;
    // 
    // où CModele est une classe **concrète** implémentant IControleur
    
    // une vue controllée est une vue capable de recevoir des updates de la part d'un controleur
    // c'est à dire qu'elle fait partie de la liste des vues d'un contrôleur et qu'elle

    // son constructeur doit inclure un controleur dans ses paramètres


    // chaque vue controlée doit override la méthode
    //
    // @Override
    // protected void finalize() {
    //     this.controleur.retirerVue(this);
    // }

    
    // méthode permettant de savoir si la vue a été retirée de son parent
    // ------------------------------------------------------------------
    @Override
    public void hierarchyChanged(HierarchyEvent e);
    
    // cet méthode doit être implémentée comme suit
    // @Override
    // public default void hierarchyChanged(HierarchyEvent e) {
    //     if(e.getChangeFlags() == HierarchyEvent.PARENT_CHANGED) {
    //         if(this.getParent() == null)
    //             this.controleur.retirerVue(this);
    //         else
    //             this.controleur.ajouterVue(this);
    //     }
    // }
}
