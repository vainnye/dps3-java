package dps3.vues;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import dps3.utils.ui.GBL;
import dps3.vues.partielles.connexion.JPanelFormConnexion;

public class JPanelConnexion extends JPanel {
    
    public JPanelConnexion() 
    {
        JPanelFormConnexion panel = new JPanelFormConnexion();

        setLayout(new GridBagLayout());
        GridBagConstraints c = GBL.getConstraint(0, 0);
        c.anchor = GridBagConstraints.CENTER;
        c.ipadx = 30;
        c.ipady = 30;
        add(panel, c);
        
        // solution alternative pour centrer le JPanelFormConnexion
        // ------------------------------------------------------
        // Box box = new Box(BoxLayout.Y_AXIS);
        // box.add(Box.createVerticalGlue());
        // box.add(panel);
        // box.add(Box.createVerticalGlue());
        // add(box);
    }
}