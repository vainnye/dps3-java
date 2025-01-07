package dps3.vues.interfaces;

public interface IVue {
    // cette vue est la plus basique, 
    // elle ne contient pas de contrôleur et est juste updatable
    // elle peut cependant contenir un modele qui est passé en argument de son constructeur
    // si elle ne contient pas de modele, sa seule utilité est de déléguer son update à une ou plusieurs de des vues filles
    //
    // cette vue ne fait que donner un retour visuel
    // aucune interraction n'est possible avec cette vue
    // elle est mise à jour par sa vue parente
    public void update();
}
