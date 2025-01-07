package dps3.controleurs;

import java.security.InvalidParameterException;

import javax.swing.JComponent;

import dps3.vues.JFrameApp;
import dps3.vues.JScrollPaneMain;
import dps3.vues.interfaces.IVueRemplacable;
import dps3.vues.partielles.main.JPanelGrandGroupe;

public class CApp {
    
    private static JFrameApp jf_vueFenetre = new JFrameApp();

    private CApp() {}

    public static void lancerApp() {
        jf_vueFenetre.setFullScreen();
        jf_vueFenetre.afficherConnexion();
        jf_vueFenetre.afficher();
    }
    
    public static void afficherAccueil() {
        jf_vueFenetre.afficherAccueil();
    }

    

    public static <T extends JComponent & IVueRemplacable> void changerVue(Class<T> classeVue,  Controleur sender) {
        if(classeVue.isInterface()) {
            String method = new Object(){}.getClass().getEnclosingMethod().getName();
            throw new InvalidParameterException(method+" n'accepte pas d'interface en paramètre");
        }
        
        if(classeVue == JPanelGrandGroupe.class) {
            JPanelGrandGroupe jp = new JPanelGrandGroupe((CGroupe)sender);
            jf_vueFenetre.getVuesActives().forEach(jc -> {if(jc instanceof JScrollPaneMain) ((JScrollPaneMain)jc).setJPanelCentered(jp);});
        }
        
        

    }

}
