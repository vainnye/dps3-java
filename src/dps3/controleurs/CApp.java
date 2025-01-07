package dps3.controleurs;

import java.awt.BorderLayout;

import dps3.App;
import dps3.vues.JFrameApp;
import dps3.vues.JPanelSideBar;
import dps3.vues.JScrollPaneMain;
import dps3.vues.partielles.main.JPanelAccueil;

public class CApp {
    
    private static JFrameApp vue = new JFrameApp();

    private CApp() {}

    public static void lancerApp() {
        vue.setFullScreen();
        vue.afficherConnexion();
        vue.afficher();
    }
    

    public static void afficherAccueil() {
        vue.reset();
        CDecideur ctl = new CDecideur(App.getDecideur());
        vue.add(new JPanelSideBar(ctl), BorderLayout.WEST);

        // Groupe groupe = new Groupe("Un Nouveau groupe de plus qui fait vachement chier le monde j'en ai marre");
        // JScrollPaneMain mainPanel = new JScrollPaneMain(new JPanelGrandGroupe(groupe));
        JScrollPaneMain mainPanel = new JScrollPaneMain(new JPanelAccueil());
        
        
        vue.add(mainPanel, BorderLayout.CENTER);
    }


}
