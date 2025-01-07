package dps3.vues.partielles.main;

import java.security.InvalidParameterException;

import javax.swing.JPanel;

public class JPanelActionBar extends JPanel {
    
    public static enum Opt {
        BOUTONS_VUES,
        BOUTON_RETOUR;
    }
    
    public JPanelActionBar(Opt option) {
        switch (option) {
            case BOUTONS_VUES:
                
                break;
            case BOUTON_RETOUR:
                
                break;
            default: // n'essayez pas de cast un int en Opt, s.v.p.
                throw new InvalidParameterException("l'option doit être un membre de l'enum JPanelActionBar.Opt");
        }
    }
}
