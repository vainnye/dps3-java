package dps3.vues.interfaces;

public interface IVueRemplacable extends IVueControlee{
    // contient un attribut :
    // private CModele controleur;
    // 
    // où CModele est une classe **concrète** implémentant IControleur

    // son constructeur doit inclure un controleur dans ses paramètres


    /*
     * au final je me débrouille sans la méthode replaceBy(IVueRemplacable vue)
     * c'est plus simple
     * dans les dtous les cas c'est brouillon
     */
    // public void replaceBy(IVueRemplacable vue);





    // méthode héritée de IVueControlee permettant de savoir si la vue a été retirée de son parent
    // cet méthode doit être implémentée comme suit
    // ------------------------------------------------------------------
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
