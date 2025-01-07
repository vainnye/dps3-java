package dps3.vues.partielles.sideBar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import dps3.App;
import dps3.vues.interfaces.IVueControlee;
import dps3.vues.partielles.reutilisables.JButtonRound;
import dps3.vues.partielles.reutilisables.JPanelRound;

// cette classe étend la classe JPanel
// dans l'objectif d'un ajouter plus de composant plus tard :
// - icone du groupe
// - label avec nombre de membres
// - icone à côté de ce label 
//
// il faudra alors changer la comportement de cette classe
// pour que ce ne soit pas le bouton jb_nomGroupe qui génère l'événement

// TODO : implémenter IVueControlee
// TODO: ajouter un actionlistener au bouton pour qu'il interragisse avec les contrôleurs
public class JPanelPetitGroupe extends JPanelRound {
    private JButtonRound jb_nomGroupe;

    // TODO: modifier le contructeur en accord avec le design patern MVC (implémenter IVueControlee)
    public JPanelPetitGroupe(String nomGroupe) {
        super();
        setLayout(new BorderLayout());
        setBackground(new Color(0,0,0,0));
        setOpaque(false);
 
        jb_nomGroupe = new JButtonRound(nomGroupe);
        
        jb_nomGroupe.setFont(App.FONT_BUTTON);
        jb_nomGroupe.setRounds(20);
        jb_nomGroupe.setBackgroundColor(Color.WHITE);
        jb_nomGroupe.setActiveColor(Color.LIGHT_GRAY);
        jb_nomGroupe.setHorizontalAlignment(SwingConstants.LEFT);

        add(jb_nomGroupe, BorderLayout.CENTER);
    }
}
